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
<br><br>
<h1>Please Enter details</h1>

<c:if test="${message ne null }">
<h3>${message }</h3>
</c:if>
<div class="form">
<form:form action="bookRoomNow.obj?roomId=${room.roomId}" method="post" modelAttribute="booking" id="bookingForm">
<table>

<tr>
<td class="key">Room ID: </td>
<td>${room.roomId }</td>
</tr>

<tr>
<td class="key">Booked From: </td>
<td><form:input type="date" class="input" path="bookedFrom" id="fromDate"/></td>
</tr>

<tr>
<td class="key">Booked To: </td>
<td><form:input type="date" class="input" path="bookedTo" id="toDate"/></td>
</tr>

<tr>
<td class="key">No. of Adults: </td>
<td><form:input path="noOfAdults" id="noOfAdults"/></td>
</tr>

<tr>
<td class="key">No. of Children</td>
<td><form:input path="noOfChildren" class="input" id="noOfChildren"/></td>
</tr>

<tr>
<td class="key">Amount: </td>
<td><form:input path="amount" class="input" id="amount" readonly="true"></form:input></td>
</tr>

<tr>
<td><input type="button" class="sbutton" onclick="calculateAmount(${room.perNightRate})" value="Calculate Amount"></td>
<td><input type="submit" class="sbutton" value="Book Room Now" onclick="return validateBookRoom(${room.perNightRate})"></td>
</tr>

</table>
</form:form>
</div>
<script  src="view/js/validation.js"></script>
<jsp:include page="footer.jsp"/>
</body>
</html>