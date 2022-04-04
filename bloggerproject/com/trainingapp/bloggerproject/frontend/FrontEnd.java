package com.trainingapp.bloggerproject.frontend;

import java.util.*;

import com.trainingapp.bloggerproject.entity.Blogger;
import com.trainingapp.bloggerproject.service.IBloggerService;
import com.trainingapp.bloggerproject.service.BloggerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FrontEnd {

    @Autowired
    private IBloggerService service = new BloggerServiceImpl();

    public void runUI() {

        System.out.println("***adding students");
        Blogger blogger1 = service.add("pratibha", "singh");
        // Blogger blogger2 =service.add("amita","yadav");
        display(blogger1);
        // display(blogger2);

    }

    void display(Blogger blogger) {
        System.out.println(blogger.getId() + "-" + blogger.getFirstName() + "-" + blogger.getLastName());
    }

}