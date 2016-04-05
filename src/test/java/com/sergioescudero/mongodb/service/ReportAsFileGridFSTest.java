package com.sergioescudero.mongodb.service;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.List;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javamex.classmexer.MemoryUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.sergioescudero.model.report.Report;
import com.sergioescudero.services.UtilsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/conf/application-context.xml" })
public class ReportAsFileGridFSTest {

	@Autowired
	private transient ApplicationContext appContext;

	@Autowired
	@Qualifier("utilsService")
	private UtilsService utilService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void addReportsAsFile() throws MarshalException, ValidationException, FileNotFoundException, IOException {
		final GridFsOperations gridOperations = (GridFsOperations) appContext.getBean("gridFsTemplate");

		ClassLoader classLoader = getClass().getClassLoader();
		File dir = new File(classLoader.getResource("xml").getFile());
		FilenameFilter xmlFilter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				String lowercaseName = name.toLowerCase();
				if (lowercaseName.endsWith(".xml")) {
					return true;
				} else {
					return false;
				}
			}
		};

		for (File ficheroXML : dir.listFiles(xmlFilter)) {

			long inicio = System.currentTimeMillis();
			Report report = utilService.loadReportFromResource(ficheroXML);
			long fin = System.currentTimeMillis();
			
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
			
			System.out.println("Tiempo empleado para cargar fichero (XML -> Report)" + ficheroXML.getName() + " de " + ficheroXML.length() / (1024 * 1024) + " MB.:"
					+ (fin - inicio)  + " ms.");

			long noBytes = MemoryUtil.deepMemoryUsageOf(report);
			System.out.println("Tamaño en memoria " + noBytes / (1024 * 1024) + " MB");

			// conversión a inputstream
			inicio = System.currentTimeMillis();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(report);
			oos.flush();
			oos.close();
			InputStream is = new ByteArrayInputStream(baos.toByteArray());
			fin = System.currentTimeMillis();
			System.out.println("Tiempo empleado para meter objeto en fichero " + ficheroXML.getName() + " de " + ficheroXML.length() / (1024 * 1024)
					+ " MB.:" + (fin - inicio)  + " ms.");

			DBObject metaData = new BasicDBObject();
			metaData.put("id", report.getId());
			metaData.put("date", new Date());

			inicio = System.currentTimeMillis();
			gridOperations.store(is, report.getId(), null, metaData);

			fin = System.currentTimeMillis();

			System.out.println("Tiempo empleado para guardar Report en MongoDB " + ficheroXML.getName() + " de " + ficheroXML.length()
					/ (1024 * 1024) + " MB.:" + (fin - inicio)  + " ms.");

		}

		assertTrue("No encuentra los datos", true);

	}

	@Test
	public void readReportsAsFile() throws MarshalException, ValidationException, FileNotFoundException, IOException, ClassNotFoundException {
		final GridFsOperations gridOperations = (GridFsOperations) appContext.getBean("gridFsTemplate");

		String idFichero = "E1140_E1526_20160203_115911";

		long inicio = System.currentTimeMillis();
		List<GridFSDBFile> result = gridOperations.find(new Query().addCriteria(Criteria.where("metadata.id").is(idFichero)));
		long fin = System.currentTimeMillis();

		System.out.println("Tiempo empleado en leer de MongoDB: " + (fin - inicio)  + " ms.");

		for (GridFSDBFile file : result) {

			inicio = System.currentTimeMillis();
			ObjectInputStream is = new ObjectInputStream(file.getInputStream());
			Report report = (Report) is.readObject();
			fin = System.currentTimeMillis();

			System.out.println("Tiempo empleado en deserializar fichero [" + report.getId() + " - " + file.getMetaData().get("date") + "] "
					+ (fin - inicio) / 1000 + " segundos");
		}

	}
}
