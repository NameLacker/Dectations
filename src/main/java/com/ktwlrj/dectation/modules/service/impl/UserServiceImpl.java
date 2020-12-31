package com.ktwlrj.dectation.modules.service.impl;

import com.ktwlrj.dectation.modules.entity.Person;
import com.ktwlrj.dectation.modules.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Override
    public Person getPerson(String name) throws RuntimeException {
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException("名字不能为空");
        }
        Person person = new Person();
        person.setName(name);
        person.setGender("male");
        person.setTall(172.5);
        person.setWeights(60.5);
        return person;
    }
}
