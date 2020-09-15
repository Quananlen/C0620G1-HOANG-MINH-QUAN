drop database if exists furama_resort;
create database furama_resort;
use furama_resort;

create table `position`(
	id int primary key,
    position_name varchar(45)
);

create table education(
	id int primary key,
    education_name varchar(45)
);

create table department(
	id int primary key,
    department_name varchar(45)
);

create table employee(
	id int primary key,
    `name` varchar(45),
    position_id int,
    education_id int,
    department_id int,
    date_of_birth date,
    id_card_number varchar(45),
    salary varchar(45),
    phone varchar(45),
    email varchar(45),
    address varchar(45),
    foreign key (position_id) references `position`(id),
    foreign key (education_id) references education(id),
    foreign key (department_id) references department(id)
);

create table customer_type(
	id int primary key,
    customer_type_name varchar(45)
);

create table customer(
	id int primary key,
    customer_type_id int,
    `name` varchar(45),
    date_of_birth date,
	id_card_number varchar(45),
    phone varchar(45),
    email varchar(45),
    address varchar(45),
    foreign key (customer_type_id) references customer_type(id)
);

create table rent_type(
	id int primary key,
    `name` varchar(45),
    price int
);

create table service_type(
	id int primary key,
    `name` varchar(45)
);	

create table service(
	id int primary key,
    `name` varchar(45),
    area int,
    floor int,
    max_amount varchar(45),
    rent_cost varchar(45),
    service_type_id int,
    rent_type_id int,
    `status` varchar(45),
    foreign key (rent_type_id) references rent_type(id),
    foreign key (service_type_id) references service_type(id)    
);

create table extra_service(
	id int primary key,
    `name` varchar(45),
    price int,
    amount int,
    `status` varchar(45)
);

create table detail_contract(
	id int,
    contract_id int,
    extra_service_id int,
    constraint id primary key (contract_id,extra_service_id),
    amount int,
    foreign key (extra_service_id) references extra_service(id)
);

create table contract(
	id int primary key,
    employee_id int,
    customer_id int,
    service_id int,
    begin_date date,
    end_date date,
    deposit int,
    total int,
    foreign key (employee_id) references employee(id),
    foreign key (customer_id) references customer(id),
    foreign key (service_id) references service(id)
);

alter table detail_contract
	add foreign key (contract_id) references contract(id);
    
