create table customer_role(
    id bigint not null auto_increment,
    customer_id bigint not null,
    role_id bigint not null,
    foreign key(customer_id) references customer(id),
    foreign key(role_id) references role(id)
);

insert into customer_role(customer_id, role_id) values(1, 1);
insert into customer_role(customer_id, role_id) values(1, 2);
insert into customer_role(customer_id, role_id) values(2, 1);