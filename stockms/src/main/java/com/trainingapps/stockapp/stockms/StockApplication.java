package com.trainingapps.stockapp.stockms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.trainingapps.stockapp.stockms.frontend.FrontEnd;

/**
 * @Configuration
 * @ComponentScan
 * @EnableAutoConfiguration
 *
 */
@SpringBootApplication
public class StockApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(StockApplication.class, args);
		FrontEnd frontEnd=context.getBean(FrontEnd.class);
		frontEnd.runUI();	}

	
}
