package com.ptwo.app.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptwo.app.dao.UserDAO;
import com.ptwo.app.model.User;
import com.ptwo.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User createUser(User u) {
		return userDAO.save(u);
	}

	@Override
	public User updateUser(User u) {
		return userDAO.save(u);
	}

	@Override
	public void deleteByID(Long id) {
		userDAO.deleteById(id);
		
	}

	@Override
	public User getUserById(Long id) {
		return userDAO.findById(id).get();
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.findAll();
	}

	@Override
	public User getUserByName(String Username) {
		return userDAO.findByUsername(Username);
	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		return userDAO.findUserByUsernameAndPassword(username, password);
	}

}
