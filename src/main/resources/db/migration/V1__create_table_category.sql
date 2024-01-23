create table category(
    id bigint not null auto_increment,
    description varchar(150) not null,
    acronym varchar(10) not null,
    created_at datetime DEFAULT CURRENT_TIMESTAMP,
    primary key(id)
)