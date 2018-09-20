package com.cg.hbms.dao;

import java.sql.Blob;
import java.util.List;

import com.cg.hbms.entities.BookingDetail;
import com.cg.hbms.entities.Hotel;
import com.cg.hbms.entities.RoomDetail;
import com.cg.hbms.entities.User;
import com.cg.hbms.exception.HbmsException;

public interface IHbmsDao {
	
	public User registerUser(User user) throws HbmsException;
	public User loginUser(User user) throws HbmsException;
	
	public List<Hotel> getHotelList() throws HbmsException;
	public List<BookingDetail> getBookingList(User user) throws HbmsException;
	
	
	public Hotel addHotel(Hotel hotel) throws HbmsException;
	public Hotel modifyHotel(Hotel hotel) throws HbmsException;
	public String deleteHotel(Integer hotelId) throws HbmsException;
	public Hotel getHotel(Integer hotelId) throws HbmsException;
	
	public RoomDetail addRoom(RoomDetail room) throws HbmsException;
	public RoomDetail modifyRoom(RoomDetail room) throws HbmsException;
	public String deleteRoom(Integer roomId) throws HbmsException;
	public RoomDetail getRoom(Integer roomId) throws HbmsException;
	public List<RoomDetail> getRoomList() throws HbmsException;
	
	public List<BookingDetail> getBookingDetails(Hotel hotel) throws HbmsException;
	//public List<RoomDetail> getRoomDetails(Hotel hotel) throws HbmsException;
	
	public List<User> getHotelUsers(Integer hotelId) throws HbmsException;
	public List<BookingDetail> getBookingByDate(BookingDetail booking)throws HbmsException;
	
	
	///////////////// user operation	///////////////////////////
	public BookingDetail addBooking(BookingDetail booking) throws HbmsException;
	public String deleteBooking(BookingDetail booking) throws HbmsException;
	public List<RoomDetail> getRoomByHotel(Integer hotelId) throws HbmsException;
	
	public List<RoomDetail> getRoomImages(Integer hotelId) throws HbmsException;
}
