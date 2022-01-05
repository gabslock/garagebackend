/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
Supplies.java
Part of Ger's Garage Web Application - Guided Technology Project for CCT Dublin.
 */
package com.api.garagebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Model class for Supplies with database connection through JPA (Spring Boot)
@Entity
@Table(name="supplies")
public class Supplies {
	
	@Id
	@Column(name="productname")
	private String productname;
	
	@Column(name="unitprice")
	private double unitprice;
	
	public Supplies() {
		super();
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

}
