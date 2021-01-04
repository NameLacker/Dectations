package com.ktwlrj.dectation.modules.mapper;

import com.ktwlrj.dectation.modules.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    void save(Student student);

    Student findByKey(Integer id);

    List<Student> findAll();
}
