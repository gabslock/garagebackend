/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
AdminController.java
Part of Ger's Garage Web Application - Guided Technology Project for CCT Dublin.
 */
package com.api.garagebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.garagebackend.model.Admin;
import com.api.garagebackend.model.User;
import com.api.garagebackend.repository.AdminRepository;

//Controller class to process incoming REST API requests
@RestController
@RequestMapping("/api")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class AdminController {
	
	//Actions
	@Autowired
	private AdminRepository actions;
	
	//List admin
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public @ResponseBody List<Admin> listAdmin() {
		return actions.findAll();
	}
		
	//Create admin
	@RequestMapping(value="/admin", method=RequestMethod.POST)
	public @ResponseBody Admin createAdmin(@RequestBody Admin admin) {
		return actions.save(admin);
	}
		
	//Find admin
	@RequestMapping(value="/admin/{adminid}", method=RequestMethod.GET)
	public @ResponseBody Admin findAdmin(@PathVariable Integer adminid) {
		return actions.findByAdminid(adminid);
	}
		
	//Update admin
	@RequestMapping(value="/admin", method=RequestMethod.PUT)
	public @ResponseBody Admin updateAdmin(@RequestBody Admin admin) {
		return actions.save(admin);
	}
		
	//Delete admin
	@RequestMapping(value="/admin/{adminid}", method=RequestMethod.DELETE)
	public @ResponseBody void deleteAdmin(@PathVariable Integer adminid) {
		Admin admin = findAdmin(adminid);
		this.actions.delete(admin);
	}
		
	//Find admin by email
	@RequestMapping(value="/admin/{email}", method=RequestMethod.GET)
	public @ResponseBody Admin findEmailAdmin(@PathVariable String email) {
	return actions.findByEmail(email);
		}

}
