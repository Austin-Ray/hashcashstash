package com.edge.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnect {

  public static Connection connector() {

    try {
      Class.forName("org.sqlite.JDBC");
      return DriverManager.getConnection("jdbc:sqlite:src/main/resources/db/sql/user_auth.sqlite");
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

  }
}