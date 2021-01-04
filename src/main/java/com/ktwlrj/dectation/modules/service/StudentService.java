package com.ktwlrj.dectation.modules.service;

import com.ktwlrj.dectation.modules.entity.Student;

import java.util.List;

public interface StudentService {
    void add(Student student);

    Student getById(int id);

    List<Student> getAll();
}
