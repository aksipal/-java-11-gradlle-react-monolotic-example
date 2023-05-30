package com.axpal.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {GsonAutoConfiguration.class})
public class AxpalApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctc = SpringApplication.run(new Class[]{
				AxpalApplicationConfiguration.class},args);
		SpringApplication.run(AxpalApplication.class, args);
	}

}