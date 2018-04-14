CREATE TABLE CURRENCY (
	id int AUTO_INCREMENT,
	name VARCHAR(255),
	symbol VARCHAR(255),
	rank VARCHAR(255),
	sod_price DOUBLE,
	current_price DOUBLE,
	date_time VARCHAR(255)
);

CREATE TABLE USER (
	id int AUTO_INCREMENT,
	first_name VARCHAR(255),
	last_name text VARCHAR(255),
	username text VARCHAR(255),
	password text VARCHAR(255),
	role VARCHAR(255),
	PRIMARY KEY (id)
);
