/*
@name: Gabriel Jucá
@date: 22nd Jan 2022
UserController.java
Part of Ger's Garage Web Application - Guided Technology Project for CCT Dublin.
 */
package com.api.garagebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.garagebackend.model.User;
import com.api.garagebackend.repository.UserRepository;

//Controller class to process incoming REST API requests
@RestController
@RequestMapping("/api")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class UserController {
	
	//Actions
	@Autowired
	private UserRepository actions;
	
	//List users
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public @ResponseBody List<User> listUsers() {
		return actions.findAll();
	}
	
	//Create user
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public @ResponseBody User createUser(@RequestBody User user) {
		return actions.save(user);
	}
	
	//Find user
	@RequestMapping(value="/users/{userid}", method=RequestMethod.GET)
	public @ResponseBody User findUser(@PathVariable Integer userid) {
		return actions.findByUserid(userid);
	}
	
	//Update user
	@RequestMapping(value="/users", method=RequestMethod.PUT)
	public @ResponseBody User updateUser(@RequestBody User user) {
		return actions.save(user);
	}
	
	//Delete user
	@RequestMapping(value="/users/{userid}", method=RequestMethod.DELETE)
	public @ResponseBody void deleteUser(@PathVariable Integer userid) {
		User user = findUser(userid);
		this.actions.delete(user);
	}
	
	//Find user by email
	@RequestMapping(value="/emailusers/{email}", method=RequestMethod.GET)
	public @ResponseBody User findEmailUser(@PathVariable String email) {
	return actions.findByEmail(email);
		}
	
	//Check if user exists and create new account
	@RequestMapping(value="/newuser", method=RequestMethod.POST)
	public @ResponseBody boolean newUser(@RequestBody User user) {
	if (actions.findByEmail(user.getEmail()) == null) {
		actions.save(user);
		return true;
	} else {
		return false;
	}
	}
	
	//Login - check is email exists and compare the password
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody String login(@RequestBody User user) {
		if (actions.findByEmail(user.getEmail()) == null) {
			return "Email not registered.";
		} else if (actions.findByEmailAndPassword(user.getEmail(), user.getPassword()) == null) {
			return "Wrong password.";
		} else {
			return "Login ok";
		}
	}
	
}

