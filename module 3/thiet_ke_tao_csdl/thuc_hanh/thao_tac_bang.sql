drop database thao_tac_voi_bang;
create database thao_tac_voi_bang;
USE thao_tac_voi_bang;
create table contacts (
contact_id INT(11) NOT NULL AUTO_INCREMENT,
  last_name VARCHAR(30) NOT NULL,
  first_name VARCHAR(25),
  birthday DATE,
  CONSTRAINT contacts_pk PRIMARY KEY (contact_id)
  );
  CREATE TABLE suppliers
( supplier_id INT(11) NOT NULL AUTO_INCREMENT,
  supplier_name VARCHAR(50) NOT NULL,
  account_rep VARCHAR(30) NOT NULL DEFAULT 'TBD',
  CONSTRAINT suppliers_pk PRIMARY KEY (supplier_id)
);

ALTER TABLE contacts
ADD middle_name varchar(40) NOT NULL
    AFTER contact_id,
ADD number int NULL
    AFTER last_name;
    
ALTER TABLE contacts
  MODIFY last_name varchar(50) NULL;
  
  alter table contacts
  add contact_type int;

-- ALTER TABLE contacts
--   DROP COLUMN contact_type;
  
ALTER TABLE contacts
  CHANGE COLUMN contact_type ctype
    varchar(20) NOT NULL;
    
ALTER TABLE contacts
  RENAME TO people;