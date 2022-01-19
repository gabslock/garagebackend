/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
ServiceController.java
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

import com.api.garagebackend.model.Service;
import com.api.garagebackend.repository.ServiceRepository;

//Controller class to process incoming REST API requests
@RestController
@RequestMapping("/api")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class ServiceController {
	
	//Actions
	@Autowired
	private ServiceRepository actions;
	
	//List services
	@RequestMapping(value="/service", method=RequestMethod.GET)
	public @ResponseBody List<Service> listService() {
		return actions.findAll();
	}
				
	//Create services
	@RequestMapping(value="/service", method=RequestMethod.POST)
	public @ResponseBody Service createServicec(@RequestBody Service service) {
		return actions.save(service);
	}
				
	//Find services
	@RequestMapping(value="/service/{name}", method=RequestMethod.GET)
	public @ResponseBody Service findService(@PathVariable String name) {
		return actions.findByName(name);
	}
				
	//Update services
	@RequestMapping(value="/service", method=RequestMethod.PUT)
	public @ResponseBody Service updateService(@RequestBody Service service) {
		return actions.save(service);
	}
				
	//Delete service
	@RequestMapping(value="/service/{name}", method=RequestMethod.DELETE)
	public @ResponseBody void deleteService(@PathVariable String name) {
		Service service = findService(name);
		this.actions.delete(service);
	}
		
	//List active services (the ones that the Garage is doing)
	@RequestMapping(value="/activeservices", method=RequestMethod.GET)
	public @ResponseBody List<Service> activeService() {
		return actions.findByStatus("active");
	}

}
