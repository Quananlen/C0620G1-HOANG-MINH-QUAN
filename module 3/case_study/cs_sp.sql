use furama_resort;
delimiter //
create procedure displayAll()
begin
    select *, c.name as 'c.name', ct.name as 'ct.name' from customer c
    left join customer_type ct on c.customer_type_id = ct.id; 
end //
delimiter ;

delimiter //
create procedure deleteCustomer(input_id varchar(45))
begin
    delete from customer where id = input_id;
end //
delimiter ;

delimiter //
create procedure addCustomer(input_id varchar(45),
                             input_type_id int,
                             input_name varchar(50),
                             input_birthday varchar(50),
                             input_id_card varchar(50),
                             input_phone varchar(50),
                             input_email varchar(50),
                             input_address varchar(50))
begin
    insert into customer(id, customer_type_id, name, date_of_birth, id_card_number, phone, email, address)
        value (input_id, input_type_id, input_name, input_birthday, input_id_card, input_phone, input_email,
               input_address);
end //
delimiter ;

delimiter //
create procedure getCustomer(input_id int)
begin
    select * from customer where id = input_id;  
end //
delimiter ;

delimiter //
create procedure editCustomer(input_id int,
                              input_new_id int,
                              input_type_id int,
                              input_name varchar(50),
                              input_birthday varchar(50),
                              input_id_card varchar(50),
                              input_phone varchar(50),
                              input_email varchar(50),
                              input_address varchar(50))
begin
    update customer
    set id               = input_new_id,
        customer_type_id = input_type_id,
        name             = input_name,
        date_of_birth    = input_birthday,
        id_card_number   = input_id_card,
        phone            = input_phone,
        email            = input_email,
        address          = input_address
    where id = input_id;
end //
delimiter ;

