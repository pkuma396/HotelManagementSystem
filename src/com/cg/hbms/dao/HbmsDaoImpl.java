package com.cg.hbms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.hbms.entities.BookingDetail;
import com.cg.hbms.entities.Hotel;
import com.cg.hbms.entities.RoomDetail;
import com.cg.hbms.entities.User;
import com.cg.hbms.exception.HbmsException;

@Repository
@Transactional
public class HbmsDaoImpl implements IHbmsDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	//////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public User registerUser(User user) throws HbmsException {
		if(findUser(user) == 0){
			entityManager.persist(user);
			entityManager.flush();
			return user;
		}
		return null;
	}


	//////////////////////////////////////////////////////////////////////////////////

	/***************************************************************************************
	 * Function :		loginUser()
	 * Parameter :		User
	 * Return type :	User
	 * Date :			04/09/2018
	 * Description :	Return all details of user if exist, else return null.
	 *****************************************************************************************/
	@Override
	public User loginUser(User user) throws HbmsException {
		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.userName=? AND u.password=?",User.class);
		query.setParameter(1, user.getUserName());
		query.setParameter(2, user.getPassword());
		User userDetails = new User();
		try{
			userDetails = query.getSingleResult();
		}catch(Exception e){
			return null;
		}
		return userDetails;
	}
	
	
	//for checking existing user
	public int findUser(User user) throws HbmsException {
		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.userName=:name",User.class);
		query.setParameter("name", user.getUserName());
		List<User> list = query.getResultList();
		if(list.isEmpty()){
			return 0;
		}
		return 1;
	}
	//////////////////////////////////////////////////////////////////////////////////


	@Override
	public List<Hotel> getHotelList() throws HbmsException {
		TypedQuery<Hotel> query = entityManager.createQuery("SELECT h FROM Hotel h", Hotel.class);
		List<Hotel> hotelList = query.getResultList();
		if(hotelList.isEmpty())
			return null;
		
		return hotelList;
	}


	/////////////////////////	Hotel Management 	/////////////////////////////////////////////////////////

	/***************************************************************************************
	 * Function :		
	 * Parameter :		
	 * Return type :	
	 * Date :			04/09/2018
	 * Description :	
	 *****************************************************************************************/
	@Override
	public Hotel addHotel(Hotel hotel) throws HbmsException {
		entityManager.persist(hotel);
		entityManager.flush();
		return hotel;
	}



	@Override
	public Hotel modifyHotel(Hotel hotel) throws HbmsException {
		entityManager.merge(hotel);
		entityManager.flush();
		return hotel;
	}



	@Override
	public String deleteHotel(Integer hotelId) throws HbmsException {
		try{
			Hotel hotel = entityManager.find(Hotel.class, hotelId);
			entityManager.remove(hotel);
		}catch(Exception e){
			return "0";
		}
		return "1";
	}



	@Override
	public Hotel getHotel(Integer hotelId) throws HbmsException {
		Hotel hotel = entityManager.find(Hotel.class, hotelId);
		return hotel;
	}

/////////////////////////	Room Management 	/////////////////////////////////////////////////////////
	/***************************************************************************************
	 * Function :		
	 * Parameter :		
	 * Return type :	
	 * Date :			04/09/2018
	 * Description :	
	 *****************************************************************************************/
	@Override
	public RoomDetail addRoom(RoomDetail room) throws HbmsException {
		entityManager.persist(room);
		//entityManager.flush();
		return room;
	}



	@Override
	public RoomDetail modifyRoom(RoomDetail room) throws HbmsException {
		entityManager.merge(room);
		//entityManager.flush();
		return room;
	}



	@Override
	public String deleteRoom(Integer roomId) throws HbmsException {
		try{
			RoomDetail room = entityManager.find(RoomDetail.class, roomId);
			entityManager.remove(room);
			entityManager.flush();
		}catch(Exception e){
			return "0";
		}
		return "1";
	}



	@Override
	public RoomDetail getRoom(Integer roomId) throws HbmsException {
		RoomDetail room = entityManager.find(RoomDetail.class, roomId);
		return room;
	}



	@Override
	public List<RoomDetail> getRoomList() throws HbmsException {
		TypedQuery<RoomDetail> query = entityManager.createQuery("SELECT r FROM RoomDetail r", RoomDetail.class);
		List<RoomDetail> roomList = query.getResultList();
		if(roomList.isEmpty())
			return null;
		
		return roomList;
	}

