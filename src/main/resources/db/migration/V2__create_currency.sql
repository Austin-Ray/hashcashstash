CREATE TABLE CURRENCY(
	id int AUTO_INCREMENT,
	name VARCHAR(255),
	symbol VARCHAR(255),
	rank VARCHAR(255),
	sod_price DOUBLE,
	current_price DOUBLE,
	date_time VARCHAR(255)
);

CREATE TABLE CREDENTIALS(
	id INT AUTO_INCREMENT, 
	username VARCHAR(255),
	password VARCHAR(255),
	PRIMARY KEY (id),
	UNIQUE (username)
);

CREATE TABLE USER(
	id INT,
	first_name VARCHAR(255),
	last_name VARCHAR(255),
	FOREIGN KEY (id) REFERENCES crendentials(id)
);



