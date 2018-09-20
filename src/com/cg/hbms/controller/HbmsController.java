package com.cg.hbms.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.hbms.entities.BookingDetail;
import com.cg.hbms.entities.Hotel;
import com.cg.hbms.entities.RoomDetail;
import com.cg.hbms.entities.User;
import com.cg.hbms.exception.HbmsException;
import com.cg.hbms.exception.HbmsMessages;
import com.cg.hbms.service.IHbmsService;


@Controller
public class HbmsController {
	
	@Autowired 
	private IHbmsService hbmsService;
	private User userScope;
	//private Hotel hotelToken;


	public static Logger logger = null;
	static{
		logger = Logger.getRootLogger();
		PropertyConfigurator.configure("resources//log4j.properties");
	}
	
	@RequestMapping("/contact.obj")
	public ModelAndView goContact(){
		ModelAndView model= new ModelAndView("contact");
		return model;
	}
	
	@RequestMapping("/about.obj")
	public ModelAndView goAbout(){
		ModelAndView model= new ModelAndView("about");
		return model;
	}
	
	@RequestMapping("/index.obj")
	public ModelAndView goHome(){
		ModelAndView model = new ModelAndView();
		
		if(userScope != null){
			if(userScope.getRole().equals("admin")){
				model.setViewName("admin_dash");
			}else if(userScope.getRole().equals("user") || userScope.getRole().equals("employee")){
				model.setViewName("user_dash");
			}
		}else{
			model.setViewName("index");
		}
		
		return model;
	}

	@RequestMapping("/login.obj")
	public ModelAndView goToLogin(){
		ModelAndView model = new ModelAndView("login");
		model.addObject("user", new User());
		model.addObject("message", null);
		return model;
	}
	
	@RequestMapping("/logout.obj")
	public ModelAndView goToLogout(){
		ModelAndView model = new ModelAndView("index");
		userScope = null;
		return model;
	}
	/***************************************************************************************
	 * Function :		
	 * Parameter :		
	 * Return type :	
	 * Date :			04/09/2018
	 * Description :	
	 *****************************************************************************************/
	@RequestMapping("/loginNow.obj")
	public ModelAndView goToDashboard(@ModelAttribute("user") User user) throws HbmsException{
		
		logger.info("inside login");
		
		ModelAndView model = new ModelAndView();

		User currUser = hbmsService.loginUser(user);
		if(currUser != null && currUser.getRole().equals("admin")){
			userScope = currUser;
			model.setViewName("admin_dash");
		}
		else if(currUser != null){
			userScope = currUser;
			model.setViewName("user_dash");
			model.addObject("user", currUser);
		}
		else{
			model.setViewName("login");
			model.addObject("user", new User());
			model.addObject("message", HbmsMessages.INVALID_CREDENTIAL);
			return model;
		}
		model.addObject("user", currUser);
		return model;
	}




	@RequestMapping("/register.obj")
	public ModelAndView goToRegister(){
		ModelAndView model = new ModelAndView("register");
		model.addObject("user", new User());
		model.addObject("message", null);
		return model;
	}
	/***************************************************************************************
	 * Function :		
	 * Parameter :		
	 * Return type :	
	 * Date :			04/09/2018
	 * Description :	
	 *****************************************************************************************/
	@RequestMapping("/registerNow.obj")
	public ModelAndView registerNow(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) throws HbmsException{
		ModelAndView model = new ModelAndView();
		
		if(bindingResult.hasErrors()){
			model.setViewName("error");
			return model;
		}


		User user1 = hbmsService.registerUser(user);
		model.setViewName("register");
		model.addObject("user", new User());
		if(user1 == null)
			model.addObject("message", HbmsMessages.USER_EXIST);
		else
			model.addObject("message", HbmsMessages.REGISTERED);

		return model;
	}




