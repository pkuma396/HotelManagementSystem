package com.cg.hbms.dao;

public class QueryMapper {

	public static String GET_USER_BY_HOTEL = "SELECT * FROM Users u WHERE u.user_Id IN (SELECT b.user_Id FROM BookingDetails b WHERE b.room_Id IN (SELECT r.room_id FROM RoomDetails r WHERE r.hotel_id = :id))";
	public static String GET_BOOKING_BY_HOTEL = "SELECT * FROM BookingDetails b WHERE b.room_Id IN (SELECT r.room_Id FROM roomdetails r WHERE r.hotel_Id = :id)";
	public static String GET_BOOKING_BY_DATE = "SELECT * FROM bookingDetails b WHERE :date BETWEEN b.booked_from AND b.booked_to";
	
	public static String GET_ROOM_BY_HOTEL = "SELECT * FROM roomDetails r WHERE r.hotel_id = :id AND r.availability = 1";
	
	public static String GET_ROOM_IMAGES = "SELECT r.photo FROM roomDetails r WHERE r.hotel_id = :id AND r.availability = 1";
	public static String UPDATE_ROOM_AVAILABILITY = "UPDATE roomDetails SET availability=0 WHERE room_id = :id";
}
