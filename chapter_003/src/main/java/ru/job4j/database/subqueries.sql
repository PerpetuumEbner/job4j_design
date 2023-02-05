CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

INSERT INTO customers (first_name, last_name, age, country)
VALUES ('Ларион', 'Убейсобакин', '38', 'Узбекистан');

INSERT INTO customers (first_name, last_name, age, country)
VALUES ('Софрон', 'Колвашев', '34', 'Армения');

INSERT INTO customers (first_name, last_name, age, country)
VALUES ('Елена', 'Лапина', '46', 'Россия');

INSERT INTO customers (first_name, last_name, age, country)
VALUES ('Алена', 'Шабанова', '48', 'Молдавия');

INSERT INTO customers (first_name, last_name, age, country)
VALUES ('Ольга', 'Сырова', '32', 'Грузия');

INSERT INTO customers (first_name, last_name, age, country)
VALUES ('Кира', 'Бажанова', '41', 'Казахстан');

SELECT *
FROM customers
WHERE age = (SELECT MIN(age)
             FROM customers);

CREATE TABLE orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

INSERT INTO orders (amount, customer_id)
VALUES (5, 1);

INSERT INTO orders (amount, customer_id)
VALUES (10, 2);

INSERT INTO orders (amount, customer_id)
VALUES (38, 4);

INSERT INTO orders (amount, customer_id)
VALUES (13, 6);

SELECT *
FROM customers
WHERE id NOT IN (SELECT customer_id
                 FROM orders);