package com.ptwo.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ptwo.app.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long>{
	public User findByUsername(String Username);
}
