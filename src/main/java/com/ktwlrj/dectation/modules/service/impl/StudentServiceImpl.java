package com.ktwlrj.dectation.modules.service.impl;

import com.ktwlrj.dectation.core.constant.Status;
import com.ktwlrj.dectation.core.exception.ResponseException;
import com.ktwlrj.dectation.core.tools.RandTools;
import com.ktwlrj.dectation.modules.entity.Student;
import com.ktwlrj.dectation.modules.mapper.StudentMapper;
import com.ktwlrj.dectation.modules.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;
    private int n = 100;
    private String gender;

    @Override
    public void add(Student student) {
        while (n < 1000) {
            n++;
            RandTools runoobTest = new RandTools();
            String name = runoobTest.getRandomNumbersAndString(5);
            int score = runoobTest.getRandomRange(100, 0); // 随机整数
            int age = runoobTest.getRandomRange(100, 0); // 随机整数

            int index = runoobTest.getRandomRange(2, 0); // 随机整数
            if (index == 0) {
                gender = "male";
            }
            else {
                gender = "lady";
            }

            student.setId(n);
            student.setName(name);
            student.setScore(score);
            student.setAge(age);
            student.setGender(gender);
            studentMapper.save(student);
        }
    }

    @Override
    public Student getById(int id) {
        Student student = studentMapper.findByKey(id);
        if (Objects.isNull(student)) {
            throw new ResponseException(Status.DATABASE_BASE_ERROR, "未查询到对应id的信息");
        }
        return studentMapper.findByKey(id);
    }

    @Override
    public List<Student> getAll() {
        return studentMapper.findAll();
    }
}
