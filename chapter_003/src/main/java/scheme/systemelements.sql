create table users (
	id serial primary key,
    name varchar(2000),
	role_id int references role(id)
);

create table roles (
    id serial primary key,
    name varchar(2000),
);

create table rules (
    id serial primary key,
    name varchar(2000)
);

create table roles_rules (
    id serial primary key,
	role_id int references role(id)
	rules_id int references rules(id)
);

create table request (
    id serial primary key,
    name varchar(2000),
	users_id int references users(id),
	category_id int references category(id)
	state_id int references state(id)
);

create table comments (
    id serial primary key,
    name varchar(2000)
	request_id int references request(id)
);

create table attached_files (
    id serial primary key,
    name varchar(2000)
	request_id int references request(id)
);

create table category (
    id serial primary key,
    name varchar(2000),
);

create table state (
    id serial primary key,
    name varchar(2000),
);