	/***************************************************************************************
	 * Function :		
	 * Parameter :		
	 * Return type :	
	 * Date :			04/09/2018
	 * Description :	
	 *****************************************************************************************/
	@RequestMapping("/searchHotel.obj")
	public ModelAndView showHotels() throws HbmsException {
		ModelAndView model = new ModelAndView("user_hotels");
		List<Hotel> hotelList = hbmsService.getHotelList();
		if(hotelList == null){
			model.addObject("message", HbmsMessages.NO_HOTEL);
			model.addObject("hotelList", null);
		}
		else{

			model.addObject("message", null);
			model.addObject("hotelList", hotelList);
		}
		return model;
	}

	
	
	
	/***************************************************************************************
	 * Function :		
	 * Parameter :		
	 * Return type :	
	 * Date :			04/09/2018
	 * Description :	
	 *****************************************************************************************/
	@RequestMapping("/viewBookings.obj")
	public ModelAndView showBookings() throws HbmsException {
		ModelAndView model = new ModelAndView("user_bookings");
		List<BookingDetail> bookingList = hbmsService.getBookingList(userScope);
		if(bookingList == null){
			model.addObject("message", HbmsMessages.NO_BOOKING);
			model.addObject("bookingList", null);
		}
		else{

			model.addObject("message", null);
			model.addObject("bookingList", bookingList);
		}
		return model;
	}
	
	
	
	
	/***************************************************************************************
	 * Function :		
	 * Parameter :		
	 * Return type :	
	 * Date :			04/09/2018
	 * Description :	
	 *****************************************************************************************/
	@RequestMapping("/hotelMgmt.obj")
	public ModelAndView hotelManagement() throws HbmsException{
		ModelAndView model = new ModelAndView("admin_hotels");
		List<Hotel> hotelList = hbmsService.getHotelList();
		if(hotelList == null){
			model.addObject("message", HbmsMessages.NO_HOTEL);
			model.addObject("hotelList", null);
		}
		else{

			model.addObject("message", null);
			model.addObject("hotelList", hotelList);
		}
		return model;
	}
	
//FORWARD TO HOTEL DETAILS INPUT PAGE
	@RequestMapping("/addHotel.obj")
	public ModelAndView addHotel(){
		ModelAndView model = new ModelAndView("hotel_add");
		model.addObject("hotel", new Hotel());
		model.addObject("message", null);
		return model;
	}
	
//ADD HOTEL TO DATABASE	
	@RequestMapping("/addHotelNow.obj")
	public ModelAndView addHotelNow(@ModelAttribute("hotel") Hotel hotel) throws HbmsException{
		ModelAndView model = new ModelAndView("admin_hotels");
		Hotel currHotel = hbmsService.addHotel(hotel);
		model.addObject("message", HbmsMessages.HOTEL_ADDED+", Hotel ID: "+currHotel.getHotelId());
		model.addObject("hotel",new Hotel());
		return model;
	}
	
//DELETE HOTEL FROM DATABASE AND FORWARD TO HOTEL DETAILS
	@RequestMapping("/deleteHotel.obj")
	public ModelAndView deleteHotel(@RequestParam("hotelId") Integer hotelId) throws HbmsException{
		ModelAndView model = new ModelAndView("admin_hotels");
		System.out.println("hotel : "+hotelId);
		String result = hbmsService.deleteHotel(hotelId);
		if(result.equals("1"))
			model.addObject("message", HbmsMessages.HOTEL_DELETED);
		else
			model.addObject("message", HbmsMessages.ERROR);
		
		List<Hotel> hotelList = hbmsService.getHotelList();
		if(hotelList == null){
			model.addObject("hotelList", null);
		}
		else{
			model.addObject("hotelList", hotelList);
		}
		return model;
	}
	
//FORWARD TO HOTEL MODIFICATION PAGE
	@RequestMapping("/modifyHotel.obj")
	public ModelAndView modifyHotel(@RequestParam("hotelId") Integer hotelId) throws HbmsException{
		ModelAndView model = new ModelAndView("hotel_modify");
		Hotel hotel = hbmsService.getHotel(hotelId);
		model.addObject("hotel", hotel);
		//hotelToken.setHotelId(hotelId);
		return model;
	}
	
//UPDATE DETAILS OF HOTEL AND FORWARD TO HOTEL DETAILS PAGE
	@RequestMapping("/modifyHotelNow.obj")
	public ModelAndView modifyHotelNow(@ModelAttribute("hotel") Hotel hotel) throws HbmsException{
		ModelAndView model = new ModelAndView("admin_hotels");
		Hotel updatedHotel;
		//System.out.println("id: "+hotel.getHotelId());
		updatedHotel = hbmsService.modifyHotel(hotel);
		
		if(updatedHotel == null){
			model.addObject("message", HbmsMessages.HOTEL_NOT_EXIST);
		}else{
			//hotel = hbmsService.modifyHotel(hotel);
			model.addObject("message", HbmsMessages.HOTEL_MODIFIED);
		}
		
		
		List<Hotel> hotelList = hbmsService.getHotelList();
		if(hotelList == null){
			model.addObject("hotelList", null);
		}
		else{
			model.addObject("hotelList", hotelList);
		}
		return model;
	}
	
	
	/***************************************************************************************
	 * Function :		
	 * Parameter :		
	 * Return type :	
	 * Date :			04/09/2018
	 * Description :	
	 *****************************************************************************************/
	@RequestMapping("/roomMgmt.obj")
	public ModelAndView roomManagement() throws HbmsException{
		ModelAndView model = new ModelAndView("admin_rooms");
		List<RoomDetail> roomList = hbmsService.getRoomList();
		if(roomList == null){
			model.addObject("message", HbmsMessages.ROOM_NOT_EXIST);
			model.addObject("roomList", null);
		}
		else{

			model.addObject("message", null);
			model.addObject("roomList", roomList);
		}
		return model;
	}
	
//FORWARD TO ROOM DETAILS INPUT PAGE
	@RequestMapping("/addRoom.obj")
	public ModelAndView addRoom() throws HbmsException{
		ModelAndView model = new ModelAndView("room_add");
		model.addObject("room", new RoomDetail());
		List<Hotel> hotelList = hbmsService.getHotelList();
		List<Integer> idList = new ArrayList<Integer>();

		if(hotelList == null){
			model.addObject("message", "No Hotel Available");
		}
		else{
			Iterator<Hotel> itr = hotelList.iterator();
			while(itr.hasNext()){
				idList.add(itr.next().getHotelId());
			}
		}
		model.addObject("idList", idList);
		model.addObject("message", null);
		return model;
	}
	
//ADD ROOM TO DATABASE	
	@RequestMapping("/addRoomNow.obj")
	public ModelAndView addRoomNow(@RequestParam("photo") String photo, @ModelAttribute("room") RoomDetail room) throws HbmsException{
		ModelAndView model = new ModelAndView("room_add");
		System.out.println("photo path: "+photo);
		room.setPhoto(new File(photo));
		RoomDetail currRoom = hbmsService.addRoom(room);
		model.addObject("message", HbmsMessages.ROOM_ADDED+", Room ID: "+currRoom.getRoomId());
		model.addObject("room",new RoomDetail());
		return model;
	}
	
//DELETE ROOM FROM DATABASE AND FORWARD TO ROOM DETAILS
	@RequestMapping("/deleteRoom.obj")
	public ModelAndView deleteRoom(@RequestParam("roomId") Integer roomId) throws HbmsException{
		ModelAndView model = new ModelAndView("admin_rooms");
		System.out.println("room : "+roomId);
		String result = hbmsService.deleteRoom(roomId);
		if(result.equals("1"))
			model.addObject("message", HbmsMessages.ROOM_DELETED);
		else
			model.addObject("message", HbmsMessages.ERROR);
		
		List<RoomDetail> roomList = hbmsService.getRoomList();
		if(roomList == null){
			model.addObject("roomList", null);
		}
		else{
			model.addObject("roomList", roomList);
		}
		return model;
	}
	
//FORWARD TO ROOM MODIFICATION PAGE
	@RequestMapping("/modifyRoom.obj")
	public ModelAndView modifyRoom(@RequestParam("roomId") Integer roomId) throws HbmsException{
		ModelAndView model = new ModelAndView("room_modify");
		RoomDetail room = hbmsService.getRoom(roomId);
		
		List<Hotel> hotelList = hbmsService.getHotelList();
		List<Integer> idList = new ArrayList<Integer>();

		if(hotelList == null){
			model.addObject("message", "No Hotel Available");
		}
		else{
			Iterator<Hotel> itr = hotelList.iterator();
			while(itr.hasNext()){
				idList.add(itr.next().getHotelId());
			}
		}
		model.addObject("idList", idList);
		
		model.addObject("room", room);
		return model;
	}
	
//UPDATE DETAILS OF ROOM AND FORWARD TO HOTEL DETAILS PAGE
	@RequestMapping("/modifyRoomNow.obj")
	public ModelAndView modifyRoomNow(@ModelAttribute("room") RoomDetail room) throws HbmsException{
		ModelAndView model = new ModelAndView("admin_rooms");
		RoomDetail updatedRoom;
		
		if(room == null){
			model.addObject("message", HbmsMessages.ROOM_NOT_EXIST);
		}else{
			updatedRoom = hbmsService.modifyRoom(room);
			model.addObject("message", HbmsMessages.ROOM_MODIFIED);
		}
		
		
		List<RoomDetail> roomList = hbmsService.getRoomList();
		if(roomList == null){
			model.addObject("roomList", null);
		}
		else{
			model.addObject("roomList", roomList);
		}
		return model;
	}
	
