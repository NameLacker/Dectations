package com.ktwlrj.dectation.modules.service;

import com.ktwlrj.dectation.modules.entity.User;
import com.ktwlrj.dectation.modules.service.dto.CountDto;


public interface UserService {
    void saveUser(User user) throws RuntimeException;

    User getUser(String name) throws RuntimeException;

    CountDto<User> getAllUser() throws RuntimeException;

    void deleteById(int id);

    void update(User user);
}
