CREATE TABLE company
(
    id   integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id         integer NOT NULL,
    name       character varying,
    company_id integer references company (id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name)
VALUES (1, 'Alphabet Inc.');
insert into company(id, name)
VALUES (2, 'SpaceX');
insert into company(id, name)
VALUES (3, 'Amazon');
insert into company(id, name)
VALUES (4, 'Microsoft');
insert into company(id, name)
VALUES (5, 'Alibaba');

insert into person(id, name, company_id)
values (1, 'Джон Хеннесси', 1);
insert into person(id, name, company_id)
values (2, 'Ларри Пейдж', 1);
insert into person(id, name, company_id)
values (3, 'Сергей Брин', 1);

insert into person(id, name, company_id)
values (4, 'Илон Маск', 2);
insert into person(id, name, company_id)
values (5, 'Гвинн Шотвелл ', 2);

insert into person(id, name, company_id)
values (6, 'Джефф Безос', 3);

insert into person(id, name, company_id)
values (7, 'Джон Томпсон', 4);
insert into person(id, name, company_id)
values (8, 'Билл Гейтс', 4);

insert into person(id, name, company_id)
values (9, 'Джек Ма ', 5);

select person.name, company.name
from person
         inner join company on person.company_id = company.id
where company.id != 5;

select company.name, count(person.id)
from company
         inner join person on company.id = person.company_id
group by company.name
order by count(person.id) desc
limit 1;