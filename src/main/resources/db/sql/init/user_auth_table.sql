PRAGMA foreign_keys = ON;

drop table if exists user_roles;
drop table if exists user;
drop table if exists credentials;

create table user (
	id integer,
	first_name text not null,
	last_name text not null,
	username text not null,
	password text not null,
	role text not null,
	Primary Key (id)
);

