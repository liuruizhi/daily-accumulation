package com.spring.mybatis.dao.inter;

import com.spring.mybatis.entity.Student;

public interface StudentDAO {
	public Student getById(Integer id);

	public void saveStudent(Student student);

	public void updateStudent(Student student);

	public void deleteStudent(Student student);
}
