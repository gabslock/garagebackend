/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
ServiceRepository.java
Part of Ger's Garage Web Application - Guided Technology Project for CCT Dublin.
 */
package com.api.garagebackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.garagebackend.model.Service;

public interface ServiceRepository extends CrudRepository<Service, String> {
	
	//List
	List<Service> findAll();
				
	//Find
	Service findByName(String name);
				
	//Delete
	void delete(Service servicec);
				
	//Create or update
	<ServiceTemp extends Service> ServiceTemp save(ServiceTemp service);
		
	//Find mechanics by status
	List<Service> findByStatus(String status);

}
