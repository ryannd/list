package com.ryannd.list_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// remove when starting database
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class ListApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListApiApplication.class, args);
	}

}
