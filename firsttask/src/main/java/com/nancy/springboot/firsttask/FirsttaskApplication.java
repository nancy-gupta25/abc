package com.nancy.springboot.firsttask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication = @Configuration + @ComponentScan + @AutoConfiguration
@SpringBootApplication
public class FirsttaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirsttaskApplication.class, args);
	}

}