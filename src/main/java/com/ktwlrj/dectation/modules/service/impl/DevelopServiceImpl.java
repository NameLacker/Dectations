package com.ktwlrj.dectation.modules.service.impl;

import com.ktwlrj.dectation.core.constant.Status;
import com.ktwlrj.dectation.core.exception.ResponseException;
import com.ktwlrj.dectation.modules.entity.Developer;
import com.ktwlrj.dectation.modules.mapper.DevelopMapper;
import com.ktwlrj.dectation.modules.service.DevelopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Objects;


@Slf4j
@Service
@RequiredArgsConstructor
public class DevelopServiceImpl implements DevelopService {

    private final DevelopMapper developMapper;

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})  // 事物回滚
    public Developer getDeveloperById(int id) {
        try {
            Developer developer = developMapper.getDevelopById(id);
            if (Objects.isNull(developer)) {
                throw new ResponseException(Status.DATABASE_BASE_ERROR, "未查询到对应id相关信息");
            }
            return developer;
        } catch (Exception e) {
            log.error("\n\n-------------DevelopeServiceImpl-----查询失败-----getDeveloperById--->\n异常信息:{}", e.getMessage());
            throw new ResponseException(Status.DATABASE_BASE_ERROR, "数据库操作异常，可能是没有此id对应数据");
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})  // 事物回滚
    public void insertDeveloper(Developer developer) {
        try {
            int number = developMapper.getCount().intValue();
            developer.setId(number);
            boolean b = developMapper.insertDeveloper(developer);
            if (!b) {
                throw new ResponseException(Status.DATABASE_BASE_ERROR, "添加失败，可能是数据已经存在");
            }
        } catch (Exception e) {
            log.error("\n\n-------------DevelopeServiceImpl-----添加失败-----insertDeveloper--->\n异常信息:{}", e.getMessage());
            throw new ResponseException(Status.DATABASE_BASE_ERROR, "数据库操作异常");
        }
    }
}
