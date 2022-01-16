/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
Mechanic.java
Part of Ger's Garage Web Application - Guided Technology Project for CCT Dublin.
 */
package com.api.garagebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Model class for Mechanics with database connection through JPA (Spring Boot)
@Entity
@Table(name="mechanic")
public class Mechanic {
	
	@Id
	@Column(name="name")
	private String name;
	
	@Column(name="status")
	private String status;

	public Mechanic() {
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
