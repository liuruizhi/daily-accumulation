package com.spmo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spmo.entity.Person;
import com.spmo.repository.PersonRepository;

/**
 * �������д��࣬������������ͬһĿ¼�£��˴�ΪPersonRepository��
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
		//��տ�
		personRepository.deleteAll();
		
		//�������
		personRepository.save(new Person("zhangsan", 34));
		personRepository.save(new Person("lisi", 34));
		personRepository.save(new Person("wangwu", 34));
		
		for(Person p : personRepository.findAll()){
			System.out.println(p);
		}
		
	}
}
