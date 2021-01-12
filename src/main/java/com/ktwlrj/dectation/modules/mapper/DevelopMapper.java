package com.ktwlrj.dectation.modules.mapper;


import com.ktwlrj.dectation.modules.entity.Developer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;


public interface DevelopMapper {

    boolean insertDeveloper(Developer developer);

    Developer getDevelopById(int id);

    BigInteger getCount();
}
