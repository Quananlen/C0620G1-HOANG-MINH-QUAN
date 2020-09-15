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
	id int primary key,    
	category_name varchar(50) 
);

create table book(
	book_name varchar(50) primary key,
    borrow_order_number int,
    borrow_status bit,
    category_id int,
    foreign key (borrow_order_number) references borrow_order(order_number),
    foreign key (category_id) references category(id)
);

insert into student
value (1, 'student A', 'Vietnam', 'a@a.a', 'imgA'),
(2, 'student B', 'Vietnam', 'b@b.b', 'imgB'),
(3, 'student C', 'USA', 'c@c.c', 'imgC');

insert into category
value (1, 'category A'), (2, 'category B');

insert into book (book_name, category_id)
value ('book A', 1),('book B', 2),('book C', 1);

select book_name, c.category_name from book b 
join category c
where b.category_id = c.id
order by book_name;