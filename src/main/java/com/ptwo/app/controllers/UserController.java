package com.ptwo.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ptwo.app.model.User;
import com.ptwo.app.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/user")
	public User createUser(@RequestBody User u) {
		return service.createUser(u);
	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User u) {
		return service.updateUser(u);
	}

	@DeleteMapping("user/{id}")
	public void deleteByID(@PathVariable("id")Long id) {
		service.deleteByID(id);
		
	}
	
	@GetMapping("user/{id}")
	public User getUserById(@PathVariable("id")Long id) {
		return service.getUserById(id);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}

	@GetMapping("/user/{username}")
	public User getUserByName(@PathVariable("username")String Username) {
		return service.getUserByName(Username);
	}

}
