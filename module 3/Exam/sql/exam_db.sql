drop database if exists exam_db;
create database exam_db;
use exam_db;
create table student (
	id varchar(50),
	`name` varchar(50),
	birthday date,
	phone varchar(50),
	email varchar(50),
	address varchar(50)
);
insert into student
values (1,'AAA','2020-01-01','111-1111','aa@aa.com','Sai Gon'),
	(2,'BBB','2020-02-02','222-2222','bb@bb.com','Da Nang'),
	(3,'CCC','2020-03-03','333-3333','cc@cc.com','Ha Noi');
    