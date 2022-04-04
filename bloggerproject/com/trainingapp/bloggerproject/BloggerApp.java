package com.trainingapp.bloggerproject;

import com.trainingapp.bloggerproject.frontend.FrontEnd;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BloggerApp {

    public static void main(String args[]) {
        ConfigurableApplicationContext context = SpringApplication.run(BloggerApp.class, args);
        FrontEnd frontEnd = context.getBean(FrontEnd.class);
        frontEnd.runUI();
        context.close();
    }
}
