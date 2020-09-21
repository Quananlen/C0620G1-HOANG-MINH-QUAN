DROP DATABASE IF EXISTS furama_resort;
CREATE DATABASE furama_resort;
USE furama_resort;

CREATE TABLE `position`(
	id INT PRIMARY KEY,
    position_name VARCHAR(45)
);

CREATE TABLE education(
	id INT PRIMARY KEY,
    education_name VARCHAR(45)
);

CREATE TABLE department(
	id INT PRIMARY KEY,
    department_name VARCHAR(45)
);

CREATE TABLE employee(
	id INT PRIMARY KEY,
    `name` VARCHAR(45),
    position_id INT,
    education_id INT,
    department_id INT,
    date_of_birth DATE,
    id_card_number VARCHAR(45),
    salary VARCHAR(45),
    phone VARCHAR(45),
    email VARCHAR(45),
    address VARCHAR(45),
    FOREIGN KEY (position_id) REFERENCES `position`(id),
    FOREIGN KEY (education_id) REFERENCES education(id),
    FOREIGN KEY (department_id) REFERENCES department(id)
);

CREATE TABLE customer_type(
	id INT PRIMARY KEY,
    `name` VARCHAR(45)
);

CREATE TABLE customer(
	id INT PRIMARY KEY,
    customer_type_id INT,
    `name` VARCHAR(45),
    date_of_birth DATE,
	id_card_number VARCHAR(45),
    phone VARCHAR(45),
    email VARCHAR(45),
    address VARCHAR(45),
    FOREIGN KEY (customer_type_id) REFERENCES customer_type(id)
);

CREATE TABLE rent_type(
	id INT PRIMARY KEY,
    `name` VARCHAR(45),
    price INT
);

CREATE TABLE service_type(
	id INT PRIMARY KEY,
    `name` VARCHAR(45)
);	

CREATE TABLE service(
	id INT PRIMARY KEY,
    `name` VARCHAR(45),
    area INT,
    floor INT,
    max_amount VARCHAR(45),
    rent_cost VARCHAR(45),
    service_type_id INT,
    rent_type_id INT,
    `status` VARCHAR(45),
    FOREIGN KEY (rent_type_id) REFERENCES rent_type(id),
    FOREIGN KEY (service_type_id) REFERENCES service_type(id)    
);

CREATE TABLE extra_service(
	id INT PRIMARY KEY,
    `name` VARCHAR(45),
    price INT,
    amount INT,
    `status` VARCHAR(45)
);

CREATE TABLE detail_contract(
    contract_id INT,
    extra_service_id INT,
    CONSTRAINT id PRIMARY KEY (contract_id,extra_service_id),
    amount INT,
    FOREIGN KEY (extra_service_id) REFERENCES extra_service(id)
);

CREATE TABLE contract(
	id INT PRIMARY KEY,
    employee_id INT,
    customer_id INT,
    service_id INT,
    begin_date DATE,
    end_date DATE,
    deposit INT,
    total INT,
    FOREIGN KEY (employee_id) REFERENCES employee(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (service_id) REFERENCES service(id)
);

ALTER TABLE detail_contract
	ADD FOREIGN KEY (contract_id) REFERENCES contract(id);
    
insert into `position`
value (1,'director'),
(2,'manager'),
(3,'staff');

insert into department
value (1,'administration'),
(2,'accounting'),
(3,'sales');

insert into education
value (1, 'high school'),
(2, 'college'),
(3, 'university');

insert into employee
value (1,'Harley', 3, 3, 2, '1991-01-01', 12345, 5000, 111111, 'HQ@hq.com', 'HHHHH'),  
(2,'Travis', 2, 1, 3, '1992-01-01', 12346, 6000, 111112, 'T@hq.com', 'TTTTT'),  
(3,'Ken', 1, 2, 1, '1993-01-01', 12347, 7000, 111113, 'K@hq.com', 'KKKKK');

insert into customer_type value(1,'diamond'),(2,'platinum'),(3,'gold'),(4,'silver'),(5,'normal');

insert into customer 
value(6,1,'customer A', '1981-01-01','11111','111111','a@a.a','11 Đà Nẵng'),
(7,2,'customer B', '2016-01-02','11112','111112','b@b.b','22 Quảng Trị'),
(8,3,'customer C', '1920-01-02','11113','111113','c@b.b','22 Sai Gon'),
(1,2,'Uzumaki Naruto','1997-12-12','123123123','01230123433','naruto@gmail.com','Quảng Trị'),
(2,1,'Uchiha Suzuke','1997-12-12','123123123','099991239','suzuke@gmail.com','Đà Nẵng'),
(3,1,'Hatake Kakashi','1997-12-12','123123123','0899123123','kakashi@gmail.com','Vinh'),
(4,4,'Rock Lee','1997-12-12','123123123','078122123','lee@gmail.com','Suna'),
(5,5,'Huyga Hinata','2015-12-12','123123123','067123123','hianata@gmail.com','Ikanari');


insert into service_type
value (1,'villa'),(2,'house'),(3,'room');

insert into rent_type
value (1,'year',40000000),(2,'month',400000),(3,'day',40000),(4,'hour',400);

insert into service 
value (1,'villa 1',1000,3,2,400000,1,1,'available'),
(2,'villa 2',1200,4,3,44400,1,1,'full'),
(3,'house 1',200,2,2,40000,2,2,'available'),
(4,'room 1',100,1,2,40000,3,3,'available'),
(5,'room 2',100,3,4,40,3,3,'available'),
(6,'house 2',100,3,4,40,2,3,'available');

insert into contract
value (1,1,2,2,'2019-02-28','2019-03-28',1000,2000),
(2,3,2,3,'2020-01-25','2020-01-26',50,200),
(3,2,3,4,'2019-02-28','2019-03-28',100,2000),
(4,1,3,2,'2019-10-01','2019-10-02',150,2000),
(5,1,2,2,'2019-01-29','2019-05-28',130,2000),
(6,1,1,2,'2018-02-20','2018-05-28',130,2000),
(7,1,1,2,'2020-02-29','2020-05-28',130,2000),
(8,2,4,1,'2018-05-10','2018-05-28',130,2000),
(9,3,5,3,'2018-06-12','2018-06-28',130,2000);

insert into extra_service
value (1,'karaoke',200,1,'ok'),
(2,'đồ uống',300,2,'ok'),
(3,'massage',500,3,'not ok'),
(4,'thức ăn',100,4,'not ok'),
(5,'karaoke',200,5,'ok');

insert into detail_contract 
value (2,3,4),(3,2,1),(4,1,2),(5,3,3),(1,2,5),(1,1,1);