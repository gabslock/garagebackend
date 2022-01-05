/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
SuppliesRepository.java
Part of Ger's Garage Web Application - Guided Technology Project for CCT Dublin.
 */
package com.api.garagebackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.api.garagebackend.model.Supplies;

//Repository to set basic actions to access the database
public interface SuppliesRepository extends CrudRepository<Supplies, String> {
	
	//List
	List<Supplies> findAll();
		
	//Find
	Supplies findByProductname(String productname);
		
	//Delete
	void delete(Supplies supplies);
		
	//Create or update
	<SuppliesTemp extends Supplies> SuppliesTemp save(SuppliesTemp supplies);

}
