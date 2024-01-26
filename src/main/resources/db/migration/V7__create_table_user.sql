create table costumer(
    id bigint not null auto_increment,
    name varchar(150) not null,
    email varchar(150) not null,
    password text not null,
    created_at datetime DEFAULT CURRENT_TIMESTAMP,
    primary key(id)
)