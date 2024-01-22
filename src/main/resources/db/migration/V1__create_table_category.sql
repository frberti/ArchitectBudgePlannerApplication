create table category(
    id bigint not null auto_increment,
    description varchar(150) not null,
    acronym varchar(10) not null,
    primary key(id)
)