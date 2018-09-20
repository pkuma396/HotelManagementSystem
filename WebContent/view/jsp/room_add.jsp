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
	

	<div class="form">
		<h1>Enter Room Details</h1>
<br>
<c:if test="${message ne null }">
		<h3 class="message">${message }</h3>
	</c:if>
		<form:form action="addRoomNow.obj" method="post" modelAttribute="room">

			<div>
				<table>
					<tr>
						<td class="key">Hotel ID:</td>
						<td><form:select path="hotelId" class="select">
								<form:option value="" label="--Select--" />
								<form:options items="${idList}" />
							</form:select></td>
					</tr>
					<tr>
						<td class="key">Room Number:</td>
						<td><form:input path="roomNo" id="roomNo" class="input" /></td>
					</tr>

					<tr>
						<td class="key">Room Type:</td>
						<td><form:select path="roomType" id="roomType" class="select">
								<form:option value="" label="Select RoomType" />
								<form:option value="Standard non A/C"
									label="Standard non A/C room" />
								<form:option value="Standard A/C" label="Standard A/C room" />
								<form:option value="Executive A/C" label="Executive A/C room" />
								<form:option value="Deluxe A/C" label="Deluxe A/C room" />
							</form:select></td>
					</tr>

					<tr>
						<td class="key">Rate Per Night:</td>
						<td><form:input type="number" id="perNightRate" path="perNightRate"
								class="input" /></td>
					</tr>
					<tr>
						<td class="key">Availability:</td>
						<td><form:select path="availability" id="availability" class="select">
								<form:option value="" label="Select" />
								<form:option value="1" label="Available" />
								<form:option value="0" label="Not Available" />
							</form:select></td>

					</tr>
					<tr>
						<td class="key">Image:</td>
						<td><input type="file" id="photo" name="photo" /></td>
					</tr>

				</table>
			</div>

			<input type="submit" id="submit" value="Add Room" onclick="return validateAddRoom()" />

		</form:form>

	</div>
<script src="view/js/validation.js"></script>
</body>
</html>