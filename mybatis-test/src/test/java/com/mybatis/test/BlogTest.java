package com.mybatis.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.test.domain.Blog;

public class BlogTest {
	private static Reader reader;
	private static SqlSessionFactory sqlSessionFactory;
	private static SqlSession sqlSession;
	
	@Before
	public void init(){
		try {
			reader = Resources.getResourceAsReader("mybatisConfiguration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void selectBlog(){
		sqlSession = sqlSessionFactory.openSession();
		Blog blog = sqlSession.selectOne("com.mybatis.test.domain.Blog.selectBlog", 1);
		System.out.println(blog.getAuthor().getName());
	}
	
	@Test
	public void selectBlogTwo(){
		sqlSession = sqlSessionFactory.openSession();
		Blog blog = sqlSession.selectOne("com.mybatis.test.domain.Blog.selectBlogTwo", 1);
		System.out.println(blog.getAuthor().getName());
	}
	
	@Test
	public void selectBlogComment(){
		sqlSession = sqlSessionFactory.openSession();
		Blog blog = sqlSession.selectOne("com.mybatis.test.domain.Blog.selectBlogComments", 1);
		System.out.println(blog.getComments().get(0).getContent());
	}
	
	@Test
	public void selectBlogCollection(){
		sqlSession = sqlSessionFactory.openSession();
		Blog blog = sqlSession.selectOne("com.mybatis.test.domain.Blog.selectCollectionTwo", 1);
		System.out.println(blog.getComments().size());
	}
	
	@Test
	public void selectAll(){
		sqlSession = sqlSessionFactory.openSession();
		Blog blog = sqlSession.selectOne("com.mybatis.test.domain.Blog.selectAll", 1);
		System.out.println(blog.getComments().size());
	}
}
