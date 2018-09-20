package com.cg.hbms.entities;

import java.io.File;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="RoomDetails")
public class RoomDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	//@SequenceGenerator(name = "roomSeq", sequenceName = "ROOM_ID_SEQ")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomSeq")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="room_id")
	private Integer roomId;
	
	@Column(name="hotel_id")
	private Integer hotelId;
	
	@Column(name = "room_no")
	//@Pattern(regexp = "^[1-9][0-9]+$", message = "Room No. should be a valid Room No")
	private String roomNo;
	
	@Column(name = "room_type")
	private String roomType;
	
	@Column(name ="per_night_rate")
	private double perNightRate;
	
	@Column(name="availability")
	private String availability;
	
	@Column(name="photo")
	private File photo;

	

	public RoomDetail() {
		// TODO Auto-generated constructor stub
	}
	public RoomDetail(int roomId, String roomNo, String roomType,
			double perNightRate, String availability, int hotelId) {
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.perNightRate = perNightRate;
		this.availability = availability;
		this.hotelId = hotelId;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getPerNightRate() {
		return perNightRate;
	}

	public void setPerNightRate(double perNightRate) {
		this.perNightRate = perNightRate;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}



	
	
	
}
