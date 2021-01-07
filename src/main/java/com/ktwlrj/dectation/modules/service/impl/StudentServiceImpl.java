package com.ktwlrj.dectation.modules.service.impl;

import com.ktwlrj.dectation.core.constant.Status;
import com.ktwlrj.dectation.core.exception.ResponseException;
import com.ktwlrj.dectation.modules.entity.Student;
import com.ktwlrj.dectation.modules.mapper.StudentMapper;
import com.ktwlrj.dectation.modules.model.StorageConfiguration;
import com.ktwlrj.dectation.modules.service.StudentService;
import com.ktwlrj.dectation.modules.service.dto.CountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;


@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;

    @Override
    public void add(Student student) {
        BigInteger number = studentMapper.getCount();
        number = number.add(BigInteger.valueOf(1));
        student.setId(number);
        studentMapper.save(student);
    }

    @Override
    public Student getById(int id) {
        Student student = studentMapper.findByKey(id);
        if (Objects.isNull(student)) {
            throw new ResponseException(Status.DATABASE_BASE_ERROR, "未查询到对应id的信息");
        }
        return student;
    }

    @Override
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
