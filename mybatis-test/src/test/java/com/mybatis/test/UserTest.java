package com.mybatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.test.domain.User;
import com.mybatis.test.inter.UserOperation;

public class UserTest {
	private static Reader reader;
	private static SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	
	@Before
	public void init() throws IOException{
		reader = Resources.getResourceAsReader("mybatisConfiguration.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	@Test
	public void select(){
		sqlSession = sqlSessionFactory.openSession();
		User user = (User)sqlSession.selectOne("com.mybatis.test.UserMapper.selectUserByID", 1);
		System.out.println(user.getName());
	}
	
	@Test
	public void selectAll(){
		sqlSession = sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList("com.mybatis.test.UserMapper.selectAll");
		for(User u : list){
			System.out.println(u.getName());
		}
	}
	
	@Test
	public void insert(){
		sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setName("rui");
		sqlSession.insert("com.mybatis.test.UserMapper.insertUser", user);
		sqlSession.commit();
//		System.out.println(user.getName());
	}
	
	@Test
	public void updateUser(){
		sqlSession = sqlSessionFactory.openSession();
//		sqlSession.update("com.mybatis.test.inter.UserOperation.updateUser", 1);
//		sqlSession.commit();
		UserOperation userOperation = sqlSession.getMapper(UserOperation.class);
		userOperation.updateUser(1);
		sqlSession.commit();
	}
}
