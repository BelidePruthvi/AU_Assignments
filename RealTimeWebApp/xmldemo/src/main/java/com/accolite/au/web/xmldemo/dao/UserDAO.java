package com.accolite.au.web.xmldemo.dao;

import com.accolite.au.web.xmldemo.models.User;

import java.util.List;

public interface UserDAO {
    User getUser(int id);

    User setandGetUserservice(User user);

    void setUp();

    void addUserService(User user);

    List<User> getUsers();

    void editUserService(int id);

}
