CREATE TABLE products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

CREATE TABLE history_of_price
(
    id    serial primary key,
    name  varchar(50),
    price integer,
    date  timestamp
);


INSERT INTO public.products (id, name, producer, count, price)
VALUES (1, 'Молоко', '"ОАО Чебаркульский Молочный Завод"', 50, 79);

INSERT INTO public.products (id, name, producer, count, price)
VALUES (2, 'Кефир', 'АО "ГК "РОСМОЛ"', 50, 81);

INSERT INTO public.products (id, name, producer, count, price)
VALUES (3, 'Ряженка', 'ООО "Ситно"', 50, 68);


CREATE FUNCTION tax_statement()
    RETURNS TRIGGER AS
$$
BEGIN
    UPDATE products
    SET price = price * 1.2
    WHERE id = (select id from inserted);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE FUNCTION tax_row()
    RETURNS TRIGGER AS
$$
BEGIN
    NEW.price = NEW.price * 1.2;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE FUNCTION log_accounting_posting()
    RETURNS TRIGGER AS
$$
BEGIN
    INSERT INTO history_of_price (name, price, date)
    VALUES (NEW.name, NEW.price, now());
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER tax_after
    AFTER INSERT
    ON products
    referencing new table as inserted
    FOR EACH STATEMENT
EXECUTE PROCEDURE tax_statement();

CREATE TRIGGER tax_before
    BEFORE INSERT
    ON products
    FOR EACH ROW
EXECUTE PROCEDURE tax_row();

CREATE TRIGGER accounting_posting
    AFTER INSERT
    ON products
    FOR EACH ROW
EXECUTE PROCEDURE log_accounting_posting();