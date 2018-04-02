package com.edge.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * Created by kelseyedge on 2/14/18.
 * Controller to run the web application. Consider this the "main" method for the whole application
 */

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
