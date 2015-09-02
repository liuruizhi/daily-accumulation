package com.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mybatis.dao.impl.StudentDAOImpl;
import com.spring.mybatis.entity.Student;
import com.spring.mybatis.service.impl.StudentServiceImpl;

/**
 * Created by lrz on 2015/9/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:spring-mybatis.xml"})
public class TestApplication {
	
	Logger logger = LoggerFactory.getLogger(TestApplication.class);
	
	
	
	@Autowired
	private StudentDAOImpl studentDAOImpl;
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
    @Test
    public void testService(){
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml", "spring-mybatis.xml"});
//
//        System.out.println(classPathXmlApplicationContext.getBean("sqlSessionFactory"));
//    	Student student = new Student();
//    	student.setId(1);
//    	student.setAge(1);
//    	student.setName("liu");
//    	studentDAOImpl.saveStudent(student);
    	Student student = studentDAOImpl.getById(1);
    	logger.info("hello");
    	System.out.println(student.getName());
    	Student student1 = new Student();
    	student1.setId(5);
    	student1.setAge(1);
    	student1.setName("liu");
    	studentServiceImpl.saveStudent(student1);
    	
    	Student s = studentServiceImpl.getById(2);
    	System.out.println(s);
    }
}
