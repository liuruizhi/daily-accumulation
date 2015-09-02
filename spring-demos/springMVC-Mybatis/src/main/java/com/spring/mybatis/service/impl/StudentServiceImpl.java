package com.spring.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mybatis.dao.inter.StudentDAO;
import com.spring.mybatis.entity.Student;
import com.spring.mybatis.service.StudentService;

/**
 * Created by lrz on 2015/9/2.
 */
@Service
//@Transactional
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentDAO studentDAO;
	
	@Override
	public Student getById(Integer id){
		return studentDAO.getById(id);
	}
	
	@Override
	public void saveStudent(Student student){
		studentDAO.saveStudent(student);
	}
}
