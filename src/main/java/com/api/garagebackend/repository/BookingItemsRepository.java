/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
BookingItemsRepository.java
Part of Ger's Garage Web Application - Guided Technology Project for CCT Dublin.
 */
package com.api.garagebackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.garagebackend.model.BookingItems;

//Repository to set basic actions to access the database
public interface BookingItemsRepository extends CrudRepository<BookingItems, Integer>{
	
	//List
	List<BookingItems> findAll();
				
	//Find
	BookingItems findByBookingitemid(int bookingitemid);
				
	//Delete
	void delete(BookingItems bookingitems);
				
	//Create or update
	<BookingItemsTemp extends BookingItems> BookingItemsTemp save(BookingItemsTemp bookingitems);

}
