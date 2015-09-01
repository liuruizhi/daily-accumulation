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
		
		//通过properties文件配置属性
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("entitymangerfactory",properties);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//开启事物
		entityManager.getTransaction().begin();
		
		//新增对象
		Student s = new Student();
		s.setId("uuid");
		s.setAge(11);
		s.setName("test");
		entityManager.persist(s);
		
		//查询数据
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
