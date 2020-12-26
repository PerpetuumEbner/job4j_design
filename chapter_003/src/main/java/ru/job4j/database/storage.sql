create database storage;

create table body
(
    id   serial primary key,
    name varchar(255)
);

create table engine
(
    id   serial primary key,
    name varchar(255)
);

create table transmission
(
    id   serial primary key,
    name varchar(255)
);

create table car
(
    id              serial primary key,
    name            varchar(255),
    body_id         int references body (id),
    engine_id       int references engine (id),
    transmission_id int references transmission (id)
);

insert into body(name)
values ('Хэтчбек');

insert into body(name)
values ('Седан');

insert into body(name)
values ('Купе');

insert into body(name)
values ('Кабриолет');

insert into body(name)
values ('Пикап');


insert into engine (name)
values ('Бензиновый');

insert into engine (name)
values ('Дизельный');

insert into engine (name)
values ('Газовый');

insert into engine (name)
values ('Газодизельный');

insert into engine (name)
values ('Роторно-поршневой');


insert into transmission (name)
values ('Механическая');

insert into transmission (name)
values ('Роботизированная');

insert into transmission (name)
values ('Гидромеханическая');

insert into transmission (name)
values ('Вариатор');


insert into car(name, body_id, engine_id, transmission_id)
values ('Volvo', 2, 1, 2);

insert into car(name, body_id, engine_id, transmission_id)
values ('Lada', 1, 1, 1);

insert into car(name, body_id, engine_id, transmission_id)
values ('Audi', 2, 1, 4);

insert into car(name, body_id, engine_id, transmission_id)
values ('Toyota', 5, 2, 2);

insert into car(name, body_id, engine_id, transmission_id)
values ('Mazda', 4, 5, 1);

insert into car(name, engine_id)
values ('ГАЗель', 3);

insert into car(name, body_id, transmission_id)
values ('BMW', 2, 4);

insert into car(name, body_id)
values ('Jaguar', 3);

--1. Вывести список всех машин и все привязанные к ним детали.
select *
from car
         left join body b on car.body_id = b.id
         left join engine e on car.engine_id = e.id
         left join transmission t on car.transmission_id = t.id;

--2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
select *
from transmission as t
         left join car c on t.id = c.transmission_id
where c.id is null;

select *
from body as b
         left join car c on b.id = c.body_id
where c.id is null;

select *
from engine as e
         left join car c on e.id = c.engine_id
where c.id is null;