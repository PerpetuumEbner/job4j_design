create database product;

create table type
(
    id   serial primary key,
    name varchar(255)
);

create table product
(
    id           serial primary key,
    name         varchar(255),
    type_id      int references type (id),
    expired_date date,
    price        money,
    amount       int
);

insert into type(name)
values ('Выпечка');

insert into type(name)
values ('Молочная продукция');

insert into type(name)
values ('Десерт');

insert into product(name, type_id, expired_date, price, amount)
values ('Хлеб', 1, '14-Dec-2020', 49, 19);

insert into product(name, type_id, expired_date, price, amount)
values ('Кекс', 1, '25-Dec-2020', 62, 24);

insert into product(name, type_id, expired_date, price, amount)
values ('Печенье', 1, '02-Feb-2021', 81, 120);

insert into product(name, type_id, expired_date, price, amount)
values ('Молоко', 2, '17-Dec-2020', 62, 30);

insert into product(name, type_id, expired_date, price, amount)
values ('Сыр', 2, '12-Jan-2021', 72, 15);

insert into product(name, type_id, expired_date, price, amount)
values ('Творог', 2, '19-Dec-2020', 69, 20);

insert into product(name, type_id, expired_date, price, amount)
values ('Мороженное', 3, '19-Feb-2021', 99, 10);

insert into product(name, type_id, expired_date, price, amount)
values ('Чизкейк', 3, '14-Dec-2020', 62, 5);

insert into product(name, type_id, expired_date, price, amount)
values ('Пудинг ', 3, '16-Dec-2020', 49, 5);

--1. Написать запрос получения всех продуктов с типом "Молочная продукция".
select *
from product
         inner join type t on product.type_id = t.id
where t.name = 'Молочная продукция';

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select *
from product
where name like 'Мороженное';

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select *
from product
where expired_date >= date_trunc('month', current_date) + interval '1 month'
  and expired_date < date_trunc('month', current_date) + interval '2 month';

--4. Написать запрос, который выводит самый дорогой продукт.
select max(price)
from product;

--5. Написать запрос, который выводит количество всех продуктов определенного типа.
select sum(amount)
from product
         inner join type t on product.type_id = t.id
where t.name = 'Выпечка';

--6. Написать запрос получение всех продуктов с типом "Молочная продукция" и "Десерт"
select *
from product
         inner join type t on product.type_id = t.id
where t.name = 'Молочная продукция'
   or t.name = 'Десерт';

--7. Написать запрос, который выводит название продуктов, которых осталось меньше 10 штук.
select name
from product
where amount < 10;

--8. Вывести все продукты и их тип.
select product.name, type.name
from product
         inner join type on product.type_id = type.id;