/////////////////////////	Report Management 	/////////////////////////////////////////////////////////

	@Override
	public List<BookingDetail> getBookingDetails(Hotel hotel)
			throws HbmsException {
		@SuppressWarnings("unchecked")
		TypedQuery<BookingDetail> tQuery=(TypedQuery<BookingDetail>) entityManager.createNativeQuery(QueryMapper.GET_BOOKING_BY_HOTEL,BookingDetail.class);
		tQuery.setParameter("id", hotel.getHotelId());
		List<BookingDetail> bookingList=tQuery.getResultList();
		if(bookingList.isEmpty()){
			return null;
		}
		return bookingList;
	}

	@Override
	public List<User> getHotelUsers(Integer hotelId) throws HbmsException {
		@SuppressWarnings("unchecked")
		TypedQuery<User> tQuery=(TypedQuery<User>) entityManager.createNativeQuery(QueryMapper.GET_USER_BY_HOTEL,User.class);
		tQuery.setParameter("id", hotelId);
		List<User> userList = tQuery.getResultList();
		if(userList.isEmpty()){
			return null;
		}
		return userList;
	}

	@Override
	public List<BookingDetail> getBookingByDate(BookingDetail booking) throws HbmsException{
		@SuppressWarnings("unchecked")
		TypedQuery<BookingDetail> tQuery=(TypedQuery<BookingDetail>) entityManager.createNativeQuery(QueryMapper.GET_BOOKING_BY_DATE,BookingDetail.class);
		tQuery.setParameter("date", booking.getBookedFrom());
		List<BookingDetail> bookingList=tQuery.getResultList();
		if(bookingList.isEmpty()){
			return null;
		}
		return bookingList;
	}
/////////////////////////	User Management 	/////////////////////////////////////////////////////////


	@Override
	public List<BookingDetail> getBookingList(User user) throws HbmsException {
		TypedQuery<BookingDetail> query = entityManager.createQuery("SELECT b FROM BookingDetail b WHERE b.userId=:userid", BookingDetail.class);
		query.setParameter("userid", user.getUserId());
		List<BookingDetail> bookingList = query.getResultList();
		if(bookingList.isEmpty())
			return null;
		
		return bookingList;
	}

	@Override
	public BookingDetail addBooking(BookingDetail booking) throws HbmsException {		
		entityManager.persist(booking);
		RoomDetail room = entityManager.find(RoomDetail.class, booking.getRoomId());
		room.setAvailability("0");
		entityManager.flush();
		return booking;
	}
	

	@Override
	public String deleteBooking(BookingDetail booking) throws HbmsException {
		try{
			BookingDetail booking1 = entityManager.find(BookingDetail.class, booking.getBookingId());
			entityManager.remove(booking1);
			entityManager.flush();
		}catch(Exception e){
			return "0";
		}
		return "1";
	}

	@Override
	public List<RoomDetail> getRoomByHotel(Integer hotelId) throws HbmsException {
		@SuppressWarnings("unchecked")
		TypedQuery<RoomDetail> query = (TypedQuery<RoomDetail>) entityManager.createNativeQuery(QueryMapper.GET_ROOM_BY_HOTEL, RoomDetail.class);
		query.setParameter("id", hotelId);
		List<RoomDetail> roomList = query.getResultList();
		if(roomList.isEmpty())
			return null;
		
		return roomList;
	}
	
	public List<RoomDetail> getRoomImages(Integer hotelId) throws HbmsException {
		@SuppressWarnings("unchecked")
		TypedQuery<RoomDetail> query = (TypedQuery<RoomDetail>) entityManager.createNativeQuery(QueryMapper.GET_ROOM_IMAGES, RoomDetail.class);
		query.setParameter("id", hotelId);
		List<RoomDetail> roomList = query.getResultList();
		if(roomList.isEmpty())
			return null;
			
		return roomList;
	}
	
}
