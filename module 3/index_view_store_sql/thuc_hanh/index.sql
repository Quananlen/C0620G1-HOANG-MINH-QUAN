use classicmodels;
explain SELECT * FROM customers WHERE customerNumber = 175; 
ALTER TABLE customers ADD INDEX idx_customerNumber(customerNumber);
ALTER TABLE customers ADD INDEX idx_full_name(contactFirstName, contactLastName);

EXPLAIN SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King';