package com.trainingapp.bloggerproject.dao;

import java.util.List;

import com.trainingapps.bloggerproject.entity.Blogger;

public interface IBloggerDao {

    void addBlogger(Blogger blogger);

    Blogger findById(long id);

    Blogger updateBlogger(Blogger blogger);

    List<Blogger> findAll();

}
