package com.ktwlrj.dectation.modules.service;

import com.ktwlrj.dectation.modules.entity.Student;
import com.ktwlrj.dectation.modules.service.dto.CountDto;


public interface StudentService {
    void add(Student student);

    Student getById(int id);

    CountDto<Student> getAll();

    void deleteById(int id);

    void update(Student student);
}
