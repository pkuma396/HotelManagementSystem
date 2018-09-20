<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="view/css/main.css" rel="stylesheet" type="text/css" />
<title>Report of List of Hotels</title>
</head>
<body>
<jsp:include page="header_user.jsp"/>
<br><br><br><br>
<h1>Hotel List</h1>

<c:if test="${message ne null }">
		<h3 class="message">${message }</h3>
	</c:if>

<c:if test="${hotelList ne null }">
<table class="hotel" >
	<tr>
		<th>Hotel Id</th>
		<th>City</th>
		<th>Hotel Name</th>
		<th>Address</th>
		<th>Description</th>
		<th>AvgRatePerNight</th>
		<th>Phone No1</th>
		<th>Phone No2</th>
		<th>Rating</th>
		<th>Email</th>
		<th>Fax</th>
		
	</tr>
	<c:forEach var="hotel" items="${hotelList}">
		<tr>
			<td>${hotel.hotelId}</td>
			<td>${hotel.city}</td>
			<td>${hotel.hotelName}</td>
			<td>${hotel.address}</td>
			<td>${hotel.description}</td>
			<td>${hotel.avgRatePerNight}</td>
			<td>${hotel.phoneNoOne}</td>
			<td>${hotel.phoneNoTwo}</td>
			<td>${hotel.rating}</td>
			<td>${hotel.email}</td>
			<td>${hotel.fax}</td>
			
		</tr>
	</c:forEach>
</table>
</c:if>
</body>
</html>