drop table if exists stock_profile;
drop table if exists profile;
drop table if exists credentials;
drop table if exists currency;


create table credentials (
	user_id			integer,
	username 		text not null,
	password 		text not null check (password<>""),
	primary key(user_id),
	unique(username  collate nocase)
);

create table profile (
	user_id 		integer,
	last_name 		text not null,
	first_name 		text not null,
	email 			text,
	foreign key(user_id) references credentials(user_id)
);

create table stock_profile (
	user_id 		integer,
	stock_id 		text,
	primary key(user_id,stock_id),
	foreign key (user_id) references profile(user_id),
	foreign key (stock_id) references currency(stock_id)
);

create table currency (
	stock_id		text,
	date_time 		text,
	name 			text,
	symbol 			text,
	rank 			integer,
	sod_price 		real,
	current_price 	real,
	primary key (stock_id,date_time)
);
