<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<br>
<br>

<h1>Please select a date to list all bookings</h1>
<br>
	<form:form action="viewBookingDateNow.obj" modelAttribute="booking">

		<form:input type="date" path="bookedFrom" id="bookedFrom" />

		<input type="submit" value="generate report" />


	</form:form>
</body>
</html>