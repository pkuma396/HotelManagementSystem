<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="view/css/main.css" rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header_user.jsp" />
	<br>
	<br>

	<h2>Welcome ${user.userName }</h2>



	<div style="max-width: 2000px">
		<div class="container content padding-32" style="max-width: 1000px">
			<div class="row-padding padding-32" style="margin: 0 -16px">
				<div class="layout">
					<img src="view/images/hotel_management.jpg" alt="Hotel Management"
						style="width: 100%" class="hover-opacity">
					<div class="container white">
						<p>
							<b>Hotel Management</b>
						</p>

						<p>Perform actions like add/delete/modify Hotel</p>
						<a href="hotelMgmt.obj" class="sbutton">Hotel Management</a> <br>
						<br>
					</div>
				</div>
				<div class="layout">
					<img src="view/images/room_management.jpg" alt="Room Management"
						style="width: 100%" class="hover-opacity">
					<div class="container white">
						<p>
							<b>Room Management</b>
						</p>

						<p>You can perform actions like add/delete/modify Room</p>
						<a href="roomMgmt.obj" class="sbutton">Room Management</a> <br>
						<br>
					</div>
				</div>
				<div class="layout">
					<img src="view/images/generate_report.jpg" alt="Generate Reports"
						style="width: 100%" class="hover-opacity">
					<div class="container white">
						<p>
							<b>Generate Reports</b>
						</p>

						<p>You can view various reports </p>
						<a href="report.obj" class="sbutton">Generate Reports</a> <br>
						<br>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>