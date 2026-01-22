package com.car.backend.controller;

import com.car.backend.biz.impl.user.UserBiz;
import com.car.backend.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // 允许跨域请求，方便前端调试
public class UserController {

    /**
     * 用户业务逻辑层接口
     */
    @Autowired
    private UserBiz userBiz;

    /**
     * 用户登录接口
     * 接收前端传递的用户名和密码，返回登录结果（包含 Token）
     *
     * @param loginRequest 包含 username 和 password 的 Map
     * @return 登录成功返回 Token 和用户信息
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");
        // 调用 Biz 层处理登录逻辑
        return userBiz.login(username, password);
    }

    /**
     * 获取所有用户列表接口
     *
     * @return 所有用户的列表
     */
    @GetMapping("/users")
    public List<User> listUsers() {
        // 调用 Biz 层获取用户列表
        return userBiz.getUserList();
    }
    
    /**
     * 测试接口，用于验证后端服务是否正常运行
     *
     * @return "Hello World" 字符串
     */
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
