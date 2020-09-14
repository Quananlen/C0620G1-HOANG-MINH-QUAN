select * from orders;
select orderNumber, orderDate from orders;
select officeCode, officeCode*2 AS 'new value'
 from employees;
 select * from offices
 where country = 'usa';
select customerName, city, phone, creditLimit from customers
where not (creditLimit >= 50000 AND creditLimit <= 100000);
select customerName, creditLimit from customers
where creditLimit between 50000 and 100000;