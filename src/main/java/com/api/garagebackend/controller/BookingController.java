/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
BookingController.java
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

import com.api.garagebackend.model.Booking;
import com.api.garagebackend.repository.BookingRepository;

//Controller class to process incoming REST API requests
@RestController
@RequestMapping("/api")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class BookingController {
	
	//Actions
		@Autowired
		private BookingRepository actions;
		
		//List Bookings
		@RequestMapping(value="/bookings", method=RequestMethod.GET)
		public @ResponseBody List<Booking> listUsers() {
			return actions.findAll();
		}
		
		//Create Booking
		@RequestMapping(value="/bookings", method=RequestMethod.POST)
		public @ResponseBody Booking createBooking(@RequestBody Booking booking) {
			return actions.save(booking);
		}
		
		//Find booking
		@RequestMapping(value="/bookings/{bookingid}", method=RequestMethod.GET)
		public @ResponseBody Booking findBooking(@PathVariable Integer bookingid) {
			return actions.findByBookingid(bookingid);
		}
		
		//Update booking
		@RequestMapping(value="/bookings", method=RequestMethod.PUT)
		public @ResponseBody Booking updateBooking(@RequestBody Booking booking) {
			return actions.save(booking);
		}
		
		//Delete booking
		@RequestMapping(value="/bookings/{bookingid}", method=RequestMethod.DELETE)
		public @ResponseBody void deleteBooking(@PathVariable Integer bookingid) {
			Booking booking = findBooking(bookingid);
			this.actions.delete(booking);
		}
		
		//New booking
		@RequestMapping(value="/newbooking", method=RequestMethod.POST)
		public @ResponseBody boolean newBooking(@RequestBody Booking booking) {
			booking.setBookingstatus("Booked");
			if (booking.getBookingtype().equals("Annual Service")) {
				booking.setServiceindex(1);
			} else if (booking.getBookingtype().equals("Major Service")) {
				booking.setServiceindex(2);
			} else if (booking.getBookingtype().equals("Repair/Fault")) {
				booking.setServiceindex(1);
			} else if (booking.getBookingtype().equals("Major Repair")) {
				booking.setServiceindex(2);
		}
			actions.save(booking);
			return true;
		}
		
		//Find booking by booking status
		@RequestMapping(value="/bookingsbystatus/{bookingstatus}", method=RequestMethod.GET)
		public @ResponseBody List<Booking> listBookingsByStatus(@PathVariable String bookingstatus) {
			return actions.findByBookingstatus(bookingstatus);
		}
		
		//Find booking by date
		@RequestMapping(value="/bookingsbydate/{date}", method=RequestMethod.GET)
		public @ResponseBody List<Booking> listBookingsByDate(@PathVariable String date) {
			return actions.findByDate(date);
		}
		
}
