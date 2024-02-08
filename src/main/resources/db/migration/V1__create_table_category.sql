create table category(
    id bigint not null auto_increment,
    description varchar(150) not null,
    acronym varchar(10) not null,
    created_at datetime DEFAULT CURRENT_TIMESTAMP,
    primary key(id)
);

insert into category(description, acronym) values('INSTALAÇÃO E INFRA DO CANTEIRO', 'INST');

insert into category(description, acronym) values('BASICOS', 'BASI');

insert into category(description, acronym) values('ESTRUTURAIS', 'ESTR');

insert into category(description, acronym) values('ALVENARIA', 'ALVE');

insert into category(description, acronym) values('PISOS', 'PIS');

insert into category(description, acronym) values('REVESTIMENTOS', 'REVES');

insert into category(description, acronym) values('CONCRETAGENS', 'CONCR');

insert into category(description, acronym) values('PINTURA', 'PINT');

insert into category(description, acronym) values('COBERTURA', 'COBER');

insert into category(description, acronym) values('IMPERMEABILIZAÇÕES', 'IMPER');

insert into category(description, acronym) values('HIDROSANITÁRIOS', 'HIDRS');

insert into category(description, acronym) values('ELÉTRICA', 'ELETR');

insert into category(description, acronym) values('ESQUADRIAS', 'ESQUA');

insert into category(description, acronym) values('DIVERSOS', 'DIVE');