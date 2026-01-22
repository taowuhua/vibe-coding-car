package com.car.backend.mapper.user;

import com.car.backend.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findAll();

    User findByUsername(String username);

    void createTableIfNotExists();

    void insert(User user);
}
