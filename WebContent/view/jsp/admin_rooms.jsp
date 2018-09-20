<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="view/css/main.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header_user.jsp"/>
<br><br><br><br>
	<h1>Room List</h1>
<div>
	<c:if test="${message ne null }">
		<h3 class="message">${message }</h3>
	</c:if>
	
	<c:if test="${roomList ne null }">
		<table class="room">
			<tr>
				<th>Hotel ID</th>
				<th>Room ID</th>
				<th>Room NO.</th>
				<th>Room Type</th>
				<th>Rate Per Night</th>
				<th>Availability</th>
				<th>Action</th>
			</tr>

			<c:forEach items="${roomList}" var="room">
				<tr>

					<td>${room.hotelId }</td>
					<td>${room.roomId }</td>
					<td>${room.roomNo }</td>
					<td>${room.roomType }</td>
					<td>${room.perNightRate}</td>
					<td>${room.availability }</td>
					
					<td>
						<a href="deleteRoom.obj?roomId=${room.roomId}" class="sbutton">Delete</a>
						<a href="modifyRoom.obj?roomId=${room.roomId}" class="sbutton">Modify</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br><br>
<a href="addRoom.obj" class="button">Add Room</a>
</div>
</body>
</html>