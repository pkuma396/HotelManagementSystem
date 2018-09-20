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
<h2>Welcome ${user.userName }</h2>

<div style="max-width: 2000px">
		<div class="container content padding-32" style="max-width: 1000px">
			<div class="row-padding padding-32" style="margin: 0 -16px">
				<div class="layout">
					<img src="view/images/hotel_search.jpg" alt="Hotel Management"
						style="width: 100%" class="hover-opacity">
					<div class="container white">
						<p>
							<b>Search for Hotels</b>
						</p>

						<p>You can search for hotels and book a room</p>
						<a href="searchHotel.obj" class="sbutton">Search Hotels</a> <br>
						<br>
					</div>
				</div>
				<div class="layout">
					<img src="view/images/view_bookings.jpg" alt="Room Management"
						style="width: 100%" class="hover-opacity">
					<div class="container white">
						<p>
							<b>View Bookings</b>
						</p>

						<p>You can view your booking details here</p>
						<a href="viewBookings.obj" class="sbutton">My Bookings</a> <br>
						<br>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>