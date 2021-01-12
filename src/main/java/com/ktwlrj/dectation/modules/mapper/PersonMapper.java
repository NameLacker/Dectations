package com.ktwlrj.dectation.modules.mapper;

import com.ktwlrj.dectation.modules.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;


public interface PersonMapper {

    boolean insertPerson(Person person);

    Person getPersonById(int id);

    BigInteger getCount();
}
