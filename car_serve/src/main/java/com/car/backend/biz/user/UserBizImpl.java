package com.car.backend.biz.user;

import com.car.backend.biz.impl.user.UserBiz;
import com.car.backend.common.utils.JwtUtil;
import com.car.backend.entity.user.User;
import com.car.backend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserBizImpl implements UserBiz {

    /**
     * 用户服务层接口，用于处理底层的数据库操作
     */
    @Autowired
    private UserService userService;

    /**
     * JWT 工具类，用于生成和验证 Token
     */
    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 用户登录业务逻辑
     *
     * @param username 用户名
     * @param password 密码
     * @return 包含 Token 和用户信息的 Map
     * @throws RuntimeException 当用户名或密码错误时抛出异常
     */
    @Override
    public Map<String, Object> login(String username, String password) {
        // 调用 Service 层验证用户名和密码
        User user = userService.login(username, password);
        
        if (user != null) {
            // 登录成功，生成 JWT Token
            String token = jwtUtil.generateToken(user.getUsername());
            
            // 封装返回结果
            Map<String, Object> result = new HashMap<>();
            result.put("token", token);
            result.put("user", user);
            return result;
        }
        
        // 登录失败，抛出异常
        throw new RuntimeException("用户名或密码错误");
    }

    /**
     * 获取所有用户列表
     *
     * @return 用户列表
     */
    @Override
    public List<User> getUserList() {
        // 调用 Service 层获取所有用户
        return userService.getAllUsers();
    }
}
