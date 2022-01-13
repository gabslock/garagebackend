/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
BookingItemController.java
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

import com.api.garagebackend.model.BookingItem;
import com.api.garagebackend.repository.BookingItemRepository;

@RestController
@RequestMapping("/api")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class BookingItemController {
	
	//Actions
	@Autowired
	private BookingItemRepository actions;
	
	//List booking items
	@RequestMapping(value="/bookingitem", method=RequestMethod.GET)
	public @ResponseBody List<BookingItem> listBookingItem() {
		return actions.findAll();
	}
	
	//Create booking items
	@RequestMapping(value="/bookingitem", method=RequestMethod.POST)
	public @ResponseBody BookingItem createBookingItem(@RequestBody BookingItem bookingitem) {
		return actions.save(bookingitem);
	}
	
	//Find booking items
	@RequestMapping(value="/bookingitem/{bookingitemid}", method=RequestMethod.GET)
	public @ResponseBody BookingItem findBookingItem(@PathVariable Integer bookingitemid) {
		return actions.findByBookingitemid(bookingitemid);
	}
			
	//Update booking items
	@RequestMapping(value="/bookingitem", method=RequestMethod.PUT)
	public @ResponseBody BookingItem updateBookingItem(@RequestBody BookingItem bookingitem) {
		return actions.save(bookingitem);
	}
			
	//Delete booking items
	@RequestMapping(value="/bookingitem/{bookingitemid}", method=RequestMethod.DELETE)
	public @ResponseBody void deleteBookingItem(@PathVariable Integer bookingitemid) {
		BookingItem bookingitem = findBookingItem(bookingitemid);
		this.actions.delete(bookingitem);
	}
	
	//List booking items by booking id
	@RequestMapping(value="/findbookingitem/{bookingid}", method=RequestMethod.GET)
	public @ResponseBody List<BookingItem> findBookingItemById(@PathVariable Integer bookingid) {
		return actions.findByBookingid(bookingid);
	}

}
