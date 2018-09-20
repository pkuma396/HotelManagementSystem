<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link href="view/css/main.css" rel="stylesheet" type="text/css" />
<title>Generate Report</title>

</head>

<body>
<jsp:include page="header_user.jsp"/>
<br><br>
	<h2>Generate Reports</h2>
	
	
	
	
	<div class="black" style="max-width: 2000px">
		<div class="container content padding-32" style="max-width: 1000px">
			<div class="row-padding padding-32" style="margin: 0 -16px">
				<div class="layout">
					<img src="view/images/hotel_management.jpg" alt="Hotel Management"
						style="width: 100%" class="hover-opacity">
					<div class="container white">
						<p>
							<b>VIEW ALL HOTELS</b>
						</p>

						<p>You can view all the hotels and their details</p>
						<a href="viewAllHotelsReport.obj" class="sbutton">VIEW</a> <br>
						<br>
					</div>
				</div>
				<div class="layout">
					<img src="view/images/specific_hotel_booking.jpg" alt="Bookings of Specific Hotel"
						style="width: 100%" class="hover-opacity">
					<div class="container white">
						<p>
							<b>BOOKINGS OF SPECIFIC HOTEL</b>
						</p>

						<p>You can view all the bookings made for specific hotel.</p>
						
						<a href="viewBookingHotelReport.obj" class="sbutton">VIEW</a> <br>
						<br>
					</div>
				</div>
				<div class="layout">
					<img src="view/images/guest-list.jpg" alt="Guest List"
						style="width: 100%" class="hover-opacity">
					<div class="container white">
						<p>
							<b>GUEST LIST OF SPECIFIC HOTEL</b>
						</p>

						<p>You can view the list of guests that have made reservations for a specific hotel.</p>
						
						<a href="viewGuestHotelReport.obj" class="sbutton">VIEW</a> <br>
						<br>
					</div>
				</div>
				<div class="layout">
					<img src="view/images/bookings_date.jpg" alt="Bookins for specific Date"
						style="width: 100%" class="hover-opacity">
					<div class="container white">
						<p>
							<b>BOOKINGS FOR SPECIFIC DATE</b>
						</p>

						<p>You can view all the bookings that have been made on specific date.</p>
						
						<a href="viewBookingDateReport.obj" class="sbutton">VIEW</a> <br>
						<br>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>