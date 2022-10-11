CREATE TABLE types
(
    id   SERIAL PRIMARY KEY,
    name TEXT UNIQUE
);

CREATE TABLE brands
(
    id   SERIAL PRIMARY KEY,
    name TEXT UNIQUE
);

CREATE TABLE engines
(
    id   SERIAL PRIMARY KEY,
    name TEXT UNIQUE
);

CREATE TABLE cars
(
    id          SERIAL PRIMARY KEY,
    yearOfIssue INTEGER,
    type_id     INT NOT NULL REFERENCES types (id),
    brand_id    INT NOT NULL REFERENCES brands (id),
    engine_id   INT NOT NULL REFERENCES engines (id)
);

CREATE TABLE ads
(
    id      SERIAL PRIMARY KEY,
    photo   bytea,
    created TIMESTAMP,
    status  BOOLEAN,
    price   INTEGER,
    mileage INTEGER,
    car_id  INT NOT NULL REFERENCES cars (id)
);

INSERT INTO types (id, name)
VALUES (1, 'Седан');

INSERT INTO types (id, name)
VALUES (2, 'Хэтчбек');

INSERT INTO types (id, name)
VALUES (3, 'Лифтбек');

INSERT INTO ads (id, photo, created, status, price, car_id, mileage)
VALUES (1, E'\\x313831303030', '2022-10-11 10:00:00.000000', true, 685000, 1, 181000);

INSERT INTO ads (id, photo, created, status, price, car_id, mileage)
VALUES (2, E'\\x313831303030', '2022-10-11 11:00:00.000000', true, 899000, 1, 190000);

INSERT INTO ads (id, photo, created, status, price, car_id, mileage)
VALUES (3, E'\\x313539303030', '2022-10-11 12:00:00.000000', false, 659000, 2, 4500);

INSERT INTO ads (id, photo, created, status, price, car_id, mileage)
VALUES (4, E'\\x3637323636', '2022-10-11 13:00:00.000000', false, 599000, 3, 159000);

INSERT INTO brands (id, name)
VALUES (1, 'Audi');

INSERT INTO brands (id, name)
VALUES (2, 'BMW');

INSERT INTO brands (id, name)
VALUES (3, 'Mercedes-Benz');

INSERT INTO engines (id, name)
VALUES (1, 'Бензин');

INSERT INTO engines (id, name)
VALUES (2, 'Дизель');

INSERT INTO cars (id, yearofissue, type_id, brand_id, engine_id)
VALUES (1, 2008, 1, 3, 1);

INSERT INTO cars (id, yearofissue, type_id, brand_id, engine_id)
VALUES (2, 2021, 3, 15, 2);

INSERT INTO cars (id, yearofissue, type_id, brand_id, engine_id)
VALUES (3, 2013, 2, 20, 1);

INSERT INTO cars (id, yearofissue, type_id, brand_id, engine_id)
VALUES (4, 2018, 3, 27, 2);

INSERT INTO cars (id, yearofissue, type_id, brand_id, engine_id)
VALUES (5, 2019, 1, 18, 1);

create view view_add as
select *
from ads
         join cars c on c.id = ads.car_id
         join engines e on e.id = c.engine_id
         join brands b on b.id = c.brand_id
         join types t on t.id = c.type_id