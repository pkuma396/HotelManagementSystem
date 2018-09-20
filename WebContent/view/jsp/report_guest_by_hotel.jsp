<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bookings for Selected Hotel</title>
<link href="view/css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="header_user.jsp"/>
<br><br>
	<h2>List of Bookings for Selected Hotel</h2>

	<c:if test="${message ne null }">
		<h3>${message }</h3>
	</c:if>

	<c:if test="${userList ne null }">
		<table border="1">

			<tr>
				<th>User ID</th>
				<th>Role</th>
				<th>User Name</th>
				<th>Mobile No</th>
				<th>Phone No</th>
				<th>Address</th>
				<th>Email</th>
			</tr>


			<c:forEach var="user" items="${userList}">

				<tr>
					<td>${user.userId}</td>
					<td>${user.role}</td>
					<td>${user.userName}</td>
					<td>${user.mobileNumber}</td>
					<td>${user.phoneNumber}</td>
					<td>${user.address}</td>
					<td>${user.email}</td>
				</tr>
			</c:forEach>

		</table>
	</c:if>
</body>
</html>