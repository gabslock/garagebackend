/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
Service.java
Part of Ger's Garage Web Application - Guided Technology Project for CCT Dublin.
 */
package com.api.garagebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Model class for Service (booking types) with database connection through JPA (Spring Boot)
@Entity
@Table(name="service")
public class Service {
	
	@Id
	@Column(name="name")
	private String name;
	
	@Column(name="status")
	private String status;

	public Service() {
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
