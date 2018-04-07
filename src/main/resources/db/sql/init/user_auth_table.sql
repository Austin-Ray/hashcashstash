PRAGMA foreign_keys = ON;

drop table if exists user_roles;
drop table if exists user;
drop table if exists credentials;

create table credentials (
	id integer,
	username text not null,
	password text not null,
	primary key (id),
	unique (username)
);

create table user (
	id integer,
	first_name text not null,
	last_name text not null,
	email text,
	foreign key (id) references credentials(id) on delete cascade 
);

create table user_roles (
	id integer,
	role text not null,
	foreign key (id) references credentials(id) on delete cascade
);
