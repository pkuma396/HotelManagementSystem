<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="view/css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="header_user.jsp"/>
<br><br><br><br>
<h2>Booking Details</h2><br>

<c:if test="${message ne null }">
		<h3 class="message">${message }</h3>
	</c:if><br>

<c:if test="${bookingList ne null }">
<table class="booking">
<tr>
<th>Booking ID</th>
<th>Room ID</th>
<th>From Date</th>
<th>To Date</th>
<th>No of Adults</th>
<th>No of Children</th>
<th>Amount</th>
</tr>
 
<c:forEach items="${bookingList}" var="booking">
<tr>

<td>${booking.bookingId }</td>
<td>${booking.roomId }</td>
<td>${booking.bookedFrom }</td>
<td>${booking.bookedTo }</td>
<td>${booking.noOfAdults }</td>
<td>${booking.noOfChildren }</td>
<td>${booking.amount }</td>
</tr>
</c:forEach>

</table>

</c:if>


</body>
</html>