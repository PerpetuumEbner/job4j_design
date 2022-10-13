CREATE TABLE products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

create or replace procedure insert_data(i_name varchar, prod varchar, i_count integer, i_price integer)
    language plpgsql
as
$$
BEGIN
    insert into products (name, producer, count, price)
    values (i_name, prod, i_count, i_price);
END
$$;

create or replace procedure update_data(u_count integer, tax float, u_id integer)
    language plpgsql
as
$$
BEGIN
    if u_count > 0 THEN
        update products set count = count - u_count where id = u_id;
    end if;
    if tax > 0 THEN
        update products set price = price + price * tax;
    end if;
END;
$$;

create or replace procedure delete_data(u_id integer)
    language plpgsql
as
$$
BEGIN
    delete from products where id = u_id and count = 0;
END
$$;

create or replace function f_insert_data(i_name varchar, prod varchar, i_count integer, i_price integer)
    returns void
    language plpgsql
as
$$
BEGIN
    insert into products (name, producer, count, price)
    values (i_name, prod, i_count, i_price);
END;
$$;

create or replace function f_update_data(u_count integer, tax float, u_id integer)
    returns integer
    language plpgsql
as
$$
declare
    result integer;
BEGIN
    if u_count > 0 THEN
        update products set count = count - u_count where id = u_id;
        select into result count from products where id = u_id;
    end if;
    if tax > 0 THEN
        update products set price = price + price * tax;
        select into result sum(price) from products;
    end if;
    return result;
END;
$$;

create or replace function f_delete_data(u_id integer)
    returns integer
    language plpgsql
as
$$
declare
    result integer;
BEGIN
    delete from products where id = u_id and count = 0;
    select into result count from products where id = u_id;
    return result;
END;
$$;