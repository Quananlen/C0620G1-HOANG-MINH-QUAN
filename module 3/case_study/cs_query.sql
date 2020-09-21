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
create view view11 as
select cu.`name`, ct.`name` as `type`, address, es.`name` as extra
from customer cu
join contract co on co.customer_id = cu.id
join detail_contract dc on dc.contract_id = co.id
join extra_service es on dc.extra_service_id = es.id
join customer_type ct on cu.customer_type_id = ct.id;
select * from view11 where `type` = 'Diamond' and address regexp ('.*Vinh|(Quảng Ngãi)');

-- query 12
create view view12 as
select co.id, e.`name` as employee, cu.`name` as customer, cu.phone, s.`name` as service, es.amount, deposit, begin_date
from contract co
join customer cu on co.customer_id = cu.id
join employee e on co.employee_id = e.id
join service s on co.service_id = s.id
join detail_contract dc on dc.contract_id = co.id
join extra_service es on dc.extra_service_id = es.id;
select * from view12 where begin_date >= '2019-10-01' and begin_date <= '2019-12-31' 
and id not in (
	select id from contract
    where begin_date >= '2019-01-01' and begin_date <= '2019-06-30' 
) ;

-- query 13
create view view13 as
select co.id as contract, es.`name` as extra
from contract co
join detail_contract dc on dc.contract_id = co.id
join extra_service es on dc.extra_service_id = es.id;

create view view13_1 as
select contract, count(*) as count from view13 group by contract;

select * from view13_1 where count = (select max(count) from view13_1);

-- query 14
create view view14 as
select co.id, s.`name` as service, es.`name` as extra, count(es.id) as count
from contract co
join service s on co.service_id = s.id
join detail_contract dc on dc.contract_id = co.id
join extra_service es on dc.extra_service_id = es.id
group by es.id;

select * from view14 where count = 1;

-- query 15
drop view if exists view15;
create view view15 as
select e.id, e.`name`, edu.education_name as education, d.department_name as department, phone, email, begin_date, count(e.id) as count
from employee e
join contract co on co.employee_id = e.id
join education edu on e.education_id = edu.id
join department d on e.department_id = d.id
where year(begin_date) = 2018 
group by e.id
having count <= 3;

select * from view15;

-- query 16
drop view if exists view16;
create view view16 as
select e.`name` as employee
from employee e
join contract co on co.employee_id = e.id
where year(begin_date) between 2017 and 2019
group by employee;

delete from employee
where `name` not in (select * from view16);

-- query 17
drop view if exists view17;
create view view17 as 
select cu.`name` as customer_name, ct.id as id, ct.`name` as `type`, total 
from customer cu
join customer_type ct on cu.customer_type_id = ct.id
join contract co on co.customer_id = cu.id
where ct.`name` = 'Platinum' and year(begin_date) = 2019;

drop view if exists view17_1;
create view view17_1 as
select *, sum(total) as sum from view17 
group by `type`
having sum > 10000000;

update customer
set customer_type_id = 1 where `name` in (select customer_name from view17_1);

-- query 18
create view view18 as
select cu.`name`, co.id, begin_date
from customer cu
join contract co on co.customer_id = cu.id
where year(begin_date) < 2016;

delete from customer
where `name` in (select * from ( select `name` from view18) as t );

-- query 19
drop view if exists view19;
create view view19 as
select es.id as service_id, es.`name`, price, count(extra_service_id) as count
from extra_service es
join detail_contract dc on dc.extra_service_id = es.id
group by es.id
having count > 10;

update extra_service
set price = price * 2 where id in (select service_id from view19); 

-- query 20
select id, `name`, email, phone, date_of_birth, address, 'employee' as employee
from employee as employee
union 
select id, `name`, email, phone, date_of_birth, address, 'customer' as customer
from customer as customer;

-- query 21
create view v_nhanvien as
select * 
from employee e
join contract co on co.employee_id = e.id
where address = 'Hải Châu' and begin_date = '2019-12-12';

-- query 22
update v_nhanvien
set address = 'Liên Chiểu';

-- query 23
delimiter //
create procedure sp_1(id_var int)
begin
	delete from customer
    where id = id_var;
end //
delimiter ;

call sp_1(1);

-- query 24
delimiter //
create procedure sp_2()
begin

end //
delimiter ;

-- query 27
