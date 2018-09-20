package com.cg.hbms.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*CREATE TABLE BOOKINGDETAILS(booking_id VARCHAR2(4) PRIMARY KEY,
		room_id VARCHAR2(4),
		user_id VARCHAR2(4),
		booked_from DATE,
		booked_to DATE,
		no_of_adults NUMBER,
		no_of_children NUMBER,
		amount NUMBER(6,2),
		CONSTRAINT fk_room_user FOREIGN KEY(room_id) REFERENCES ROOMDETAILS(room_id),FOREIGN KEY(user_id) REFERENCES USERS(user_id)
		ON DELETE CASCADE);*/

@Entity
@Table(name="bookingDetails")
public class BookingDetail {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="booking_detail_seq")
	@SequenceGenerator(name="booking_detail_seq",sequenceName="booking_detail_seq",allocationSize=10)
	@Column (name="booking_id")
	private int bookingId;
	
	@Column (name="room_id")
	private int roomId;
	
	@Column (name="user_id")
	private int userId;
	
	@Column(name="booked_from")
	private Date bookedFrom;
	
	@Column(name="booked_to")
	private Date bookedTo;
	
	@Column(name="no_of_adults")
	private int noOfAdults;
	
	@Column(name="no_of_children")
	private int noOfChildren;
	
	@Column(name="amount")
	private double amount;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getBookedFrom() {
		return bookedFrom;
	}

	public void setBookedFrom(Date bookedFrom) {
		this.bookedFrom = bookedFrom;
	}

	public Date getBookedTo() {
		return bookedTo;
	}

	public void setBookedTo(Date bookedTo) {
		this.bookedTo = bookedTo;
	}

	public int getNoOfAdults() {
		return noOfAdults;
	}

	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}

	public int getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


	
}
