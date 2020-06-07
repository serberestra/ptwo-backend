package com.ptwo.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sh_user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	@Column(name="user_type")
	private String userType;
	@Column(name="phone_number")
	private String phoneNumber;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long id, String Username, String Password, String UserType, String PhoneNumber) {
		super();
		this.id = id;
		username = Username;
		password = Password;
		userType = UserType;
		phoneNumber = PhoneNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String Username) {
		username = Username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String Password) {
		password = Password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String UserType) {
		userType = UserType;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String PhoneNumber) {
		phoneNumber = PhoneNumber;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", Username=" + username + ", Password=" + password + ", UserType=" + userType
				+ ", PhoneNumber=" + phoneNumber + "]";
	}
	
}
