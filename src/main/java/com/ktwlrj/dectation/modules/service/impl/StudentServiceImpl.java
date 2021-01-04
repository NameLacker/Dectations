package com.ktwlrj.dectation.modules.service.impl;

import com.ktwlrj.dectation.modules.entity.Student;
import com.ktwlrj.dectation.modules.mapper.StudentMapper;
import com.ktwlrj.dectation.modules.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;

    @Override
    public void add(Student student) {
        studentMapper.save(student);
    }

    @Override
    public Student getById(int id) {
        Student student = studentMapper.findByKey(id);
        if (Objects.isNull(student)) {
            throw new RuntimeException("无查询结果");
        }
        return studentMapper.findByKey(id);
    }

    @Override
    public List<Student> getAll() {
        return studentMapper.findAll();
    }
}
