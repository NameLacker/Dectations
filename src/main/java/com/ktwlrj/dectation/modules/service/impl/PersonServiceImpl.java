package com.ktwlrj.dectation.modules.service.impl;

import com.ktwlrj.dectation.core.constant.Status;
import com.ktwlrj.dectation.core.exception.ResponseException;
import com.ktwlrj.dectation.modules.entity.Person;
import com.ktwlrj.dectation.modules.mapper.PersonMapper;
import com.ktwlrj.dectation.modules.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Objects;


@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonMapper personMapper;

    @Override
    public void insert(Person person) {
        try {
            BigInteger number = personMapper.getCount();
            person.setId(number);
            boolean b = personMapper.insertPerson(person);
            if (!b) {
                throw new ResponseException(Status.DATABASE_BASE_ERROR, "添加失败，可能是数据已经存在");
            }
        } catch (Exception e) {
            log.error("\n\n-------------PersonServiceImpl-----添加失败-----insertPerson--->\n异常信息:{}", e.getMessage());
            throw new ResponseException(Status.DATABASE_BASE_ERROR, "数据库操作异常");
        }
    }

    @Override
    public Person getPersonById(int id) {
        try {
            Person person = personMapper.getPersonById(id);
            if (Objects.isNull(person)) {
                throw new ResponseException(Status.DATABASE_BASE_ERROR, "未查询到对应id相关信息");
            }
            return person;
        } catch (Exception e) {
            log.error("\n\n-------------DevelopeServiceImpl-----查询失败-----getDeveloperById--->\n异常信息:{}", e.getMessage());
            throw new ResponseException(Status.DATABASE_BASE_ERROR, "数据库操作异常，可能是没有此id对应数据");
        }
    }
}
