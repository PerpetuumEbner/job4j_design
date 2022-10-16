create table brand
(
    id                  serial primary key,
    name                varchar(255),
    date_of_manufacture timestamp
);

create table models
(
    id       serial primary key,
    name     varchar(255),
    brand_id int references brand (id)
);

insert into brand(name, date_of_manufacture)
values ('BMW', date '2020-10-01');

insert into brand(name, date_of_manufacture)
values ('Audi', date '2021-04-01');

insert into brand(name, date_of_manufacture)
values ('Mercedes-Benz', date '2022-01-10');

insert into models (name, brand_id)
values ('M5 ', 1);

insert into models (name, brand_id)
values ('X7 ', 1);

insert into models (name, brand_id)
values ('8', 1);

insert into models (name, brand_id)
values ('A6', 2);

insert into models (name, brand_id)
values ('A6', 2);

insert into models (name, brand_id)
values ('RS 6', 2);

insert into models (name, brand_id)
values ('Maybach', 3);

insert into models (name, brand_id)
values ('AMG GT С190', 3);

insert into models (name, brand_id)
values ('G AMG W463 ', 3);

select *
from brand
         join models b on brand.id = b.brand_id;

select b.name, m.name
from brand as b
         join models as m
              on m.brand_id = b.id;

select b.name as Бренд, m.name as Модель, b.date_of_manufacture as Дата
from models as m
         join brand b on m.brand_id = b.id