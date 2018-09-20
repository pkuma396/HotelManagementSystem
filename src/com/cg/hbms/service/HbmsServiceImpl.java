package com.cg.hbms.service;

import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbms.dao.IHbmsDao;
import com.cg.hbms.entities.BookingDetail;
import com.cg.hbms.entities.Hotel;
import com.cg.hbms.entities.RoomDetail;
import com.cg.hbms.entities.User;
import com.cg.hbms.exception.HbmsException;

@Service
public class HbmsServiceImpl implements IHbmsService {

	@Autowired
	private IHbmsDao hbmsDao;
	
	@Override
	public User registerUser(User user) throws HbmsException {
		return hbmsDao.registerUser(user);
	}

	@Override
	public User loginUser(User user) throws HbmsException {
		return hbmsDao.loginUser(user);
	}

	@Override
	public List<Hotel> getHotelList() throws HbmsException {
		return hbmsDao.getHotelList();
	}

	@Override
	public List<BookingDetail> getBookingList(User user) throws HbmsException {
		return hbmsDao.getBookingList(user);
	}

	@Override
	public Hotel addHotel(Hotel hotel) throws HbmsException {
		return hbmsDao.addHotel(hotel);
	}

	@Override
	public Hotel modifyHotel(Hotel hotel) throws HbmsException {
		return hbmsDao.modifyHotel(hotel);
	}

	@Override
	public String deleteHotel(Integer hotelId) throws HbmsException {
		return hbmsDao.deleteHotel(hotelId);
	}

	@Override
	public Hotel getHotel(Integer hotelId) throws HbmsException {
		return hbmsDao.getHotel(hotelId);
	}

	@Override
	public RoomDetail addRoom(RoomDetail room) throws HbmsException {
		return hbmsDao.addRoom(room);
	}

	@Override
	public RoomDetail modifyRoom(RoomDetail room) throws HbmsException {
		return hbmsDao.modifyRoom(room);
	}

	@Override
	public String deleteRoom(Integer roomId) throws HbmsException {
		return hbmsDao.deleteRoom(roomId);
	}

	@Override
	public RoomDetail getRoom(Integer roomId) throws HbmsException {
		return hbmsDao.getRoom(roomId);
	}

	@Override
	public List<RoomDetail> getRoomList() throws HbmsException {
		return hbmsDao.getRoomList();
	}

	@Override
	public List<BookingDetail> getBookingDetails(Hotel hotel)
			throws HbmsException {
		return hbmsDao.getBookingDetails(hotel);
	}

	@Override
	public BookingDetail addBooking(BookingDetail booking) throws HbmsException {
		return hbmsDao.addBooking(booking);
	}

	@Override
	public String deleteBooking(BookingDetail booking) throws HbmsException {
		return hbmsDao.deleteBooking(booking);
	}

	@Override
	public List<User> getHotelUsers(Integer hotelId) throws HbmsException {
		return hbmsDao.getHotelUsers(hotelId);
	}

	@Override
	public List<BookingDetail> getBookingByDate(BookingDetail booking)
			throws HbmsException {
		return hbmsDao.getBookingByDate(booking);
	}

	@Override
	public List<RoomDetail> getRoomByHotel(Integer hotelId)
			throws HbmsException {
		return hbmsDao.getRoomByHotel(hotelId);
	}

	@Override
	public List<RoomDetail> getRoomImages(Integer hotelId) throws HbmsException {
		return hbmsDao.getRoomImages(hotelId);
	}

}
