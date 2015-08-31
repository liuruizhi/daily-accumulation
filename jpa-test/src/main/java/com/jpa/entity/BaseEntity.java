package com.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.eclipse.persistence.annotations.UuidGenerator;

public class BaseEntity implements Serializable{
	private static final long serialVersionUID = -2309490282516013153L;
	
	@Id
	@GeneratedValue(generator = "UUID_GEN")
	@UuidGenerator(name = "UUID_GEN")
	@Column(name = "ID")
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
