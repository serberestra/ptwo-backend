package com.ptwo.app.service;

import java.util.List;

import com.ptwo.app.model.User;

public interface UserService {
	
	public User createUser(User u);
	public User updateUser(User u);
	public void deleteByID(Long id);
	public User getUserById(Long id);
	public List<User> getAllUsers();
	public User getUserByName(String Username);
}
