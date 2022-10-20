create table film
(
    id   serial primary key,
    name varchar(50)
);

create table person
(
    id      serial primary key,
    name    varchar(50),
    address varchar(100),
    sex     varchar(50)
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


insert into person (name, address, sex)
values ('Ольга Егорова', '1-ый Казанский переулок, д. 14', 'женский');

insert into person (name, address, sex)
values ('Иванов Сергей', 'ул. Центральная, д. 40, кв. 74', 'мужской');

insert into person (name, address, sex)
values ('Иванов Сергей', 'ул. Ленина, д. 7, кв. 130', 'мужской');


insert into public.film_rental (person_id, film_id)
values (1, 1);

insert into public.film_rental (person_id, film_id)
values (1, 2);

insert into public.film_rental (person_id, film_id)
values (2, 3);

insert into public.film_rental (person_id, film_id)
values (2, 4);

insert into public.film_rental (person_id, film_id)
values (3, 2);


select p.name as Имя, p.address as Адрес, f.name as Название, p.sex as Пол
from film_rental
         join person p on person_id = p.id
         join film f on film_id = f.id;