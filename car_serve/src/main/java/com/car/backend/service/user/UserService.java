package com.car.backend.service.user;

import com.car.backend.entity.user.User;
import java.util.List;

/**
 * 用户服务接口
 * 定义用户相关的基础业务方法
 */
public interface UserService {
    
    /**
     * 获取所有用户
     * @return 用户对象的列表
     */
    List<User> getAllUsers();

    /**
     * 用户登录验证
     * 
     * @param username 用户名
     * @param password 密码
     * @return 登录成功的用户对象，如果失败则返回 null
     */
    User login(String username, String password);
}
