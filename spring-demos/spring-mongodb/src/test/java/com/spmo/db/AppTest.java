package com.spmo.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.spmo.entity.Person;
import com.spmo.repository.PersonRepository;

@SpringBootApplication
//@EnableMongoRepositories用于从指定的位置加载所需要的类
@EnableMongoRepositories(basePackageClasses=com.spmo.repository.PersonRepository.class)
public class AppTest implements CommandLineRunner{
	
	@Autowired
	private PersonRepository personRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AppTest.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		personRepository.deleteAll();
		personRepository.save(new Person("lius", 34));
		
		System.out.println(personRepository.findByName("lius"));
		
	}
}
