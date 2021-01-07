package com.ktwlrj.dectation.modules.service;

import com.ktwlrj.dectation.modules.entity.Person;

public interface PersonService {

    void insert(Person person);

    Person getPersonById(int id);
}
