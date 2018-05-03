/*
 * This file is part of HashCash Stash.
 *
 * HashCash Stash is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * HashCash Stash is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with HashCash Stash.  If not, see <http://www.gnu.org/licenses/>.
 */

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


    conn = getPostgresConnection("aether.austinray.io", "aray", "aray", "thisIsAPassword");
    Database db = new DefaultDatabase(conn);
    Latesco latesco = new Latesco(db);

    latesco.insertAsset("Bitcoin", "BTC");

    connector = latesco.getConnector();

    SpringApplication.run(DemoApplication.class, args);
  }
}
