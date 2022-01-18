/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
CarTypeController.java
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

import com.api.garagebackend.model.CarType;
import com.api.garagebackend.repository.CarTypeRepository;

//Controller class to process incoming REST API requests
@RestController
@RequestMapping("/api")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class CarTypeController {
	
	//Actions
	@Autowired
	private CarTypeRepository actions;
	
	//List car types
	@RequestMapping(value="/cartype", method=RequestMethod.GET)
	public @ResponseBody List<CarType> listCarType() {
		return actions.findAll();
	}
					
	//Create car types
	@RequestMapping(value="/cartype", method=RequestMethod.POST)
	public @ResponseBody CarType createCarType(@RequestBody CarType carType) {
		return actions.save(carType);
	}
					
	//Find car types
	@RequestMapping(value="/cartype/{name}", method=RequestMethod.GET)
	public @ResponseBody CarType findCarType(@PathVariable String name) {
		return actions.findByName(name);
	}
					
	//Update car types
	@RequestMapping(value="/cartype", method=RequestMethod.PUT)
	public @ResponseBody CarType updateCarType(@RequestBody CarType carType) {
		return actions.save(carType);
	}
					
	//Delete car types
	@RequestMapping(value="/cartype/{name}", method=RequestMethod.DELETE)
	public @ResponseBody void deleteCarType(@PathVariable String name) {
		CarType carType = findCarType(name);
		this.actions.delete(carType);
	}
			
	//List active car types (the ones that the garage is working with)
	@RequestMapping(value="/activecartype", method=RequestMethod.GET)
	public @ResponseBody List<CarType> activeCarType() {
		return actions.findByStatus("active");
	}

}
