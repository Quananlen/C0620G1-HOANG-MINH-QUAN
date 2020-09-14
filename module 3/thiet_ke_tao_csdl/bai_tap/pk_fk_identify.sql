create database pk_fk_identify;
use pk_fk_identify;

create table phone (
	phone_num varchar(10) primary key
);

create table email (
    email varchar(50) primary key
);

create table customers (
	customer_number int auto_increment primary key,
    fullname varchar(50) not null,
    address varchar(50) not null,
    email varchar(50) unique not null,
    phone varchar(10) unique
);

create table accounts (
	account_number int primary key,
    account_type varchar(50) not null,
    `date` date,
    balance int not null,
    customer_number int unique not null
);

CREATE TABLE transactions (
    tran_number INT PRIMARY KEY,
    account_number INT,
    `date` DATE,
    amounts INT,
    `description` VARCHAR(255)
);

alter table phone add foreign key (phone_num) references customers(phone);
alter table email add foreign key (email) references customers(email);
alter table accounts add foreign key (customer_number) references customers(customer_number);
alter table transactions add FOREIGN KEY (account_number) REFERENCES accounts (account_number);