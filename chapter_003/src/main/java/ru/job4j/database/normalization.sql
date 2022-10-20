create table film
(
    id   serial primary key,
    name varchar(50)
);

create table sex
(
    id   serial primary key,
    name varchar(50)
);

create table person
(
    id      serial primary key,
    name    varchar(50),
    address varchar(100),
    sex_id  int references sex (id)
);

create table film_rental
(
    id        serial primary key,
    person_id int references person (id),
    film_id   int references film (id)
);


insert into film (name)
values ('Пираты Карибского моря');

insert into film (name)
values ('Матрица: Революция');

insert into film (name)
values ('Человек, который изменил всё');

insert into film (name)
values ('Интерстеллар');


insert into sex (name)
values ('мужской');

insert into sex (name)
values ('женский');


insert into person (name, address, sex_id)
values ('Ольга Егорова', '1-ый Казанский переулок, д. 14', 2);

insert into person (name, address, sex_id)
values ('Иванов Сергей', 'ул. Центральная, д. 40, кв. 74', 1);

insert into person (name, address, sex_id)
values ('Иванов Сергей', 'ул. Ленина, д. 7, кв. 130', 1);


insert into film_rental (person_id, film_id)
values (1, 1);

insert into film_rental (person_id, film_id)
values (1, 2);

insert into film_rental (person_id, film_id)
values (2, 3);

insert into film_rental (person_id, film_id)
values (2, 4);

insert into film_rental (person_id, film_id)
values (3, 2);


select p.name as Имя, p.address as Адрес, f.name as Фильм, s.name as Пол
from film_rental
         join person p on person_id = p.id
         join film f on film_id = f.id
         join sex s on p.sex_id = s.id;