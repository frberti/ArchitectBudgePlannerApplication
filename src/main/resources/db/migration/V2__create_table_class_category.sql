create table class_category(
    id bigint not null auto_increment,
    description varchar(150) not null,
    acronym varchar(10) not null,
    created_at datetime DEFAULT CURRENT_TIMESTAMP,
    primary key(id)
);

insert into class_category(description, acronym) values('MATERIAL', 'MAT');

insert into class_category(description, acronym) values('MAO DE OBRA', 'MO');

insert into class_category(description, acronym) values('SERVIÇOS TÉCNICOS', 'STEC');

insert into class_category(description, acronym) values('SERVIÇOS ESPECIALIZADOS', 'SESPE');