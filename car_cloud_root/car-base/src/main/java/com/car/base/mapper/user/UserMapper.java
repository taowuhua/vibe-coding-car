package com.car.base.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.car.base.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    // Custom method from XML
    void createTableIfNotExists();
    
    // Explicitly defining findByUsername to match XML if needed, 
    // or we can use QueryWrapper in service. 
    // Since XML exists, we keep it to ensure XML binding works.
    User findByUsername(@Param("username") String username);

    // XML overrides default insert with INSERT IGNORE
    int insert(User user);
}