	/***************************************************************************************
	 * Function :		
	 * Parameter :		
	 * Return type :	
	 * Date :			04/09/2018
	 * Description :	
	 *****************************************************************************************/
	@RequestMapping("/report.obj")
	public ModelAndView goToReport(){
		ModelAndView model = new ModelAndView("report_index");
		return model;
	}
	
	@RequestMapping("/viewAllHotelsReport.obj")
	public ModelAndView hotelReports() throws HbmsException{
		ModelAndView model = new ModelAndView("report_hotels");
		List<Hotel> hotelList= hbmsService.getHotelList();
		if(hotelList==null){
			model.addObject("message", HbmsMessages.HOTEL_NOT_EXIST);
		}else{
			model.addObject("message", null);
		}
		model.addObject("hotelList", hotelList);
		return model;
	}
	
	@RequestMapping("/viewBookingHotelReport.obj")
	public ModelAndView viewBookReport() throws HbmsException{
		ModelAndView model = new ModelAndView("report_select_hotel");
		List<Hotel> hotelList = hbmsService.getHotelList();
		List<Integer> idList = new ArrayList<Integer>();

		if(hotelList == null){
			model.addObject("message",HbmsMessages.HOTEL_NOT_EXIST);
		}
		else{
			Iterator<Hotel> itr = hotelList.iterator();
			while(itr.hasNext()){
				idList.add(itr.next().getHotelId());
			}
		}
		model.addObject("hotel", new Hotel());
		model.addObject("idList", idList);
		model.addObject("hotelList", hotelList);	
		model.addObject("message", null);
		return model;
	}
	

