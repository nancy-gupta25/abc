package com.trainingapp.bloggerproject.dao;

import com.trainingapp.bloggerproject.entity.Blogger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BloggerDaoImpl implements IBloggerDao {

    private HashMap<Long, Blogger> store = new HashMap<>();

    @Override

    public void addBlogger(Blogger blogger) {

        store.put(blogger.getId(), blogger);
    }

}

    @Override
    public Blogger findById(long id) {
        Blogger blogger = store.get(id);
        return blogger;
    }

    @Override
    public Blogger updateBlogger(Blogger blogger) {
        Blogger newBlogger = store.put(blogger.getId(), blogger);
        return blogger;
    }

    @Override
    public List<Blogger> findAll() {
        Collection<Blogger> values = store.values();
        List<Blogger> list = new ArrayList<>();
        list.addAll(values);
        return list;
    }

}
