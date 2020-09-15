use classicmodels;
select c.customerNumber, customerName, phone, p.paymentDate, p.amount
from customers c
join payments p on c.customerNumber = p.customerNumber
where c.city = 'Las Vegas';

select customers.customerNumber, customers.customerName, orders.orderNumber, orders.status
from customers
left join orders
on customers.customerNumber = orders.customerNumber;

