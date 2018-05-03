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

package com.edge.demo.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
//import javax.activation.DataSource;

@Configuration
public class PersistenceConfiguration {
  //config properties tells datasource builder to use the connection and properties located in the
  //applications.properties file where the properties begin with the spring.datasource prefix
  //creates a secondary datasource
  //Primary annotation tells spring boot which database source is primary
  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  @Primary
  public DataSource dataSource() {
    return (DataSource) DataSourceBuilder.create().build();
  }

}
