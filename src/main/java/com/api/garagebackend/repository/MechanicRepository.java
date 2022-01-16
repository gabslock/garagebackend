/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
MechanicRepository.java
Part of Ger's Garage Web Application - Guided Technology Project for CCT Dublin.
 */
package com.api.garagebackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.garagebackend.model.Mechanic;

public interface MechanicRepository extends CrudRepository<Mechanic, String> {
	
	//List
	List<Mechanic> findAll();
			
	//Find
	Mechanic findByName(String name);
			
	//Delete
	void delete(Mechanic mechanic);
			
	//Create or update
	<MechanicTemp extends Mechanic> MechanicTemp save(MechanicTemp mechanic);
	
	//Find mechanics by status
	List<Mechanic> findByStatus(String status);

}