	@RequestMapping("/viewBookingHotelNow.obj")
	public ModelAndView viewBookingHotelNow(@ModelAttribute("hotel") Hotel hotel) throws HbmsException{
		ModelAndView model = new ModelAndView("report_bookings_by_hotel");
		List<BookingDetail> bookingList=hbmsService.getBookingDetails(hotel);
		if(bookingList==null){
			model.addObject("message", HbmsMessages.NO_BOOKING);
		}else{
			model.addObject("message", null);
		}
		model.addObject("bookingList", bookingList);
		return model;
	}
	
	@RequestMapping("/viewGuestHotelReport.obj")
	public ModelAndView viewGuestList() throws HbmsException{
		ModelAndView model = new ModelAndView("report_select_hotel_guest");
		List<Hotel> hotelList = hbmsService.getHotelList();
		List<Integer> idList = new ArrayList<Integer>();

		if(hotelList == null){
			model.addObject("message",HbmsMessages.HOTEL_NOT_EXIST);
		}
		else{
			Iterator<Hotel> itr = hotelList.iterator();
			while(itr.hasNext()){
				idList.add(itr.next().getHotelId());
			}
		}
		model.addObject("hotel", new Hotel());
		model.addObject("idList", idList);
		model.addObject("hotelList", hotelList);	
		model.addObject("message", null);
		return model;
	}
	
