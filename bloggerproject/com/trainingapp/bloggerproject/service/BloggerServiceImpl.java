package com.trainingapp.bloggerproject.service;

import com.trainingapp.bloggerproject.dao.BloggerDaoImpl;
import com.trainingapp.bloggerproject.dao.IBloggerDao;
import com.trainingapp.bloggerproject.entity.Blogger;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class BloggerServiceImpl implements IBloggerService {

    @Autowired
    private IBloggerDao dao;

    private int generatedId;

    int generateId() {
        return ++generatedId;
    }

    @Override
    public Blogger addBlogger(String firstName, String lastName) throws InvalidBloggerNameException {
        validateFirstName(firstName);
        validateLastName(lastName);
        int id = generateId();
        Blogger blogger = new Blogger(firstName, lastName);
        dao.addBlogger(blogger);
        return blogger;
    }

    @Override

    public Blogger register(String firstName, String lastName) {

        validateFirstName(firstName);
        validateLastName(lastName);

        long id = generateId();
        Blogger blogger = new Blogger(id, firstName, lastName);
        return blogger;
    }

    @Override

    public Blogger findById(long id) {
        validateId(id);
        Blogger blogger = dao.findById(id);
        return blogger;
    }

    @Override

    public Blogger changeBloggerName(long id, String newFirstName, String newLastName) {
        validateFirstName(firstName);
        validateLastName(lastName);

        Blogger updateBlogger = dao.findById(id);
        updateblogger.setFirstName(newFirstName);
        updateblogger.setLastName(newLastName);

        dao.updateblogger(updateblogger);
        return updateblogger;
    }

    @Override
    public List<Blogger> findAll() {

        List<Blogger> result = dao.findAll();
        return result;
    }


    void validateName(String firstName, String lastName) throws InvalidBloggerNameException {
        if (firstName.length() < 2 || firstName.length() > 10 || lastName.length() < 2 || lastame.length() > 10) {
            throw new InvalidBloggerNameException("invalid name argument ");
        }
    }


}
