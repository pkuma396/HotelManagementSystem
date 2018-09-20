package com.cg.hbms.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Hotel")
public class Hotel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name="hotel_id")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="hotel_seq")
	//@SequenceGenerator(name="hotel_seq",sequenceName="hotel_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer hotelId;

	//@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "City Name must contain only alphabets")
	@Column (name="city")
	private String city;
	
	//@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Hotel Name must contain only alphabets")
	@Column (name="hotel_name")
	private String hotelName;
	
	@Column (name="address")
	//@Size(min=5, message = "Address should be minimum 5 characters")
	private String address;
	
	//@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Description must contain only alphabets")
	@Column (name="description")
	private String description;
	
	//@Min(value=300)
	@Column (name="avg_rate_per_night")
	private double avgRatePerNight;
	
	//@Pattern(regexp = "[7-9]{1}+[0-9]{9}", message = "Phone Number must be 10 digits")
	@Column (name="phone_no1")
	private String phoneNoOne;
	
	//@Pattern(regexp = "[7-9]{1}+[0-9]{9}", message = "Phone Number must be 10 digits")
	@Column (name="phone_no2")
	private String phoneNoTwo;
	
	@Column (name="rating")
	//@Pattern(regexp = "^[1-5]{1}+$", message = "Rating must be from 1 to 5")
	private String rating;
	
	//@Email(message="Please provide a valid email address")
	@Column (name="email")
	private String email;
	
	//@Pattern(regexp="[0-9]{1,2}+[-]{1}+[0-9]{3}+[-]{1}+[0-9]{7}",message="Please provide fax number in the format of 11-111-1234567/1-111-1234567")
	@Column (name="fax")
	private String fax;
	

	public Hotel() {
		// TODO Auto-generated constructor stub
	}

	public Hotel(int hotelId, String city, String hotelName, String address,
			String description, double avgRatePerNight, String phoneNoOne,
			String phoneNoTwo, String rating, String email, String fax,
			List<RoomDetail> rooms) {
		super();
		this.hotelId = hotelId;
		this.city = city;
		this.hotelName = hotelName;
		this.address = address;
		this.description = description;
		this.avgRatePerNight = avgRatePerNight;
		this.phoneNoOne = phoneNoOne;
		this.phoneNoTwo = phoneNoTwo;
		this.rating = rating;
		this.email = email;
		this.fax = fax;
		
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAvgRatePerNight() {
		return avgRatePerNight;
	}

	public void setAvgRatePerNight(double avgRatePerNight) {
		this.avgRatePerNight = avgRatePerNight;
	}

	public String getPhoneNoOne() {
		return phoneNoOne;
	}

	public void setPhoneNoOne(String phoneNoOne) {
		this.phoneNoOne = phoneNoOne;
	}

	public String getPhoneNoTwo() {
		return phoneNoTwo;
	}

	public void setPhoneNoTwo(String phoneNoTwo) {
		this.phoneNoTwo = phoneNoTwo;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}


	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", city=" + city + ", hotelName="
				+ hotelName + ", address=" + address + ", description="
				+ description + ", avgRatePerNight=" + avgRatePerNight
				+ ", phoneNoOne=" + phoneNoOne + ", phoneNoTwo=" + phoneNoTwo
				+ ", rating=" + rating + ", email=" + email + ", fax=" + fax
				+ "]";
	}
	
	}
