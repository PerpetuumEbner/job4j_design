-- many-to-one

create table passenger
(
    id   serial primary key,
    name varchar(255)
);

create table flights
(
    id           serial primary key,
    name         varchar(255),
    passenger_id int references passenger (id)
);

-- many-to-many

create table flights
(
    id   serial primary key,
    name varchar(255)
);

create table aircraft
(
    id   serial primary key,
    name varchar(255)
);

create table flights_aircraft
(
    id          serial primary key,
    aircraft_id int references aircraft (id),
    flights_id  int references flights (id)
);

-- one-to-one

create table passenger
(
    id   serial primary key,
    name varchar(255)
);

create table boarding_pass
(
    id   serial primary key,
    name varchar(255)
);

create table passenger_boarding_pass
(
    id               serial primary key,
    passenger_id     int references passenger (id) unique,
    boarding_pass_id int references boarding_pass (id) unique
)