drop database if exists pop_func;
create database pop_func;
use pop_func;

create table sample(
	id int,
    `name` varchar(10),
    age int,
    course varchar(10),
    amount int
);

insert into sample
value (1,'Hoang',21,'CNTT',400),
(2,'Viet',19,'DTVT',320),
(3,'Thanh',18,'KTDN',400),
(4,'Nhan',19,'CK',450),
(5,'Huong',20,'TCNH',500),
(5,'Huong',20,'TCNH',200);

select * from sample
where `name` = 'Huong';

select sum(amount) from sample
where `name` = 'Huong';

select *, count(`name`) as name_frequency from sample
group by `name`;