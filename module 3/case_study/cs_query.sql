use furama_resort;
select * from employee;
select * from customer;
-- query 2
select * from employee
where `name` regexp ('H|T|K.*');

-- query 3
 select 
	`name`,
	timestampdiff(year, date_of_birth, current_date) as age,
    address
 from customer where timestampdiff(year, date_of_birth, current_date) >= 18 and timestampdiff(year, date_of_birth, current_date) <= 50
 and address regexp ('.*Đà Nẵng|Quảng Trị');
 
 -- query 4
 select  ct.`name` as customer_type, cu.`name`, count(service_id) as service_count
 from customer cu
 join customer_type ct on cu.customer_type_id = ct.id
 left join contract co on co.customer_id = cu.id 
 left join service s on s.id = co.service_id 
 group by cu.`name` 
 having ct.`name` = 'diamond'
 order by service_count;
 
 -- query 5
 select cu.id, cu.`name`, ct.`name`, co.id as contract, st.`name` as service, begin_date, end_date, 
 s.rent_cost + es.price * es.amount as total
 from customer cu
 join customer_type ct on cu.customer_type_id = ct.id
 left join contract co on co.customer_id = cu.id
 left join service s on co.service_id = s.id
 left join service_type st on s.service_type_id = st.id
 left join detail_contract dc on dc.contract_id = co.id
 left join extra_service es on dc.extra_service_id = es.id;
 
 -- query 6
 select s.id, s.`name` as service, area, rent_cost, st.`name` as `type`, co.id, begin_date, end_date
 from service s
 left join contract co on co.service_id = s.id 
 left join service_type st on s.service_type_id = st.id
 where end_date is null or begin_date is null or end_date < '2019-01-01' or begin_date > '2019-03-31';

-- query 7
select s.id, s.`name`, area, max_amount, rent_cost, st.`name` as `type`, begin_date, end_date
from service s 
left join contract co on co.service_id = s.id
left join service_type st on s.service_type_id = st.id
where year(begin_date) = 2018 and s.id not in (select s.id from service s
join contract c on c.service_id = s.id
 where year(begin_date)=2019); 

-- query 8
select distinct `name` from customer;
select `name` from customer group by `name`;
select `name` from customer
union select `name` from customer;

-- query 9
select * from contract;
select month(begin_date), count(*) from contract
where year(begin_date) = 2019
group by month(begin_date);

-- query 10
select c.id as contract, begin_date, end_date, deposit, count(*) as extra_amount
from contract c
join detail_contract dc on dc.contract_id = c.id
join extra_service es on dc.extra_service_id = es.id
group by c.id;

-- query 11
