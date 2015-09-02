package com.spring.mybatis.service;

import com.spring.mybatis.entity.Student;

/**
 * Created by lrz on 2015/9/2.
 */
public interface StudentService {
	public Student getById(Integer id);
	public void saveStudent(Student student);
}
