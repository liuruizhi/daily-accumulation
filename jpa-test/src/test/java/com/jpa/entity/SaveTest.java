package com.jpa.entity;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

public class SaveTest {

	@Test
	public void createTable() throws Exception {
		Properties properties = new Properties();
		Reader reader = new InputStreamReader(new FileInputStream(
				"src/test/resources/database.properties"));
		properties.load(reader);
		System.out.println(properties.getProperty("driver_h2"));
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("entitymangerfactory");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//开启事物
		entityManager.getTransaction().begin();
		
		Student s = new Student();
		s.setId("uuid");
		s.setAge(11);
		s.setName("test");
		entityManager.persist(s);
		
		Query query = entityManager.createQuery("select t from Student t");

		List<Student> l = query.getResultList();
		//提交事物
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		for (Student student : l) {
			System.out.println(student.getName());
		}
	}

	@Test
	public void testConnection() throws Exception {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa",
				"");
		// add application code here
		System.out.println(conn);
		conn.close();
	}
}
