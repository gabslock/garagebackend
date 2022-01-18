/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
MakeController.java
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

import com.api.garagebackend.model.Make;
import com.api.garagebackend.repository.MakeRepository;

//Controller class to process incoming REST API requests
@RestController
@RequestMapping("/api")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class MakeController {
	
	//Actions
	@Autowired
	private MakeRepository actions;
	
	//List car makes
	@RequestMapping(value="/make", method=RequestMethod.GET)
	public @ResponseBody List<Make> listMake() {
		return actions.findAll();
	}
				
	//Create car make
	@RequestMapping(value="/make", method=RequestMethod.POST)
	public @ResponseBody Make createMake(@RequestBody Make make) {
		return actions.save(make);
	}
				
	//Find car make
	@RequestMapping(value="/make/{name}", method=RequestMethod.GET)
	public @ResponseBody Make findMake(@PathVariable String name) {
		return actions.findByName(name);
	}
				
	//Update car make
	@RequestMapping(value="/make", method=RequestMethod.PUT)
	public @ResponseBody Make updateMake(@RequestBody Make make) {
		return actions.save(make);
	}
				
	//Delete car make
	@RequestMapping(value="/make/{name}", method=RequestMethod.DELETE)
	public @ResponseBody void deleteMake(@PathVariable String name) {
		Make make = findMake(name);
		this.actions.delete(make);
	}
		
	//List active car make (the ones that the garage is working with)
	@RequestMapping(value="/activemake", method=RequestMethod.GET)
	public @ResponseBody List<Make> activeMake() {
		return actions.findByStatus("active");
	}

}
