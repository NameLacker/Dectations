package com.ktwlrj.dectation.modules.service.impl;

import com.ktwlrj.dectation.core.constant.Status;
import com.ktwlrj.dectation.core.exception.ResponseException;
import com.ktwlrj.dectation.modules.entity.Student;
import com.ktwlrj.dectation.modules.mapper.StudentMapper;
import com.ktwlrj.dectation.modules.service.StudentService;
import com.ktwlrj.dectation.modules.service.dto.CountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;


@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})  // 事物回滚
    public void add(Student student) {
        int number = studentMapper.getCount().intValue();
        number = number + 1;
        student.setId(number);
        studentMapper.save(student);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})  // 事物回滚
    public Student getById(int id) {
        Student student = studentMapper.findByKey(id);
        if (Objects.isNull(student)) {
            throw new ResponseException(Status.DATABASE_BASE_ERROR, "未查询到对应id的信息");
        }
        return student;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})  // 事物回滚
    public CountDto<Student> getAll() {
        BigInteger number = studentMapper.getCount();
        if (Objects.isNull(number)) {
            throw new ResponseException(Status.DATABASE_BASE_ERROR, "没有获取到数据");
        }
        List<Student> allStudent = studentMapper.findAll();
        if (Objects.isNull(allStudent)) {
            throw new ResponseException(Status.DATABASE_BASE_ERROR, "没有获取到数据");
        }
        return new CountDto<Student>(allStudent, number);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})  // 事物回滚
    public void deleteById(int id) {
        try {
            boolean b = studentMapper.deleteById(id);
            if (!b) {
                throw new ResponseException(Status.DATABASE_BASE_ERROR, "没有删除数据，可能是没有此id对应数据");
            }
        } catch (Exception e) {
            log.error("\n\n-------------StudentServiceImpl-----删除失败-----deleteById--->\n异常信息:{}", e.getMessage());
            throw new ResponseException(Status.DATABASE_BASE_ERROR, "数据库操作异常，可能是没有此id对应数据");
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})  // 事物回滚
    public void update(Student student) {
        try {
            boolean b = studentMapper.update(student);
            if (!b) {
                throw new ResponseException(Status.DATABASE_BASE_ERROR, "数据更新失败，可能是没有此id对应数据");
            }
        } catch (Exception e) {
            log.error("\n\n-------------StudentServiceImpl-----更新失败-----update--->\n异常信息:{}", e.getMessage());
            throw new ResponseException(Status.DATABASE_BASE_ERROR, "数据库操作异常，可能是没有此id对应数据");
        }
    }
}
