create table categorized_item_composition(
    id bigint not null auto_increment,
    description varchar(150) not null,
    acronym varchar(10) not null,
    category_id bigint not null,
    class_category_id bigint not null,
    primary key(id),
    foreign key(category_id) references category(id),
    foreign key(class_category_id) references class_category(id)
)