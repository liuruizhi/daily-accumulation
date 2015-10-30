package com.spmo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spmo.entity.Person;
import com.spmo.repository.PersonRepository;

/**
 * 若想运行此类，需与相关类放在同一目录下（此处为PersonRepository）
 * 
 * @author lrz
 *
 */

@SpringBootApplication
public class AppTest implements CommandLineRunner{
	
	@Autowired
	private PersonRepository personRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AppTest.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		//清空库
		personRepository.deleteAll();
		
		//添加数据
		personRepository.save(new Person("zhangsan", 34));
		personRepository.save(new Person("lisi", 34));
		personRepository.save(new Person("wangwu", 34));
		
		for(Person p : personRepository.findAll()){
			System.out.println(p);
		}
		
	}
}
