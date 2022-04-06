package com.trainingapps.stockapp.suppliedstockms;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.trainingapps.stockapp.suppliedstockms.frontend.FrontEnd;



@SpringBootApplication
public class SuppliedstockmsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(SuppliedstockmsApplication.class, args);
		FrontEnd frontEnd=context.getBean(FrontEnd.class);
		frontEnd.runUI();
		
		
		
		
	}
	
}
