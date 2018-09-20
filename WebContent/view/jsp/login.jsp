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
	<jsp:include page="header.jsp" />

	<br>
	<div class="login">
		<h2>Login Details</h2>
		<table>
			<form:form action="loginNow.obj" method="post" modelAttribute="user"
				class="container">
				<tr>
					<td><form:input path="userName" id="username" class="input"
							placeholder="Username" /></td>
				</tr>
				<form:errors path="userName"></form:errors>

				<tr>
					<td><form:input type="password" path="password" id="password"
							class="input" placeholder="Password" />
							<c:if test="${message ne null }">
								<h4>${message}</h4>
							</c:if>
					</td>
				</tr>
				<tr>
					<td><input type="submit" class="submit" id="submit"
						value="Login" onclick="return validateLogin()" /></td>
				</tr>
			</form:form>
		</table>
	</div>
	<script src="view/js/validation.js"></script>
</body>
</html>