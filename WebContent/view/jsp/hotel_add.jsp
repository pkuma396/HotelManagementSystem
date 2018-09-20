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
	<jsp:include page="header_user.jsp" />
	<br>
	<br>


	<div class="form">
		<h1>Enter Hotel Details</h1>

		<br>
		<c:if test="${message ne null}">
			<h3 class="message">${message }</h3>
		</c:if>
		<form:form action="addHotelNow.obj" method="post"
			modelAttribute="hotel">

			<div>
				<table>

					<tr>
						<td class="key">Hotel Name:</td>
						<td><form:input path="hotelName" class="input" id="hotelName" /></td>
					</tr>

					<tr>
						<td class="key">City:</td>
						<td><form:input path="city" id="city" class="input" /></td>
					</tr>

					<tr>
						<td class="key">Address:</td>
						<td><form:input path="address" id="address" class="input" /></td>
					</tr>

					<tr>
						<td class="key">Description:</td>
						<td><form:input path="description" id="description"
								class="input" /></td>
					</tr>

					<tr>
						<td class="key">Average Rate per night:</td>
						<td><form:input path="avgRatePerNight" id="avgRatePerNight"
								class="input" /></td>
					</tr>

					<tr>
						<td class="key">Phone Number 1:</td>
						<td><form:input path="phoneNoOne" id="phoneNoOne"
								class="input" /></td>
					</tr>

					<tr>
						<td class="key">Phone Number 2:</td>
						<td><form:input path="phoneNoTwo" id="phoneNoTwo"
								class="input" /></td>
					</tr>

					<tr>
						<td class="key">Rating:</td>
						<td><form:input path="rating" id="rating" class="input" /></td>
					</tr>

					<tr>
						<td class="key">Email ID:</td>
						<td><form:input path="email" id="email" class="input" /></td>
					</tr>

					<tr>
						<td class="key">Fax:</td>
						<td><form:input path="fax" id="fax" class="input" /></td>
					</tr>

				</table>
			</div>

			<input type="submit" class="submit" id="submit" value="Add Hotel Now"
				onclick="return validateAddHotel()" />

		</form:form>

	</div>

	<script src="view/js/validation.js"></script>
</body>
</html>