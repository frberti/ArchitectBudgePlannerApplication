create table customer(
    id bigint not null auto_increment,
    name varchar(150) not null,
    email varchar(150) not null,
    password text not null,
    created_at datetime DEFAULT CURRENT_TIMESTAMP,
    primary key(id)
);

insert into customer(name, email, password) values(
    'FRANCISCO BERTI',
    'francisco@email.com',
    '$2a$12$zUuMISA54TO/P5Qmwus06OiILc7IK9S7R5D4vbHqqkoK8htnNUf1i');

insert into customer(name, email, password) values(
    'CAIO PERSIGHINI',
    'caio@email.com',
    '$2a$12$zUuMISA54TO/P5Qmwus06OiILc7IK9S7R5D4vbHqqkoK8htnNUf1i');