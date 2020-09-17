drop database if exists demo;
create database demo;
use demo;
CREATE TABLE products (
    id INT,
    productCode INT,
    productName VARCHAR(50),
    productPrice INT,
    productAmount INT,
    productDescription VARCHAR(50),
    productStatus VARCHAR(50)
);
insert into products
value (1,1,'A',1,1,'aaa','available'),
(2,2,'B',2,2,'bbb','available'),
(3,3,'C',3,3,'ccc','available'),
(4,4,'D',4,4,'ddd','available'),
(5,5,'E',5,5,'eee','available');

create index idx_code on products(productcode);
explain select * from products where productName = 'A';
create index idx_name_price on products(productName,productPrice);
explain select * from products where productName = 'A';

select * from products;
create view view1 as 
select productCode, productName, productPrice, productStatus
from products;

select * from view1;
update view1 
set productName = 'F' where productCode = 1;
drop view view1;

delimiter //
create procedure view_all_products() 
begin 
	select * from products;
end; //
delimiter ;
call view_all_products;

delimiter //
create procedure add_product(id INT,
    productCode INT,
    productName VARCHAR(50),
    productPrice INT,
    productAmount INT,
    productDescription VARCHAR(50),
    productStatus VARCHAR(50))
begin
	insert into products value (id,productCode,productName,productPrice,productAmount,productDescription,productStatus);
end; //
delimiter ;
call add_product(7,5,'E',5,5,'eee','available');

delimiter //
create procedure delete_product_by_id(num int)
begin
	delete from products where id = num;
end; //
delimiter ;
-- call delete_product_by_id(7);

delimiter //
create procedure update_product(iid INT,
    iproductCode INT,
    iproductName VARCHAR(50),
    iproductPrice INT,
    iproductAmount INT,
    iproductDescription VARCHAR(50),
    iproductStatus VARCHAR(50))
begin
	update products 
    set productCode = iproductCode,
    productName = iproductName,
    productPrice = iproductPrice,
    productAmount = iproductAmount,
    productDescription = iproductDescription,
    productStatus = iproductStatus
    where id = iid;
end; //
delimiter ;
call update_product(7,7,'Z',7,7,'zzz','not available');
