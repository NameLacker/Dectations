package com.ktwlrj.dectation.modules.service;

import com.ktwlrj.dectation.modules.entity.Person;

public interface UserService {
    Person getPerson(String name) throws RuntimeException;
}
