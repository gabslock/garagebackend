/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
SuppliesController.java
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

import com.api.garagebackend.model.Supplies;
import com.api.garagebackend.repository.SuppliesRepository;

//Controller class to process incoming REST API requests
@RestController
@RequestMapping("/api")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class SuppliesController {
	
	//Actions
	@Autowired
	private SuppliesRepository actions;
	
	//List supplies
	@RequestMapping(value="/supplies", method=RequestMethod.GET)
	public @ResponseBody List<Supplies> listSupplies() {
		return actions.findAll();
	}
		
	//Create supplies
	@RequestMapping(value="/supplies", method=RequestMethod.POST)
	public @ResponseBody Supplies createSupplies(@RequestBody Supplies supplies) {
		return actions.save(supplies);
	}
		
	//Find supplies
	@RequestMapping(value="/supplies/{productname}", method=RequestMethod.GET)
	public @ResponseBody Supplies findSupplies(@PathVariable String productname) {
		return actions.findByProductname(productname);
	}
		
	//Update supplies
	@RequestMapping(value="/supplies", method=RequestMethod.PUT)
	public @ResponseBody Supplies updateSupplies(@RequestBody Supplies supplies) {
		return actions.save(supplies);
	}
		
	//Delete supplies
	@RequestMapping(value="/supplies/{productname}", method=RequestMethod.DELETE)
	public @ResponseBody void deleteSupplies(@PathVariable String productname) {
		Supplies supplies = findSupplies(productname);
		this.actions.delete(supplies);
	}

}
