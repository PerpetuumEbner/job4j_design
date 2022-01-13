create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices (name, price) values ('Наушники Sony WH-1000XM4', 27999);
insert into devices (name, price) values ('Смарт-часы Samsung Galaxy Watch4', 27499);
insert into devices (name, price) values ('Беспроводная акустика JBL Flip 5 Teal', 7490);
insert into devices (name, price) values ('Умная розетка Яндекс YNDX-0007', 1199);
insert into devices (name, price) values ('Игровая приставка Sony PlayStation 5', 87450);
insert into devices (name, price) values ('Видеокамера экшн GoPro CHDHX-101-RW', 47899);
insert into devices (name, price) values ('Внешний жесткий диск 2.5" WD 4TB', 7299);

insert into people (name) values ('Екатерина'), ('Николай'), ('Владислав');

insert into devices_people (device_id, people_id) values (1, 2), (6, 1), (2, 2), (7, 2), (3, 3), (4, 3), (5, 3);

select avg(price) from devices;

select p.name Имя, avg(d.price) "Средняя цена"
from people p
join devices_people dp
on dp.people_id = p.id
join devices d
on dp.device_id = d.id
group by p.name;

select p.name Имя, avg(d.price) "Средняя цена"
from people p
join devices_people dp
on dp.people_id = p.id
join devices d
on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;