package com.ptwo.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ptwo.app.model.User;

@SpringBootTest
class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@BeforeEach
	public void setUp() throws Exception {
		// clear user table
		List<User> uList = userService.getAllUsers();
		for(User u : uList) {
			userService.deleteByID(u.getId());
		}
	}

	@Test
	public void test_Create_User() {
		
		/**
		 * 	private Long id;
	private String username;
	private String password;
	private String userType;
	private String phoneNumber;
		 */
		
		User user = new User();
		user.setId(1L);
		user.setUsername("any");
		user.setPassword("any");
		user.setUserType("user");
		user.setPhoneNumber("1231231234");
		
		userService.createUser(user);
		
		List<User> uList = userService.getAllUsers();

		assertEquals(1, uList.size());
		
	}
	
	@Test
	public void test_Update_User() {
		
		User user = new User();
		user.setId(1L);
		user.setUsername("any");
		user.setPassword("any");
		user.setUserType("user");
		user.setPhoneNumber("1231231234");
		
		user.setUsername("new");
		user.setPassword("newToo");
		assertEquals("new", user.getUsername());
		assertEquals("newToo", user.getPassword());
		
		
	}
	
	@Test
	public void test_getAllUsers() {
		
		User user = new User();
		user.setId(1L);
		user.setUsername("any");
		user.setPassword("any");
		user.setUserType("user");
		user.setPhoneNumber("1231231234");
		userService.createUser(user);
		
		User user1 = new User();
		user1.setId(2L);
		user1.setUsername("user1");
		user1.setPassword("user1");
		user1.setUserType("user1");
		user1.setPhoneNumber("1231231235");
		userService.createUser(user1);
		
		List<User> uList = userService.getAllUsers();
		assertEquals(2, uList.size());
		
	}
	
	
	@Test
	public void test_getUsersById() {
		
		User user = new User();
		user.setId(1L);
		user.setUsername("any");
		user.setPassword("any");
		user.setUserType("user");
		user.setPhoneNumber("1231231234");
		
		userService.createUser(user);
		
		User user1 = new User();
		user1.setId(2L);
		user1.setUsername("user1");
		user1.setPassword("user1");
		user1.setUserType("user1");
		user1.setPhoneNumber("1231231235");
		userService.createUser(user1);
		
		//List<User> uList = userService.getAllUsers();
		User test1 = userService.getUserById(2L);

		assertEquals(user1.getId(), test1.getId() );
		
		
	}
	
	
	
	@Test
	public void test_Delete_User() {
		
		/**
		 * 	private Long id;
	private String username;
	private String password;
	private String userType;
	private String phoneNumber;
		 */
		
		User user = new User();
		user.setId(1L);
		user.setUsername("any");
		user.setPassword("any");
		user.setUserType("user");
		user.setPhoneNumber("1231231234");
		
		User user1 = userService.createUser(user);
		
		userService.deleteByID(user1.getId());
		user = userService.getUserById(user.getId());

		//System.out.println("this is: userService.getUserById(user.getId(): \n\n" + userService.getUserById(user.getId()));
		
		assertThat(user).isNull();
		
		
	}
	
	
	
	

}





































