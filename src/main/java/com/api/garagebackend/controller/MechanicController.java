/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
MechanicController.java
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

import com.api.garagebackend.model.Mechanic;
import com.api.garagebackend.repository.MechanicRepository;

//Controller class to process incoming REST API requests
@RestController
@RequestMapping("/api")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class MechanicController {
	
	//Actions
	@Autowired
	private MechanicRepository actions;
	
	//List supplies
	@RequestMapping(value="/mechanic", method=RequestMethod.GET)
	public @ResponseBody List<Mechanic> listMechanic() {
		return actions.findAll();
	}
			
	//Create mechanics
	@RequestMapping(value="/mechanic", method=RequestMethod.POST)
	public @ResponseBody Mechanic createMechanic(@RequestBody Mechanic mechanic) {
		return actions.save(mechanic);
	}
			
	//Find mechanics
	@RequestMapping(value="/mechanic/{name}", method=RequestMethod.GET)
	public @ResponseBody Mechanic findMechanic(@PathVariable String name) {
		return actions.findByName(name);
	}
			
	//Update mechanics
	@RequestMapping(value="/mechanic", method=RequestMethod.PUT)
	public @ResponseBody Mechanic updateMechanic(@RequestBody Mechanic mechanic) {
		return actions.save(mechanic);
	}
			
	//Delete mechanics
	@RequestMapping(value="/mechanic/{name}", method=RequestMethod.DELETE)
	public @ResponseBody void deleteMechanic(@PathVariable String name) {
		Mechanic mechanic = findMechanic(name);
		this.actions.delete(mechanic);
	}
	
	//List active mechanics (the ones that are working)
	@RequestMapping(value="/activemechanics", method=RequestMethod.GET)
	public @ResponseBody List<Mechanic> activeMechanic() {
		return actions.findByStatus("active");
	}

}
