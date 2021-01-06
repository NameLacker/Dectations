package com.ktwlrj.dectation.modules.service.impl;

import com.ktwlrj.dectation.core.constant.Status;
import com.ktwlrj.dectation.core.exception.ResponseException;
import com.ktwlrj.dectation.modules.entity.User;
import com.ktwlrj.dectation.modules.mapper.UserMapper;
import com.ktwlrj.dectation.modules.service.UserService;
import com.ktwlrj.dectation.modules.service.dto.CountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;


    @Override
    public void saveUser(User user) throws RuntimeException {
        BigInteger number = userMapper.getCount();
        number = number.add(BigInteger.valueOf(1));
        user.setId(number);
        userMapper.save(user);
    }

    @Override
    public User getUser(String name) throws RuntimeException {
        if (StringUtils.isBlank(name)) {
            throw new ResponseException(Status.ERROR, "名字不能为空");
        }
        User user = userMapper.getUserByName(name);
        if (Objects.isNull(user)) {
            throw new ResponseException(Status.DATABASE_BASE_ERROR, "未查询到此名字对应信息");
        }
        return user;
    }

    @Override
    public CountDto<User> getAllUser() throws RuntimeException {
        BigInteger number = userMapper.getCount();
        if (Objects.isNull(number)) {
            throw new ResponseException(Status.DATABASE_BASE_ERROR, "没有获取到数据");
        }
        List<User> allUsers = userMapper.getAllUser();
        if (Objects.isNull(allUsers)) {
            throw new ResponseException(Status.DATABASE_BASE_ERROR, "没有获取到数据");
        }
        return new CountDto<User>(allUsers, number);
    }

    @Override
    public void deleteById(int id) {
        try {
            boolean b = userMapper.deleteById(id);
            if (!b) {
                throw new ResponseException(Status.DATABASE_BASE_ERROR, "删除异常，可能是没有此id对应数据");
            }
        } catch (Exception e) {
            log.error("-------------UserServiceImpl-----删除失败-----deleteById--->\n异常信息:{}", e.getMessage());
            throw new ResponseException(Status.DATABASE_BASE_ERROR, "数据库操作异常，可能是没有此id对应数据");
        }
    }

    @Override
    public void update(User user) {
        try {
            boolean b = userMapper.update(user);
            if (!b) {
                throw new ResponseException(Status.DATABASE_BASE_ERROR, "数据库更新失败，可能是没有此id对应数据");
            }
        } catch (Exception e) {
            log.error("-------------UserServiceImpl-----更新失败-----update--->\n异常信息:{}", e.getMessage());
            throw new ResponseException(Status.DATABASE_BASE_ERROR, "数据库操作异常，可能是没有此id对应数据");
        }
    }
}
