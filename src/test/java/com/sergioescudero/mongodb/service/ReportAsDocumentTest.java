package com.sergioescudero.mongodb.service;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Date;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javamex.classmexer.MemoryUtil;
import com.sergioescudero.model.report.Report;
import com.sergioescudero.model.report.ReportData;
import com.sergioescudero.services.UtilsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/conf/application-context.xml" })
public class ReportAsDocumentTest {

	@Autowired
	private transient ApplicationContext appContext;

	@Autowired
	@Qualifier("utilsService")
	private UtilsService utilService;

	@Before
	public void setUp() throws Exception {
	}

	@Test(expected = org.bson.BsonSerializationException.class)
	public void addReports() throws MarshalException, ValidationException, FileNotFoundException, IOException {
		final MongoOperations mo = (MongoOperations) appContext.getBean("mongoTemplate");

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

			System.out.println("Tiempo empleado para cargar fichero " + ficheroXML.getName() + " de " + ficheroXML.length() / (1024 * 1024) + " MB.:"
					+ (fin - inicio) / 1000 + " segundos");

			long noBytes = MemoryUtil.memoryUsageOf(report);
			System.out.println("Tamaño en memoria " + noBytes / (1024 * 1024) + " MB");

			ReportData rd = new ReportData();
			rd.setReport(report);
			rd.setId(report.getId());
			rd.setDate(new Date());
			inicio = System.currentTimeMillis();
			mo.save(rd);
			fin = System.currentTimeMillis();

			System.out.println("Tiempo empleado para guardar Report en MongoDB " + ficheroXML.getName() + " de " + ficheroXML.length()
					/ (1024 * 1024) + " MB.:" + (fin - inicio) / 1000 + " segundos");

		}

		assertTrue("No encuentra los datos", true);

	}
}
