/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
BookingItems.java
Part of Ger's Garage Web Application - Guided Technology Project for CCT Dublin.
 */
package com.api.garagebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Model class for Bookings Items with database connection through JPA (Spring Boot)
@Entity
@Table(name="bookingitems")
public class BookingItems {
	
	@Id
	@Column(name="bookingitemid")
	private int bookingitemid;
	
	@Column(name="bookingid")
	private int bookingid;
	
	@Column(name="productname")
	private String productname;
	
	@Column(name="unitprice")
	private double unitprice;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="totalprice")
	private double totalprice;
	
	public BookingItems() {
	}

	public int getBookingitemid() {
		return bookingitemid;
	}

	public void setBookingitemid(int bookingitemid) {
		this.bookingitemid = bookingitemid;
	}



	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	
}
