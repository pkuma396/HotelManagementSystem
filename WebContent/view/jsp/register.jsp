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
<style type="text/css">
body {
	background: #A9AFA9;
}
</style>

</head>
<body>
<jsp:include page="header.jsp"/>

	<div class="form">
		<h1>Registration Form</h1>

		<form:form action="registerNow.obj" method="post"
			modelAttribute="user">
			
			<div class="inner-wrap">
				<table>

					<tr>
						<td class="key">Username:</td>
						<td><form:input class="input" path="userName" id="username"/></td>
					</tr>
					<tr>
						<td class="key">Password:</td>
						<td><form:input class="input" path="password" id="password" /></td>
					</tr>
					<tr>
						<td class="key">Email ID:</td>
						<td><form:input class="input" path="email" id="email"/></td>
					</tr>
					<tr>
						<td class="key">Mobile Number:</td>
						<td><form:input class="input" path="mobileNumber" id="mobile"/></td>
					</tr>
					<tr>
						<td class="key">Phone Number:</td>
						<td><form:input class="input" path="phoneNumber" id="phone"/></td>
					</tr>
					<tr>
						<td class="key">Address:</td>
						<td><form:input class="input" path="address" id="address"/></td>
					</tr>
					<tr>
						<td class="key">Role:</td>
						<td><form:input class="input" path="role" id="role"/></td>
					</tr>
				</table>
			</div>
			
				<input type="submit" class="submit" id="submit" value="Register" onclick="return validateRegister()">
				<c:if test="${message ne null}">
					<h4>${message}</h4>
				</c:if>

		</form:form>
	</div>
	<script src="view/js/validation.js"></script>
</body>
</html>