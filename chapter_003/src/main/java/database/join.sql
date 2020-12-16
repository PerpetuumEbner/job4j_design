create database department;

--1. Создать таблицы и заполнить их начальными данными
create table departments
(
    id   serial primary key,
    name varchar(255)
);

create table employees
(
    id             serial primary key,
    name           varchar(255),
    departments_id int references departments (id)
);

insert into departments(name)
values ('Department 1');

insert into departments(name)
values ('Department 2');

insert into departments(name)
values ('Department 3');


insert into employees(name, departments_id)
values ('Employee 1', 1);

insert into employees(name, departments_id)
values ('Employee 2', 2);

insert into employees(name, departments_id)
values ('Employee 3', 3);

insert into employees(name, departments_id)
values ('Employee 4', 4);

insert into employees(name, departments_id)
values ('Employee 5', 5);

insert into employees(name, departments_id)
values ('Employee 6', null);

--2. Выполнить запросы с:
--left соединениями
select *
from employees e
         left join departments d on e.departments_id = d.id;

--rigth соединениями
select *
from employees e
         right join departments d on e.departments_id = d.id;

--full соединениями
select *
from employees e
         full join departments d on e.departments_id = d.id;

--cross соединениями
select *
from employees e
         cross join departments d;

--3. Используя left join найти работников, которые не относятся ни к одну из департаментов
select *
from employees e
         left join departments d on e.departments_id = d.id
where d.id is null;

--4. Используя left и right join написать запросы, которые давали бы одинаковый результат.
select *
from employees e
         left join departments d on e.departments_id = d.id
select *
from departments d
         right join employees e on d.id = e.departments_id;


select *
from employees e
         right join departments d on e.departments_id = d.id;
select *
from departments d
         right join employees e on d.id = e.departments_id;

--5. Создать таблицу teens с атрибутами name, gender и заполнить ее.
-- Используя cross join составить все возможные разнополые пары
create database teens;

create table teens
(
    id     serial primary key,
    name   varchar(255),
    gender bool
);

insert into teens(name, gender)
values ('Антон', true);

insert into teens(name, gender)
values ('Катя', false);

insert into teens(name, gender)
values ('Лена', false);

insert into teens(name, gender)
values ('Евгений', true);

insert into teens(name, gender)
values ('Дмитрий', true);

insert into teens(name, gender)
values ('Мария', false);


select t1.name, t1.gender, t2.name, t2.gender
from teens as t1
         cross join teens as t2;