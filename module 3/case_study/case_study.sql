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
    customer_type_name VARCHAR(45)
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
    
