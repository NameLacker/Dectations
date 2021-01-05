package com.ktwlrj.dectation.modules.service.impl;

import com.ktwlrj.dectation.core.constant.Status;
import com.ktwlrj.dectation.core.exception.ResponseException;
import com.ktwlrj.dectation.core.tools.RandTools;
import com.ktwlrj.dectation.modules.entity.User;
import com.ktwlrj.dectation.modules.mapper.UserMapper;
import com.ktwlrj.dectation.modules.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Stack;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private int n = 100;


    @Override
    public void saveUser(User user) throws RuntimeException {
        while (n < 1000) {
            n++;
            RandTools runoobTest = new RandTools();

            String email1 = runoobTest.getRandomNumbersAndString(10); // 随机字符串
            List<String> emailname = new Stack<>();
            emailname.add("@qq.com");
            emailname.add("@fox.com");
            emailname.add("@163.com");
            int index = runoobTest.getRandomRange(3, 0); // 随机整数
            String email = email1 + emailname.get(index);

            String password = runoobTest.getRandomNumbersAndString(10);
            String name = runoobTest.getRandomNumbersAndString(5);
            long createAt = runoobTest.getRandomRange(100000000, 10000000); // 随机整数

            user.setId(n);
            user.setEmail(email);
            user.setName(name);
            user.setPassword(password);
            user.setCreateAt(createAt);
            userMapper.save(user);
        }
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
