package com.jpa.entity;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class SaveTest {
	
	@Test
	public void createTable() throws Exception{
		Properties properties = new Properties();
		Reader reader = new InputStreamReader(new FileInputStream("src/test/resources/database.properties"));
		properties.load(reader);
		System.out.println(properties.getProperty("driver_h2"));
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("entitymangerfactory");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManagerFactory.close();
//		DatabaseUtils databaseUtils = new DatabaseUtils();
//		databaseUtils.getConnection();
	}
}
