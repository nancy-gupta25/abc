package com.trainingapp.bloggerproject.service;

import java.util.List;

import com.trainingApps.bloggerproject.entity.Blogger;

public interface IBloggerService {


    Blogger register(String firstName, String lastName);

    Blogger findById(long id);

    Blogger changeBloggerName(long id, String newFirstName, newLastName);
}
