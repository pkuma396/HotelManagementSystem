DROP TABLE bookingdetails;
DROP TABLE roomdetails;
DROP TABLE users;
DROP TABLE hotel;

DROP SEQUENCE user_id_seq;
DROP SEQUENCE hotel_id_seq;
DROP SEQUENCE room_id_seq;
DROP SEQUENCE booking_id_seq;


create table users(
	user_id varchar(4) primary key,
	password varchar(7),
	role varchar(10),
	user_name varchar(20),
	mobile_no varchar(10),
	phone varchar(10),
	address varchar(25),
	email varchar(15));
	
create table hotel(
	hotel_id varchar(4) PRIMARY KEY,
	city varchar(10),
	hotel_name varchar(20),
	address varchar(25),
	description varchar(50),
	avg_rate_per_night number(6,2),
	phone_no1 varchar(10),
	phone_no2 varchar(10),
	rating varchar(4),
	email varchar(15),
	fax varchar(15));
	
create table roomdetails(
	hotel_id varchar(4) references hotel(hotel_id) on delete cascade,
	room_id varchar(4) PRIMARY KEY,
	room_no varchar(3),
	room_type varchar(20),
	per_night_rate number(6,2),
	availability number(1),
	photo blob);
	
create table bookingdetails(
	booking_id varchar(4),
	room_id varchar(4) references roomdetails(room_id) on delete cascade,
	user_id varchar(4) references users(user_id) on delete cascade,
	booked_from date,booked_to date,
	no_of_adults number(2),
	no_of_children number(2),
	amount number(6,2));
	
CREATE SEQUENCE user_id_seq START WITH 1000 INCREMENT BY 1;
CREATE SEQUENCE hotel_id_seq START WITH 2000 INCREMENT BY 1;
CREATE SEQUENCE room_id_seq START WITH 3000 INCREMENT BY 1;
CREATE SEQUENCE booking_id_seq START WITH 4000 INCREMENT BY 1;

