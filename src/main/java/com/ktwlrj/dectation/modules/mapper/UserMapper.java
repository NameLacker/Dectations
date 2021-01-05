package com.ktwlrj.dectation.modules.mapper;


import com.ktwlrj.dectation.modules.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    void save(User user);

    User getUserByName(String name);

    List<User> getAllUser();
}
