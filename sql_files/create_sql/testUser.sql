INSERT INTO credentials (broker_id,username,password) VALUES (1111, "test", "test");

INSERT INTO broker (id,last_name,first_name,phone_num,email,address) VALUES (1111,"Doe","John","5555555555","john.doe@test.com","123 Fake St.");

INSERT INTO client (id,last_name,first_name,phone_num,email,address,cash) VALUES (11112,"Baird","Enzo","8245922080","Enzo.Baird@test.com","7670 E. Liberty Court",82034);
INSERT INTO client (id,last_name,first_name,phone_num,email,address,cash) VALUES (11113,"Acevedo","Thalia","3091476021","Thalia.Acevedo@test.com","8228 Surrey Street",55983);
INSERT INTO client (id,last_name,first_name,phone_num,email,address,cash) VALUES (11114,"Krueger","Jose","9183388741","Jose.Krueger@test.com","9990 East Riverview Road",17717);
INSERT INTO client (id,last_name,first_name,phone_num,email,address,cash) VALUES (11115,"Galvan","Agustin","7093796099","Agustin.Galvan@test.com","445 Dunbar St.",72200);
INSERT INTO client (id,last_name,first_name,phone_num,email,address,cash) VALUES (11116,"Chavez","Erika","2840946032","Erika.Chavez@test.com","49 Race Drive",31076);
INSERT INTO client (id,last_name,first_name,phone_num,email,address,cash) VALUES (11117,"Richardson","Jaidyn","4042317514","Jaidyn.Richardson@test.com","662 Airport St.",91786);
INSERT INTO client (id,last_name,first_name,phone_num,email,address,cash) VALUES (11118,"Davenport","Andres","5352385797","Andres.Davenport@test.com","946 Orchard Street",68014);

INSERT INTO relationship (broker_id,client_id) VALUES (1111,11112);
INSERT INTO relationship (broker_id,client_id) VALUES (1111,11113);
INSERT INTO relationship (broker_id,client_id) VALUES (1111,11114);
INSERT INTO relationship (broker_id,client_id) VALUES (1111,11115);
INSERT INTO relationship (broker_id,client_id) VALUES (1111,11116);
INSERT INTO relationship (broker_id,client_id) VALUES (1111,11117);
INSERT INTO relationship (broker_id,client_id) VALUES (1111,11118);

INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11112,"MSFT",122);
INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11112,"AAPL",204);
INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11112,"TSM",44);
INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11112,"ORCL",94);

INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11113,"MSFT",573);
INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11113,"CSCO",223);
INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11113,"FB",912);
INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11113,"IBM",982);
INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11113,"TSM",340);

INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11114,"IBM",976);
INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11114,"FB",250);
INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11114,"CSCO",766);
INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11114,"GOOG",71);
INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11114,"TSM",875);

INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11115,"TSM",642);
INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11115,"FB",657);
INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11115,"AAPL",368);

INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11116,"ORCL",168);
INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11116,"CSCO",132);

INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11117,"ORCL",584);
INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11117,"AAPL",462);
INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11117,"TSM",309);
INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11117,"GOOG",747);

INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11118,"AAPL",606);
INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11118,"MSFT",887);
INSERT INTO stock_owned (client_id,stock_name,shares) VALUES (11118,"FB",551);
