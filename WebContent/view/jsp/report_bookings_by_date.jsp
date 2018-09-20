<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="view/css/main.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report of bookings for specific date</title>
</head>

<body>
<jsp:include page="header_user.jsp"/>
<br><br><br><br>
<h1>Bookings for the date</h1>

<c:if test="${list ne null }">
<table border="1" >
	<tr>
		<th>Booking ID</th>
		<th>Room ID</th>
		<th>User ID</th>
		<th>Booked From</th>
		<th>Booked To</th>
		<th>No Of Adults</th>
		<th>No Of Children</th>
		<th>Amount</th>
		
		
		
	</tr>
	<c:forEach var="BookingsList" items="${list}">
		<tr>
			<td>${BookingsList.bookingId}</td>
			<td>${BookingsList.roomId}</td>
			<td>${BookingsList.userId}</td>
			<td>${BookingsList.bookedFrom}</td>
			<td>${BookingsList.bookedTo}</td>
			<td>${BookingsList.noOfAdults}</td>
			<td>${BookingsList.noOfChildren}</td>
			<td>${BookingsList.amount}</td>
	
		</tr>
	</c:forEach>
</table>
</c:if>
<jsp:include page="footer.jsp"/>
</body>
</html>
