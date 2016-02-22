package com.sergioescudero.parser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;
import org.springframework.beans.factory.annotation.Required;

import com.sergioescudero.model.report.Report;
import com.sergioescudero.services.DateHandler;
import com.sergioescudero.services.DateStringUtils;
import com.sergioescudero.services.FileUtils;

public class XmlReportParser /* implements InitializingBean */{

	private CastorXMLContextFactoryBean xmlContextFactoryBean;

	// private Marshaller marshall;
	// private Unmarshaller unmarshaller;

	public CastorXMLContextFactoryBean getXmlContextFactoryBean() {
		return xmlContextFactoryBean;
	}

	@Required
	public void setXmlContextFactoryBean(CastorXMLContextFactoryBean xmlContextFactoryBean) {
		this.xmlContextFactoryBean = xmlContextFactoryBean;
	}

	// /**
	// * @return the marshall
	// */
	// public Marshaller getMarshall() {
	// return marshall;
	// }
	//
	// /**
	// * @param marshall the marshall to set
	// */
	// public void setMarshall(Marshaller marshall) {
	// this.marshall = marshall;
	// }
	//
	// /**
	// * @return the unmarshaller
	// */
	// public Unmarshaller getUnmarshaller() {
	// return unmarshaller;
	// }
	//
	// /**
	// * @param unmarshaller the unmarshaller to set
	// */
	// public void setUnmarshaller(Unmarshaller unmarshaller) {
	// this.unmarshaller = unmarshaller;
	// }

	public void parseReport(Report report) throws ParseException {
		String dateCreation = report.getDateCreation();
		String timeCreation = report.getTimeCreation();

		long time = DateStringUtils.parseStringToDate(dateCreation, DateHandler.getDateFormat()).getTime();

		Date date = new Date(time + getTime(timeCreation));

		report.setCreationDate(date);
	}

	public Report getReport(File fileSource) throws MarshalException, ValidationException, IOException, Exception {
		FileUtils.preProcessFileSource(fileSource);
		Reader fileReader = new FileReader(fileSource);

		Report report = (Report) xmlContextFactoryBean.createUnmarshaller().unmarshal(fileReader);

		fileReader.close();

		return report;
	}

	public File writeXMLReport(Report report, File targetDirectory) throws IOException, MarshalException, ValidationException, Exception {
		Marshaller marshall = xmlContextFactoryBean.createMarshaller();
		FileUtils.createDirectory(targetDirectory);
		String targetFileName = (report.getId()).concat(".").concat("xml");

		File targetFile = new File(targetDirectory, targetFileName);
		FileUtils.createFileOrDirectoryIfNotExists(targetFile);

		Writer writer = new FileWriter(targetFile);
		marshall.setWriter(writer);
		marshall.marshal(report);
		writer.close();

		return targetFile;

	}

	public void updateReport(Report report) {
		List<String> componentList = getReportIdCompoments(report);

		String socGlRequester = componentList.get(0);
		String socGlRequested = componentList.get(1);

		String dateTime = changeDateAndTime();

		String reportId = socGlRequester.concat("_").concat(socGlRequested).concat("_").concat(dateTime);

		// String socGlRequester = report.getRequesterHfm();
		// String socGlRequested = report.getRequestedHfm();
		// String period = report.getFiscalYear() + "_" + report.getPeriod();
		// String reportId =
		// socGlRequester.concat("_").concat(socGlRequested).concat("_").concat(period);

		report.setId(reportId);

	}

	private List<String> getReportIdCompoments(Report report) {
		String reportId = report.getId();
		List<String> tokens = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(reportId, "_");
		while (st.hasMoreElements()) {
			tokens.add(st.nextToken());
		}
		return tokens;
	}

	private String changeDateAndTime() {
		Date currentDate = new Date();
		String result = DateStringUtils.parseDateToString(currentDate, "yyyyMMdd_kkmmss");
		return result;
	}

	private long getTime(String value) {
		String[] timeFormat = value.split(":");
		long hour = Long.parseLong(timeFormat[0]);
		long minute = Long.parseLong(timeFormat[1]);
		long second = Long.parseLong(timeFormat[2]);

		long time = (3600 * hour + 60 * minute + second) * 1000;

		return time;
	}

	// @Override
	// public void afterPropertiesSet() throws Exception {
	// String nullMessage = "cannot be null";
	// Assert.notNull(marshall, "property marshall ".concat(nullMessage));
	// Assert.notNull(unmarshaller,
	// "property unmarshaller ".concat(nullMessage));
	// }
}
