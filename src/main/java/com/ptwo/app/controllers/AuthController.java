package com.ptwo.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ptwo.app.model.User;
import com.ptwo.app.service.impl.UserServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthController {
	
	/**
	 * Endpoint: ip:9191/api/auth
	 * Return a User that matches the username and password in the request body.
	 * It's using the User Service.
	 * 
	 * */
	
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/auth")
	@ResponseBody
	public User authUser(@RequestBody User incomingUser) {
		System.out.println(incomingUser);
		return userService.findUserByUsernameAndPassword(incomingUser.getUsername(), incomingUser.getPassword());
	}

}
