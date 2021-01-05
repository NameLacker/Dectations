package com.ktwlrj.dectation.modules.service.impl;

import com.ktwlrj.dectation.core.constant.Status;
import com.ktwlrj.dectation.core.exception.ResponseException;
import com.ktwlrj.dectation.modules.entity.User;
import com.ktwlrj.dectation.modules.mapper.UserMapper;
import com.ktwlrj.dectation.modules.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;


    @Override
    public void saveUser(User user) throws RuntimeException {
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
    public List<User> getAllUser() throws RuntimeException {
        return userMapper.getAllUser();
    }
}
