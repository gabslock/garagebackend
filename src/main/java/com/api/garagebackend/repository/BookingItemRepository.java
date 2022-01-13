/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
BookingItemRepository.java
Part of Ger's Garage Web Application - Guided Technology Project for CCT Dublin.
 */
package com.api.garagebackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.garagebackend.model.BookingItem;

public interface BookingItemRepository extends CrudRepository<BookingItem, Integer> {
	
	//List
	List<BookingItem> findAll();
				
	//Find
	BookingItem findByBookingitemid(int bookingitemid);
				
	//Delete
	void delete(BookingItem bookingitem);
				
	//Create or update
	<BookingItemTemp extends BookingItem> BookingItemTemp save(BookingItemTemp bookingitem);
	
	//Find by booking id
	List<BookingItem> findByBookingid(int bookingid);

}
