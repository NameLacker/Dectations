package com.ktwlrj.dectation.modules.service;

import com.ktwlrj.dectation.modules.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user) throws RuntimeException;

    User getUser(String name) throws RuntimeException;

    List<User> getAllUser() throws RuntimeException;

}
