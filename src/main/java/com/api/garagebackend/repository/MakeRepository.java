/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
MakeRepository.java
Part of Ger's Garage Web Application - Guided Technology Project for CCT Dublin.
 */
package com.api.garagebackend.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.api.garagebackend.model.Make;

public interface MakeRepository extends CrudRepository<Make, String> {
	
	//List
	List<Make> findAll();
				
	//Find
	Make findByName(String name);
				
	//Delete
	void delete(Make make);
				
	//Create or update
	<MakeTemp extends Make> MakeTemp save(MakeTemp make);
		
	//Find mechanics by status
	List<Make> findByStatus(String status);

}
