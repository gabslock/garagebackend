/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
AdminRepository.java
Part of Ger's Garage Web Application - Guided Technology Project for CCT Dublin.
 */
package com.api.garagebackend.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.api.garagebackend.model.Admin;
import com.api.garagebackend.model.User;

//Repository to set basic actions to access the database
public interface AdminRepository extends CrudRepository<Admin, Integer>{
	
	//List
	List<Admin> findAll();
		
	//Find
	Admin findByAdminid(int adminid);
		
	//Delete
	void delete(Admin admin);
		
	//Create or update
	<AdminTemp extends Admin> AdminTemp save(AdminTemp admin);
		
	//Find user by email
	Admin findByEmail(String email);
	
	//Find by email and password
	Admin findByEmailAndPassword (String email, String password);

}
