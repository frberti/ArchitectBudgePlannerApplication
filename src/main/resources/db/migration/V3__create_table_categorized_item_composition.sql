create table categorized_item_composition(
    id bigint not null auto_increment,
    description varchar(150) not null,
    acronym varchar(10) not null,
    category_id bigint not null,
    class_category_id bigint not null,
    created_at datetime DEFAULT CURRENT_TIMESTAMP,
    primary key(id),
    foreign key(category_id) references category(id),
    foreign key(class_category_id) references class_category(id)
);

insert into categorized_item_composition(description, acronym, category_id, class_category_id) values('PEDREIRO DE ALVENARIA', 'PEDAL', 4, 2);

insert into categorized_item_composition(description, acronym, category_id, class_category_id) values('PEDREIRO ESTRUTURAL', 'PEDES', 3, 2);

insert into categorized_item_composition(description, acronym, category_id, class_category_id) values('PEDREIRO DE CONCRETAGEM', 'PEDCO', 7, 2);

insert into categorized_item_composition(description, acronym, category_id, class_category_id) values('AJUDANTE', 'AJUD', 14, 2);

insert into categorized_item_composition(description, acronym, category_id, class_category_id) values('CARPINTEIRO', 'AJUD', 14, 2);

insert into categorized_item_composition(description, acronym, category_id, class_category_id) values('ELETRICISTA', 'ELETR', 12, 2);

insert into categorized_item_composition(description, acronym, category_id, class_category_id) values('PINTOR', 'ELETR', 8, 2);

insert into categorized_item_composition(description, acronym, category_id, class_category_id) values('SERVIÇOS DE SERRALHERIA', 'SERSE', 13, 4);

insert into categorized_item_composition(description, acronym, category_id, class_category_id) values('SERVIÇOS DE ACABAMENTO EM PISOS', 'SERPI', 5, 4);

insert into categorized_item_composition(description, acronym, category_id, class_category_id) values('ARAME RECOZIDO E RETORCIDO 18 BWG', 'PEDR', 3, 1);

insert into categorized_item_composition(description, acronym, category_id, class_category_id) values('PEDRA BRITADA', 'PEDBR', 3, 1);

insert into categorized_item_composition(description, acronym, category_id, class_category_id) values('LASTRO DE CONCRETO MAGRO', 'LASCO', 3, 1);

insert into categorized_item_composition(description, acronym, category_id, class_category_id) values('BRITA CORRIDA PARA BASE OU SUBBASE DE PAVIMENTOS', 'PEDBR', 3, 1);


