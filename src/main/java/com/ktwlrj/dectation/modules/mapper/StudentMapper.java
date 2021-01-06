package com.ktwlrj.dectation.modules.mapper;

import com.ktwlrj.dectation.modules.entity.Student;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface StudentMapper {
    void save(Student student);

    Student findByKey(Integer id);

    List<Student> findAll();

    BigInteger getCount();

    boolean deleteById(int id);

    boolean update(Student student);
}
