drop database if exists analyze_design_db;
create database analyze_design_db;
use analyze_design_db;

create table customers (
	customerNumber int primary key,
    customerName varchar(50) not null,
    contactLastName varchar(50) not null,
    contactFirstName varchar(50) not null,
    phone varchar(50) not null,
    addressLine1 varchar(50) not null,
    addressLine2 varchar(50),
    city varchar(50) not null,
    state varchar(50) not null,
    postalCode varchar(15) not null,
    country varchar(50) not null,
    creditLimit int
);

create table orders (
	orderNumber int primary key,
	orderDate date not null,
    requiredDate date not null,
    shippedDate date,
    `status` varchar(15) not null,
    comments text,
    quantityOrdered int not null,
    priceEach int not null,
    customerNumber int
);

create table payments (
	customerNumber int primary key,
    checkNumber varchar(50) not null,
    paymentDate date not null,
    amount double not null
);

create table products (
	productCode varchar(15) primary key,
	productName varchar(70) not null,
    productScale varchar(10) not null,
    productVendor varchar(50) not null,
    productDescription text not null,
    quantityInStock int not null,
    buyPrice double not null,
    MSRP double not null
);

create table productsLine (
	productLine varchar(50) primary key,
    textDescription text,
    image varchar(255)
);

create table employees (
	employeeNumber int primary key,
	lastName varchar(50) not null,
    firstName varchar(50) not null,
    email varchar(100) not null,
    jobTitle varchar(50) not null
);

create table offices (
	officeCode varchar(10) primary key,
    city varchar(50) not null,
    phone varchar(50) not null,
    addressLine1 varchar(50) not null,
    addressLine2 varchar(50),
    state varchar(50),
    country varchar(50) not null,
    postalCode varchar(15) not null
);

create table order_details(
	orderNumber int,
    productCode varchar(15),
    primary key(orderNumber, productCode),
    foreign key (orderNumber) references orders(orderNumber),   
    foreign key (productCode) references products(productCode)
);

alter table orders
	add foreign key (customerNumber) references customers(customerNumber);
    
alter table payments
	add foreign key (customerNumber) references customers(customerNumber);
    
alter table products
	add productLine varchar(50),
    add foreign key (productLine) references productsLine(productLine);
    
alter table customers
    add salesRepEmployeeNumber int,
    add foreign key (salesRepEmployeeNumber) references employees(employeeNumber);

alter table employees
	add reportTo int,
    add foreign key (reportTo) references employees(employeeNumber),
    add officeCode varchar(10),
    add foreign key (officeCode) references offices(officeCode);

