package com.sergioescudero.mongodb.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sergioescudero.model.AuxiliarTable;
import com.sergioescudero.model.KeyValue;
import com.sergioescudero.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/conf/application-context.xml" })
public class MongoDBTest {

	@Autowired
	private transient ApplicationContext appContext;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void getAccessToBean() {
		final MongoOperations mo = (MongoOperations) appContext.getBean("mongoTemplate");

		Query searchUserQuery = new Query(Criteria.where("usuario").is("sergioescudero"));
		User savedUser = mo.findOne(searchUserQuery, User.class);
		if (savedUser == null) {
			User user = new User();
			user.setUsername("sergioescudero");
			user.setPassword("123456");
			mo.save(user);
		}
		searchUserQuery = new Query(Criteria.where("usuario").is("sergioescudero"));

		savedUser = mo.findOne(searchUserQuery, User.class);

		assertTrue("No se ha insertado correctamente el usuario: " + savedUser.toString(), savedUser != null);

	}

	@Test
	public void addAuxiliarTables() {
		final MongoOperations mo = (MongoOperations) appContext.getBean("mongoTemplate");

		AuxiliarTable at = new AuxiliarTable();
		at.setId("reportId to close time");
		mo.save(at);

		at = new AuxiliarTable();
		at.setId("requester_company_codes");
		mo.save(at);

		AuxiliarTable companies = new AuxiliarTable();
		companies.setId("companies and periods to reports");
		List<KeyValue> listaCompanies = new ArrayList<KeyValue>();
		KeyValue kv = new KeyValue();
		kv.setKey("E1504_E1526_2016_3");
		kv.setValue("E1504_E1526_20160203_114150");
		listaCompanies.add(kv);
		kv = new KeyValue();
		kv.setKey("E1504_E1526_2016_3");
		kv.setValue("E1504_E1526_20160203_114150");
		listaCompanies.add(kv);
		companies.setData(listaCompanies);
		mo.save(companies);

		at = new AuxiliarTable();
		at.setId("reportId to close time");
		mo.save(at);

		at = new AuxiliarTable();
		at.setId("requested_company_codes");
		mo.save(at);

		AuxiliarTable job = new AuxiliarTable();
		job.setId("reportId to jobExecutionId");
		List<KeyValue> lista = new ArrayList<KeyValue>();
		KeyValue kv2 = new KeyValue();
		kv2.setKey("E1504_E1526_20160203_114150");
		kv2.setValue("2");
		lista.add(kv2);
		kv2 = new KeyValue();
		kv2.setKey("E1526_E1504_20160203_122735");
		kv2.setValue("3");
		lista.add(kv2);
		job.setData(lista);
		mo.save(job);

		at = new AuxiliarTable();
		at.setId("company_names");
		mo.save(at);

		Query searchreportId2JobExecutionIdQuery = new Query(Criteria.where("id").is("reportId to jobExecutionId").and("data.key")
				.is("E1504_E1526_20160203_114150"));

		AuxiliarTable tabla = mo.findOne(searchreportId2JobExecutionIdQuery, AuxiliarTable.class);

		assertTrue("No encuentra los datos", tabla.getData().get(0).getValue().equalsIgnoreCase("2"));

	}
}
