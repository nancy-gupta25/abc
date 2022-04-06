package com.trainingapps.stockapp.orderms;

import com.trainingapps.stockapp.orderms.frontend.FrontEnd;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        
    	SpringApplication.run(DemoApplication.class, args);
    	
/*    	ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        FrontEnd frontEnd = context.getBean(FrontEnd.class);
        frontEnd.runUI();
    }
*/
    }
    
    @Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
