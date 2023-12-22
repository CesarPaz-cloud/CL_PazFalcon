create database CL_PazFalcon;

use CL_PazFalcon;

create table categoria (
idcategoria int primary key auto_increment not null,
nombre varchar(45));

create table docente(
iddocente int primary key auto_increment not null,
nombre varchar(45),
dni char(8),
fechNacimiento date,
sueldo double,
email varchar(45),
sexo varchar(45),
idcategoria int,
constraint fk_docente foreign key (idcategoria) references categoria(idcategoria)
);

INSERT INTO categoria (nombre) VALUES ("Física"), ("Química"), ("Biología");

INSERT INTO docente (nombre, dni, fechNacimiento, sueldo, email, sexo, idcategoria)
VALUES ("María López", "25507032", "1990-02-02", 20000, "maria.lopez@email.com", "Femenino", 1),
("Pedro García", "65432109", "1980-03-03", 30000, "pedro.garcia@email.com", "Masculino", 2),
("Ana Fernández", "32109876", "1970-04-04", 40000, "ana.fernandez@email.com", "Femenino", 3);

