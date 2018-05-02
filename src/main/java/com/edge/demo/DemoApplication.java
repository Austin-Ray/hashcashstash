package com.edge.demo;


import latesco.core.Latesco;
import latesco.core.connector.FrontendConnector;
import latesco.db.abs.Database;

import latesco.db.def.DefaultDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Connection;

import static latesco.db.def.PostgresConnectionKt.getPostgresConnection;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
public class DemoApplication {

  public static FrontendConnector connector;
  public static Connection conn;

  public static void main(String[] args) {


    conn = getPostgresConnection("host", "db", "user", "password");
    Database db = new DefaultDatabase(conn);
    Latesco latesco = new Latesco(db);

    latesco.insertAsset("Bitcoin", "BTC");

    connector = latesco.getConnector();

    SpringApplication.run(DemoApplication.class, args);
  }
}
