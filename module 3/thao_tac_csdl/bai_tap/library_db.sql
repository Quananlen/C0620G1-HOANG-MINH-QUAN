drop database if exists library_db;
create database library_db;
use library_db;

create table student(
	student_number varchar(15) primary key,
    student_name varchar(50),
    address text(500),
    email varchar(50),
    image varchar(50)
);

create table borrow_order(
	order_number int primary key,
	student_number varchar(15) unique,
    book_name varchar(50),
    borrow_date date,
    return_date date,
    foreign key (student_number) references student(student_number)
);

create table category(
	category_name varchar(50) primary key    
);

create table book(
	book_name varchar(50) primary key,
    borrow_order_number int,
    borrow_status bit,
    category varchar(50),
    foreign key (borrow_order_number) references borrow_order(order_number),
    foreign key (category) references category(category_name)
);



