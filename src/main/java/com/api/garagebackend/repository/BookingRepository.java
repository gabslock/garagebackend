/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
BookingRepository.java
Part of Ger's Garage Web Application - Guided Technology Project for CCT Dublin.
 */
package com.api.garagebackend.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.api.garagebackend.model.Booking;

//Repository to set basic actions to access the database
public interface BookingRepository extends CrudRepository<Booking, Integer>{
	
	//List
	List<Booking> findAll();
			
	//Find
	Booking findByBookingid(int bookingid);
			
	//Delete
	void delete(Booking booking);
			
	//Create or update
	<BookingTemp extends Booking> BookingTemp save(BookingTemp booking);
	
	//Find by booking status
	List<Booking> findByBookingstatus(String bookingstatus);
	
	//Find by booking date
	List<Booking> findByDate(String date);
	
	//Find by booking date and mechanic
	List<Booking> findByDateAndMechanic (String date, String mechanic);
	
	//Find by user id
	List<Booking> findByUserid (int userid);

}
