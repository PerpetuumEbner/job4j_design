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

/**
  Step 1. Transaction 1.
 */
begin transaction isolation level serializable;

/**
  Step 2. Transaction 2.
 */
begin transaction isolation level serializable;

/**
  Step 3. Transaction 1.
 */
select sum(count)
from phones;

/**
  Step 4. Transaction 1.
 */
update phones
set count = 5
where id = 1;

/**
  Step 5. Transaction 2.
 */
select sum(count)
from phones;

/**
  Step 6. Transaction 2.
 */
update phones
set count = 4
where id = 2;

/**
  Step 7. Transaction 2.
 */
commit;

/**
  Step 8. Transaction 1.
 */
commit;