/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
BookingItemsController.java
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

import com.api.garagebackend.model.BookingItems;
import com.api.garagebackend.repository.BookingItemsRepository;

//Controller class to process incoming REST API requests
@RestController
@RequestMapping("/api")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class BookingItemsController {
	
	//Actions
	@Autowired
	private BookingItemsRepository actions;
		
	//List booking items
	@RequestMapping(value="/bookingitems", method=RequestMethod.GET)
	public @ResponseBody List<BookingItems> listBookingItems() {
		return actions.findAll();
	}
		
	//Create booking items
	@RequestMapping(value="/bookingitems", method=RequestMethod.POST)
	public @ResponseBody BookingItems createBookingItems(@RequestBody BookingItems bookingitems) {
		return actions.save(bookingitems);
	}
		
	//Find booking items
	@RequestMapping(value="/bookingitems/{bookingitemid}", method=RequestMethod.GET)
	public @ResponseBody BookingItems findBookingItems(@PathVariable Integer bookingitemid) {
		return actions.findByBookingitemid(bookingitemid);
	}
		
	//Update booking items
	@RequestMapping(value="/bookingitems", method=RequestMethod.PUT)
	public @ResponseBody BookingItems updateBookingItems(@RequestBody BookingItems bookingitems) {
		return actions.save(bookingitems);
	}
		
	//Delete booking items
	@RequestMapping(value="/bookingitems/{bookingitemid}", method=RequestMethod.DELETE)
	public @ResponseBody void deleteBookingItems(@PathVariable Integer bookingitemid) {
		BookingItems bookingitems = findBookingItems(bookingitemid);
		this.actions.delete(bookingitems);
	}	

}
