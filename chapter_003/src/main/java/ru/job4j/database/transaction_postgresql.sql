create table phones
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    ram      integer,
    memory   integer,
    count    integer default 0,
    price    integer
);

insert into phones (name, producer, ram, memory, count, price)
values ('Galaxy S23', 'Samsung', 8, 128, 10, 74990);

insert into phones (name, producer, ram, memory, count, price)
values ('iPhone 14 Pro Max', 'Apple', 6, 256, 5, 149990);

insert into phones (name, producer, ram, memory, count, price)
values ('Pixel ', 'Google', 8, 512, 3, 37999);

begin transaction;

delete
from phones;

select *
from phones;

rollback;

select *
from phones;

begin transaction;

insert into phones (name, producer, ram, memory, count, price)
values ('nova 9 SE', 'HUAWEI', 8, 128, 15, 20990);

savepoint point;

update phones
set price = 19990
where name = 'nova 9 SE';

rollback to point;

select *
from phones;

release point;

commit transaction;