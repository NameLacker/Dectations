package com.ktwlrj.dectation.modules.service;

import com.ktwlrj.dectation.modules.entity.Developer;

public interface DevelopService {

    Developer getDeveloperById(int id);

    void insertDeveloper(Developer developer);
}
