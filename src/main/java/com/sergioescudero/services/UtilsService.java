package com.sergioescudero.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.springframework.stereotype.Service;

import com.sergioescudero.model.report.Report;

@Service("utilsService")
public class UtilsService {

	private Unmarshaller unmarshaller;

	public Unmarshaller getUnmarshaller() {
		return unmarshaller;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

	public Report loadReportFromResource(File ficheroXML) throws IOException, FileNotFoundException, MarshalException, ValidationException {
		Reader fileReader = new FileReader(ficheroXML);

		Report report = (Report) unmarshaller.unmarshal(fileReader);

		fileReader.close();
		return report;
	}

}
