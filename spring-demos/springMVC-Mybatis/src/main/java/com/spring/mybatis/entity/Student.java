package com.spring.mybatis.entity;

/**
 * Ñ§Éú
 * Created by lrz on 2015/9/2.
 */
public class Student {
	
	private Integer id;
	private String name;
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student[id=" + this.id + ", name=" + this.name + ",age=" + this.age + "]";
	}
}
