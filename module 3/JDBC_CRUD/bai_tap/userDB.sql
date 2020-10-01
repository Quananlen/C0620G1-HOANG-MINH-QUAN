drop database if exists user_management;
create database user_management;
use user_management;
create table user
(
    id       int primary key auto_increment,
    `name`   varchar(50),
    birthday varchar(50),
    gender   int,
    phone    varchar(50),
    id_card  varchar(50),
    email    varchar(50),
    address  varchar(50)
);
insert into user (name, birthday, gender, phone, id_card, email, address)
values ("Mai Thế Vinh", "1997-03-31", 1, "197362335", "0334611971", "vinhblue97@gmail.com", "Quang Tri"),
       ("Hoàng Minh Quân", "1997-03-31", 1, "800302698", "4231071065", "eshan@malagaapparel.com", "Sai Gon"),
       ("Huỳnh Ngọc Kim Ngân", "1997-03-31", 0, "351401209", "8535530851", "4kevin-du.595@outdonews.com", "Da Nang"),
       ("Hồ Thị Quỳnh Mai", "1997-03-31", 0, "838810001", "6225707159", "2ahmedmohamed010d@olivestextures.com",
        "Da Nang"),
       ("Nguyễn Quang Danh", "1997-03-31", 1, "459419328", "3798314389", "2ahmedmohamed010d@olivestextures.com",
        "Hue"),
       ("Nguyễn Quốc Khánh", "1997-03-31", 3, "571539768", "7401727418", "4mayurmurudk@enometry.com", "Da Nang"),
       ("Nguyễn Quang Đin", "1997-03-31", 3, "436454769", "2319183198", "qazz.iiz.1j@petruhino2.ru", "Da Nang");
select * from user;

delimiter //
create procedure findByID(inputID int)
begin
    select *
        from user
            where id = inputID;
end //
delimiter ;

delimiter //
create procedure insertUser(user_name varchar(50),
                            user_birthday varchar(50),
                            user_gender int,
                            user_phone varchar(50),
                            user_id_card varchar(50),
                            user_email varchar(50),
                            user_address varchar(50))
begin
    insert into user(`name`, birthday, gender, phone, id_card, email, address)
        value (user_name, user_birthday, user_gender, user_phone, user_id_card, user_email, user_address);
end //
delimiter ;

create table Permission
(
    id   int(11) primary key,
    name varchar(50)
);

create table User_Permission
(
    permission_id int(11),
    user_id       int(11)
);
insert into Permission(id, name) values(1,'add');
insert into Permission(id, name) values(2,'edit');
insert into Permission(id, name) values(3,'delete');
insert into Permission(id, name) values(4,'view');

delimiter //
create procedure displayAll()
begin
	select * from user;
end; //
delimiter ;

delimiter //
create procedure editUser(user_name varchar(50),
                          user_birthday varchar(50),
                          user_gender int,
                          user_phone varchar(50),
                          user_id_card varchar(50),
                          user_email varchar(50),
                          user_address varchar(50),
                          user_id int)
begin
    update user
    set name     = user_name,
        birthday = user_birthday,
        gender   = user_gender,
        phone    = user_phone,
        id_card  = user_id_card,
		email    = user_email,
        address  = user_address
    where id = user_id;
end;
//customer

delimiter //
create procedure deleteUser(user_id int)
begin
    delete from user where id = user_id;
end //
delimiter ;
delimiter ;
                            