	@RequestMapping("/viewGuestHotelNow.obj")
	public ModelAndView viewBookingGuestNow(@ModelAttribute("hotel") Hotel hotel) throws HbmsException{
		ModelAndView model = new ModelAndView("report_guest_by_hotel");
		List<User> userList=hbmsService.getHotelUsers(hotel.getHotelId());
		if(userList==null){
			model.addObject("message", HbmsMessages.NO_USER);
		}else{
			model.addObject("message", null);
		}
		model.addObject("userList", userList);
		return model;
	}
	
	@RequestMapping("/viewBookingDateReport.obj")
	public ModelAndView viewBookingByDate() throws HbmsException{
		ModelAndView model = new ModelAndView("report_select_date_booking");
		model.addObject("booking", new BookingDetail());
		return model;
	}
	
	@RequestMapping("/viewBookingDateNow.obj")
	public ModelAndView viewBookingByDateNow(@ModelAttribute("booking") BookingDetail booking) throws HbmsException{
		ModelAndView model = new ModelAndView("report_bookings_by_date");
		List<BookingDetail> bookingList=hbmsService.getBookingByDate(booking);
		if(bookingList==null){
			model.addObject("message", HbmsMessages.NO_BOOKING);
		}else{
			model.addObject("message", null);
		}
		model.addObject("bookingList", bookingList);
		return model;
	}
	
	/***************************************************************************************
	 * Function :		
	 * Parameter :		
	 * Return type :	
	 * Date :			04/09/2018
	 * Description :	
	 *****************************************************************************************/
	@RequestMapping("/bookHotel.obj")
	public ModelAndView bookHotel(@RequestParam("hotelId") Integer hotelId) throws HbmsException{
		ModelAndView model = new ModelAndView("user_book_hotel");
		List<RoomDetail> roomList = hbmsService.getRoomByHotel(hotelId);
		if(roomList == null){
			model.addObject("message", HbmsMessages.NO_ROOM_AVAILABLE);
		}
		else{
			model.addObject("message", null);
		}
		
		/*List<Blob> imageList = hbmsService.getRoomImages(hotelId);
		
		Iterator<Blob> iterator = imageList.iterator();
		
		if(iterator.hasNext()){
			Blob blob = iterator.next();
			try{
			InputStream inputStream = blob.getBinaryStream();
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        byte[] buffer = new byte[4096];
	        int bytesRead = -1;
	         
	        while ((bytesRead = inputStream.read(buffer)) != -1) {
	            outputStream.write(buffer, 0, bytesRead);                  
	        }
	         
	        byte[] imageBytes = outputStream.toByteArray();
	        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	         
	        model.addObject("image", base64Image);
	        
	        inputStream.close();
	        outputStream.close();
			}catch(Exception e){
				System.out.println("exception in image");
			}
		}
		*/
		
		model.addObject("roomList", roomList);
		return model;
	}
	
	
	@RequestMapping("/bookRoom")
	public ModelAndView bookRoom(@RequestParam("roomId") Integer roomId) throws HbmsException{
		ModelAndView model = new ModelAndView("user_book_room");
		RoomDetail room = hbmsService.getRoom(roomId);
		model.addObject("room", room);
		model.addObject("booking", new BookingDetail());
		return model;
	}
	
	
	@RequestMapping("/bookRoomNow.obj")
	public ModelAndView bookRoomNow(@ModelAttribute("booking") BookingDetail booking,
			@RequestParam("roomId") Integer roomId
			) throws HbmsException{
		ModelAndView model = new ModelAndView("user_book_room");
		booking.setRoomId(roomId);
		booking.setUserId(userScope.getUserId());
		
		BookingDetail currBooking = hbmsService.addBooking(booking);
		model.addObject("message", HbmsMessages.ROOM_ADDED+", Booking ID: "+currBooking.getBookingId());
		return showHotels();
	}
}
