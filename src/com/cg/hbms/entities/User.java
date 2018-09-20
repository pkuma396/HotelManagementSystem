package com.cg.hbms.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")/*
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)*/
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;

	@NotEmpty
	/*@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$", 
			 message = "Password should be minimum 8 characters & must contain atleast each of one number, special character,uppercase")*/
	private String password;

	@NotEmpty
	private String role;

	@Column(name="user_name")
	@NotEmpty
	//@Pattern(regexp = "^[a-zA-Z]+$", message = "Username must contain only alphabets")
	private String userName;

	@Column(name="mobile_no")
	//@Pattern(regexp = "[1-9]{1}[0-9]{9}", message = "Mobile Number should contain only 10 digits")
	@NotEmpty
	private String mobileNumber;

	@Column(name="phone")
	//@Pattern(regexp = "[1-9]{1}[0-9]{9}", message = "Mobile Number should contain only 10 digits")
	@NotEmpty
	private String phoneNumber;

	@NotEmpty
	//@Size(min=5, message = "Address should be minimum 5 characters")
	private String address;

	@NotEmpty
	//@Email(message="Please provide a valid email address")
	private String email;

	public User() {

	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role="
				+ role + ", userName=" + userName + ", mobileNumber="
				+ mobileNumber + ", phoneNumber=" + phoneNumber + ", address="
				+ address + ", email=" + email + "]";
	}

}
