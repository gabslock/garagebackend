/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
CarTypeRepository.java
Part of Ger's Garage Web Application - Guided Technology Project for CCT Dublin.
 */
package com.api.garagebackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.garagebackend.model.CarType;

public interface CarTypeRepository extends CrudRepository<CarType, String> {
	
	//List
	List<CarType> findAll();
					
	//Find
	CarType findByName(String name);
					
	//Delete
	void delete(CarType carType);
					
	//Create or update
	<CarTypeTemp extends CarType> CarTypeTemp save(CarTypeTemp carType);
			
	//Find car type by status
	List<CarType> findByStatus(String status);

}
