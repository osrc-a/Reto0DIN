create database myusersdb;

use myusersdb;

create table usuario(

uDni varchar(20) primary key,
nombre varchar(20),
apellido varchar(20),
usuario varchar(20),
contraseina varchar(20),
edad integer default 18

);

insert into usuario values (
'16101657Z', 
'Guillermo', 
'flecha', 
'guilleFle', 
'1234', 
21);

select * from usuario;