package com.car.base.biz.user.impl;

import com.car.base.biz.user.UserBiz;
import com.car.base.common.utils.JwtUtil;
import com.car.base.entity.user.User;
import com.car.base.service.user.UserService;
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
     * @return 包含登录结果的 Map（成功时包含 Token，失败时包含错误信息）
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

        // 登录失败，返回特定格式的错误信息
        Map<String, Object> errorResult = new HashMap<>();
        errorResult.put("code", "");
        errorResult.put("success", "用户密码不对");
        errorResult.put("data", new HashMap<>());
        errorResult.put("message", "");
        return errorResult;
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

    /**
     * 用户注册
     *
     * @param username 用户名
     * @param password 密码
     * @return 注册成功的用户对象
     */
    @Override
    public User register(String username, String password) {
        // 这里可以添加更多业务逻辑，如发送欢迎邮件等
        return userService.register(username, password);
    }
}
