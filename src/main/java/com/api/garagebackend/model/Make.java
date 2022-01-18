/*
@name: Gabriel Juc�
@date: 22nd Jan 2022
Make.java
Part of Ger's Garage Web Application - Guided Technology Project for CCT Dublin.
 */
package com.api.garagebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Model class for Car Make with database connection through JPA (Spring Boot)
@Entity
@Table(name="make")
public class Make {
	
	@Id
	@Column(name="name")
	private String name;
	
	@Column(name="status")
	private String status;

	public Make() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
