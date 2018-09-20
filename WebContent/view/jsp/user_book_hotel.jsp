<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>booking_deatils</title>
<link href="view/css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="header_user.jsp" />
	<br>
	<br>
	<br>
	<br>
	<h2>Please Select the Room</h2>

<c:if test="${message ne null }">
		<h3>${message }</h3>
	</c:if>


	<div style="max-width: 2000px">
		<div class="container content padding-32" style="max-width: 1000px">
			<div class="row-padding padding-32" style="margin: 0 -16px">
				<c:if test="${roomList ne null }">
					<c:forEach items="${roomList}" var="room">
						<div class="layout">

							<img src="view/images/hotel_management.jpg"
								alt="Hotel Management" style="width: 100%" class="hover-opacity">
							<div class="container white">
								<table background="${room.photo}">

									<tr>
										<td class="key">Room ID:</td>
										<td>${room.roomId}</td>
									</tr>

									<tr>
										<td class="key">Hotel ID:</td>
										<td >${room.hotelId}</td>
									</tr>

									<tr>
										<td class="key">Room No:</td>
										<td>${room.roomNo}</td>
									</tr>

									<tr>
										<td class="key">Room Type:</td>
										<td>${room.roomType}</td>
									</tr>

									<tr>
										<td class="key">Per Night Rate:</td>
										<td>${room.perNightRate}</td>
									</tr>

									<tr>
										<td class="key">Room Availability:</td>
										<td>${room.availability}</td>
									</tr>

									<tr>
										<td></td>
										<td><br><a class="sbutton" href="bookRoom.obj?roomId=${room.roomId}">Book
												Room</a><br><br></td>
									</tr>

								</table>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>