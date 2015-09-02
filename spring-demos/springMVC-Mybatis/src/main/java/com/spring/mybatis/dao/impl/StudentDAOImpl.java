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
	 * ����StudentDAOֻ��һ���ӿڣ�û����Ӧ��ʵ���࣬���Դ˴��ô˷�ʽ
	 * ��Ȼ��springΪ�����ṩ����һ�ַ�ʽ������ͨ������bean�ķ�ʽ��ֱ��ע��
	 * ͨ��ת����MapperScannerConfigurer������������ļ���
	 */

	public Student getById(Integer id) {
		StudentDAO studentDAO = sqlSessionTemplate.getMapper(StudentDAO.class);
		return studentDAO.getById(id);
	}
}
