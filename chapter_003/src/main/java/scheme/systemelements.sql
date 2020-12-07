create table users (
    id serial primary key,
    name varchar(2000),
	request_id int references request(id)
);

create table roles (
    id serial primary key,
    name varchar(2000),
	users_id int references users(id)
);

create table rules (
    id serial primary key,
    name varchar(2000)
);

create table roles_rules (
    id serial primary key,
    roles_id int references roles(id),
	rules_id int references rules(id),
	attached_files int references attached_files(id)
);

create table request (
    id serial primary key,
    name varchar(2000),
	comments_id int references comments(id),
	comments_id int references attached_files(id)
);

create table comments (
    id serial primary key,
    name varchar(2000)
);

create table attached_files (
    id serial primary key,
    name varchar(2000)
);

create table category (
    id serial primary key,
    name varchar(2000),
	request_id int references request(id)
);

create table state (
    id serial primary key,
    name varchar(2000),
	request_id int references request(id)
);