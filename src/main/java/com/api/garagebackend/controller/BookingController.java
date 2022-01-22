/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
BookingController.java
Part of Ger's Garage Web Application - Guided Technology Project for CCT Dublin.
 */
package com.api.garagebackend.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.garagebackend.model.Booking;
import com.api.garagebackend.model.BookingItem;
import com.api.garagebackend.repository.BookingItemRepository;
import com.api.garagebackend.repository.BookingRepository;
import com.api.garagebackend.repository.SuppliesRepository;

//Controller class to process incoming REST API requests
@RestController
@RequestMapping("/api")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class BookingController {
	
	//Actions
	@Autowired
	private BookingRepository actions;
		
	@Autowired
	private BookingItemRepository actions2;
	
	@Autowired
	private SuppliesRepository actions3;
		
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
		
	//Create new booking and create booking item charge
	@RequestMapping(value="/newbooking", method=RequestMethod.POST)
	public @ResponseBody boolean newBooking(@RequestBody Booking booking) {
		booking.setBookingstatus("Booked");
		BookingItem bkItm = new BookingItem();
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
		String chargename = booking.getBookingtype() + " charge";
		bkItm.setProductname(chargename);
		bkItm.setBookingid(booking.getBookingid());
		bkItm.setUnitprice(actions3.findByProductname(chargename).getUnitprice());
		bkItm.setQuantity(1);
		bkItm.setTotalprice(bkItm.getUnitprice() * bkItm.getQuantity());
		/*if (booking.getBookingtype().equals("Annual Service")) {
			/*bkItm.setProductname("Annual service charge");
			String chargename = booking.getBookingtype() + " charge";
			bkItm.setProductname(chargename);
			bkItm.setBookingid(booking.getBookingid());
			bkItm.setUnitprice(actions3.findByProductname(chargename).getUnitprice());
			bkItm.setQuantity(1);
			bkItm.setTotalprice(bkItm.getUnitprice() * bkItm.getQuantity());
		} else if (booking.getBookingtype().equals("Major Service")) {
			bkItm.setProductname("Major service charge");
			bkItm.setBookingid(booking.getBookingid());
			bkItm.setUnitprice(99);
			bkItm.setQuantity(1);
			bkItm.setTotalprice(bkItm.getUnitprice() * bkItm.getQuantity());
		} else if (booking.getBookingtype().equals("Repair/Fault")) {
			bkItm.setProductname("Repair/fault charge");
			bkItm.setBookingid(booking.getBookingid());
			bkItm.setUnitprice(39);
			bkItm.setQuantity(1);
			bkItm.setTotalprice(bkItm.getUnitprice() * bkItm.getQuantity());
		} else if (booking.getBookingtype().equals("Major Repair")) {
			bkItm.setProductname("Major repair charge");
			bkItm.setBookingid(booking.getBookingid());
			bkItm.setUnitprice(99);
			bkItm.setQuantity(1);
			bkItm.setTotalprice(bkItm.getUnitprice() * bkItm.getQuantity());
	}*/
		actions2.save(bkItm);
		return true;
	}
		
	//Find list of bookings by booking status and sort by date
	@RequestMapping(value="/bookingsbystatus/{bookingstatus}", method=RequestMethod.GET)
	public @ResponseBody List<Booking> listBookingsByStatus(@PathVariable String bookingstatus) {
		List<Booking> orderedBookings = actions.findByBookingstatus(bookingstatus);
		Comparator<Booking> compareByDate = (Booking o1, Booking o2) -> o1.getDate().compareTo( o2.getDate() );
		Collections.sort(orderedBookings, compareByDate);
		return orderedBookings;
	}
		
	//Find booking by date
	@RequestMapping(value="/bookingsbydate/{date}", method=RequestMethod.GET)
	public @ResponseBody List<Booking> listBookingsByDate(@PathVariable String date) {
		return actions.findByDate(date);
	}
		
	//Change bookings by status
	@RequestMapping(value="/changestatus/{bookingid}/{bookingstatus}", method=RequestMethod.GET)
	public @ResponseBody Booking changeStatus(@PathVariable int bookingid, @PathVariable String bookingstatus) {
		Booking booking = findBooking(bookingid);
		booking.setBookingstatus(bookingstatus);
		return actions.save(booking);
	}
		
	//Find by Date and Mechanic
	@RequestMapping(value="/roster/{date}/{mechanic}", method=RequestMethod.GET)
	public List<Booking> listByDateAndMechanic(@PathVariable String date, @PathVariable String mechanic){
		return actions.findByDateAndMechanic(date, mechanic);
	}
		
	//Check if mechanic is available and change booking mechanic
	@RequestMapping(value="/changemechanic/{bookingid}/{mechanic}", method=RequestMethod.GET)
	public @ResponseBody int changeMechanic(@PathVariable int bookingid, @PathVariable String mechanic) {
	Booking booking = findBooking(bookingid);
	List<Booking> dailyBookings = listByDateAndMechanic(booking.getDate(), mechanic);
	int totalIndex = 0;
	for (int i = 0; i < dailyBookings.size(); i++) {
		totalIndex += dailyBookings.get(i).getServiceindex();
	}
	if (totalIndex + booking.getServiceindex() <= 4) {
		booking.setMechanic(mechanic);
		actions.save(booking);
	}
		return totalIndex + booking.getServiceindex();
	}
	
	//Get last car details
	@RequestMapping(value="/lastdetails/{userid}", method=RequestMethod.GET)
	public @ResponseBody Booking lastCarDetails(@PathVariable int userid) {
	List<Booking> userBookings = actions.findByUserid(userid);
	Comparator<Booking> compareByDate = (Booking o1, Booking o2) -> o1.getDate().compareTo( o2.getDate() );
	Collections.sort(userBookings, compareByDate);
		return userBookings.get(userBookings.size() - 1);
	}
	
	//Check if user has booking to get last details
	@RequestMapping(value="/userhasbookings/{userid}", method=RequestMethod.GET)
	public @ResponseBody boolean userHasBookings(@PathVariable int userid) {
	List<Booking> userBookings = actions.findByUserid(userid);
	if (userBookings.isEmpty()) {
		return false;
	} else {
		return true;
	}
	}
		
}
