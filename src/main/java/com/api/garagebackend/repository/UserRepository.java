/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
UserRepository.java
Part of Ger's Garage Web Application - Guided Technology Project for CCT Dublin.
 */
package com.api.garagebackend.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.api.garagebackend.model.User;

//Repository to set basic actions to access the database
public interface UserRepository extends CrudRepository<User, Integer>{
	
	//List
	List<User> findAll();
	
	//Find
	User findByUserid(int userid);
	
	//Delete
	void delete(User user);
	
	//Create or update
	<UserTemp extends User> UserTemp save(UserTemp user);
	
	//Find user by email
	User findByEmail(String email);
	
	//Find by email and password
	User findByEmailAndPassword (String email, String password);
}
