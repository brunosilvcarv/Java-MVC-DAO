


create database if not exists compradb
default collate utf8_general_ci
default character set utf8;

use compradb;

create table produto(
procodigo int unsigned not null auto_increment,
prodesc text,
proqtd int,
provalor double,
primary key (procodigo)
) engine=InnoDB default charset utf8;


create table compra(
comcodigo int unsigned not null auto_increment,
comdt date,
primary key(comcodigo)
) engine=InnoDB default charset utf8;


create table itemcompra(
itccomcodigo int unsigned not null,
itcprocodigo int unsigned not null,
itcqtd int,
itcvalprodiacompra double,
foreign key(itccomcodigo) references compra(comcodigo),
foreign key(itcprocodigo) references produto(procodigo)
) engine=InnoDB default charset utf8;