package com.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.eclipse.persistence.annotations.UuidGenerator;

@MappedSuperclass
public class BaseEntity implements Serializable{
	private static final long serialVersionUID = -2309490282516013153L;
	
	@UuidGenerator(name = "UUID_GEN")
	@Id
//	@GeneratedValue(generator = "UUID_GEN")
	@Column(name = "ID")
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
