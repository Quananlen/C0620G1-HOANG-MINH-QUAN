show columns from customer;
select * from customer;
select * from service_type;
select * from rent_type;
select * from service;
select *, s.name as 's.name', st.name as 'st.name', rt.name as 'rt.name' 
from service s 
join service_type st on s.service_type_id = st.id
join rent_type rt on rt.id = s.rent_type_id;

select * from employee;
select * from position;
select * from education;
select * from department;
select * 
from employee e
join position p on e.position_id = p.id
join education edu on e.education_id = edu.id
join department d on e.department_id = d.id;
select * from contract;