DROP DATABASE IF EXISTS analyze_design_db;
CREATE DATABASE analyze_design_db;
USE analyze_design_db;

CREATE TABLE customers (
    customerNumber INT PRIMARY KEY,
    customerName VARCHAR(50) NOT NULL,
    contactLastName VARCHAR(50) NOT NULL,
    contactFirstName VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    addressLine1 VARCHAR(50) NOT NULL,
    addressLine2 VARCHAR(50),
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    postalCode VARCHAR(15) NOT NULL,
    country VARCHAR(50) NOT NULL,
    creditLimit INT
);

CREATE TABLE orders (
    orderNumber INT PRIMARY KEY,
    orderDate DATE NOT NULL,
    requiredDate DATE NOT NULL,
    shippedDate DATE,
    `status` VARCHAR(15) NOT NULL,
    comments TEXT,
    quantityOrdered INT NOT NULL,
    priceEach INT NOT NULL,
    customerNumber INT
);

CREATE TABLE payments (
    customerNumber INT PRIMARY KEY,
    checkNumber VARCHAR(50) NOT NULL,
    paymentDate DATE NOT NULL,
    amount DOUBLE NOT NULL
);

CREATE TABLE products (
    productCode VARCHAR(15) PRIMARY KEY,
    productName VARCHAR(70) NOT NULL,
    productScale VARCHAR(10) NOT NULL,
    productVendor VARCHAR(50) NOT NULL,
    productDescription TEXT NOT NULL,
    quantityInStock INT NOT NULL,
    buyPrice DOUBLE NOT NULL,
    MSRP DOUBLE NOT NULL
);

CREATE TABLE productsLine (
    productLine VARCHAR(50) PRIMARY KEY,
    textDescription TEXT,
    image VARCHAR(255)
);

CREATE TABLE employees (
    employeeNumber INT PRIMARY KEY,
    lastName VARCHAR(50) NOT NULL,
    firstName VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    jobTitle VARCHAR(50) NOT NULL
);

CREATE TABLE offices (
    officeCode VARCHAR(10) PRIMARY KEY,
    city VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    addressLine1 VARCHAR(50) NOT NULL,
    addressLine2 VARCHAR(50),
    state VARCHAR(50),
    country VARCHAR(50) NOT NULL,
    postalCode VARCHAR(15) NOT NULL
);

CREATE TABLE order_details (
    orderNumber INT,
    productCode VARCHAR(15),
    PRIMARY KEY (orderNumber , productCode),
    FOREIGN KEY (orderNumber)
        REFERENCES orders (orderNumber),
    FOREIGN KEY (productCode)
        REFERENCES products (productCode)
);

ALTER TABLE orders
	ADD FOREIGN KEY (customerNumber) REFERENCES customers(customerNumber);
    
ALTER TABLE payments
	ADD FOREIGN KEY (customerNumber) REFERENCES customers(customerNumber);
    
ALTER TABLE products
	ADD productLine VARCHAR(50),
    ADD FOREIGN KEY (productLine) REFERENCES productsLine(productLine);
    
ALTER TABLE customers
    ADD salesRepEmployeeNumber INT,
    ADD FOREIGN KEY (salesRepEmployeeNumber) REFERENCES employees(employeeNumber);

ALTER TABLE employees
	ADD reportTo INT,
    ADD FOREIGN KEY (reportTo) REFERENCES employees(employeeNumber),
    ADD officeCode VARCHAR(10),
    ADD FOREIGN KEY (officeCode) REFERENCES offices(officeCode);

