package com.edge.demo.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;
//import javax.activation.DataSource;

/**
 * Created by kelseyedge on 2/14/18.
 * This class manages the consistency and configuration of the database(s)
 */

@Configuration
public class PersistenceConfiguration {
    //config properties tells datasource builder to use the connection and properties located in the
    //applications.properties file where the properties begin with the spring.datasource prefix
    //creates a secondary datasource
    //Primary annotation tells spring boot which database source is primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource dataSource(){
        return (DataSource) DataSourceBuilder.create().build();
    }

}
