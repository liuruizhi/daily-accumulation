package com.spring.mybatis.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mybatis.dao.inter.StudentDAO;
import com.spring.mybatis.entity.Student;

@Repository
public class StudentDAOImpl {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void saveStudent(Student student) {
		sqlSessionTemplate.insert("com.spring.mybatis.entity.Students.save", student);
	}
	/*
	 * 由于StudentDAO只是一个接口，没有相应的实现类，所以此处用此方式
	 * 当然，spring为我们提供了另一种方式，可以通过声明bean的方式来直接注入
	 * 通过转换器MapperScannerConfigurer，具体见配置文件中
	 */

	public Student getById(Integer id) {
		StudentDAO studentDAO = sqlSessionTemplate.getMapper(StudentDAO.class);
		return studentDAO.getById(id);
	}
}
