<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="view/css/main.css" rel="stylesheet" type="text/css" />
<title>Bookings for Selected Hotel</title>
</head>
<body>
	<jsp:include page="header_user.jsp" />
	<br>
	<br>
	<br>
	<br>
	<h2>List of Bookings for Selected Hotel</h2>

	<c:if test="${message ne null }">
		<h3 class="message">${message }</h3>
	</c:if>


	<c:if test="${bookingList ne null }">
		<table class="booking">

			<tr>
				<th>Booking ID</th>
				<th>Room ID</th>
				<th>User ID</th>
				<th>Booked From</th>
				<th>Booked To</th>
				<th>No of Adults</th>
				<th>No of Children</th>
				<th>Amount</th>
			</tr>


			<c:forEach var="booking" items="${bookingList}">

				<tr>
					<td>${booking.bookingId}</td>
					<td>${booking.roomId}</td>
					<td>${booking.userId}</td>
					<td>${booking.bookedFrom}</td>
					<td>${booking.bookedTo}</td>
					<td>${booking.noOfAdults}</td>
					<td>${booking.noOfChildren}</td>
					<td>${booking.amount}</td>
				</tr>

			</c:forEach>

		</table>
	</c:if>

</body>
</html>