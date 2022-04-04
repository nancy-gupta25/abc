package com.trainingapp.bloggerproject.entity;

import java.util.Objects;

public class Blogger {

    private long id;
    private String firstName;
    private String lastName;


    public Blogger(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blogger blogger = (Blogger) o;
        return id == blogger.id && Objects.equals(firstName, blogger.firstName) && Objects.equals(lastName, blogger.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
