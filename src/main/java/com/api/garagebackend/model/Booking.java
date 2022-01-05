/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
Booking.java
Part of Ger's Garage Web Application - Guided Technology Project for CCT Dublin.
 */
package com.api.garagebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Model class for Bookings with database connection through JPA (Spring Boot)
@Entity
@Table(name="bookings")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bookingid")
	private int bookingid;
	
	@Column(name="userid")
	private int userid;
	
	@Column(name="vehicleplate")
	private String vehicleplate;
	
	@Column(name="vehicletype")
	private String vehicletype;
	
	@Column(name="vehiclemake")
	private String vehiclemake;
	
	@Column(name="vehiclemodel")
	private String vehiclemodel;
	
	@Column(name="vehicleyear")
	private String vehicleyear;
	
	@Column(name="vehicleengine")
	private String vehicleengine;
	
	@Column(name="date")
	private String date;
	
	@Column(name="bookingtype")
	private String bookingtype;
	
	@Column(name="bookingstatus")
	private String bookingstatus;
	
	@Column(name="mechanic")
	private String mechanic;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="serviceindex")
	private int serviceindex;
	
	public Booking() {
		super();
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getVehicleplate() {
		return vehicleplate;
	}

	public void setVehicleplate(String vehicleplate) {
		this.vehicleplate = vehicleplate;
	}

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}

	public String getVehiclemake() {
		return vehiclemake;
	}

	public void setVehiclemake(String vehiclemake) {
		this.vehiclemake = vehiclemake;
	}

	public String getVehicleengine() {
		return vehicleengine;
	}

	public void setVehicleengine(String vehicleengine) {
		this.vehicleengine = vehicleengine;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBookingtype() {
		return bookingtype;
	}

	public void setBookingtype(String bookingtype) {
		this.bookingtype = bookingtype;
	}

	public String getBookingstatus() {
		return bookingstatus;
	}

	public void setBookingstatus(String bookingstatus) {
		this.bookingstatus = bookingstatus;
	}

	public String getMechanic() {
		return mechanic;
	}

	public void setMechanic(String mechanic) {
		this.mechanic = mechanic;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getServiceindex() {
		return serviceindex;
	}

	public void setServiceindex(int serviceindex) {
		this.serviceindex = serviceindex;
	}

	public String getVehiclemodel() {
		return vehiclemodel;
	}

	public void setVehiclemodel(String vehiclemodel) {
		this.vehiclemodel = vehiclemodel;
	}

	public String getVehicleyear() {
		return vehicleyear;
	}

	public void setVehicleyear(String vehicleyear) {
		this.vehicleyear = vehicleyear;
	}

}
