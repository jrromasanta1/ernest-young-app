package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class StartSpringApplication {
    	public static void main(String[] args) {
		ConfigurableApplicationContext springcontext = SpringApplication.run(StartSpringApplication.class, args);
	
		System.out.println("Application is ready!!");
	}
}
