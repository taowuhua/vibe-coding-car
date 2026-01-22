package com.car.base.controller.user;

import com.car.base.biz.user.UserBiz;
import com.car.base.common.Result;
import com.car.base.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
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
    public Result<Map<String, Object>> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");
        // 调用 Biz 层处理登录逻辑
        Map<String, Object> tokenMap = userBiz.login(username, password);
        return Result.success(tokenMap);
    }

    /**
     * 获取所有用户列表接口
     *
     * @return 所有用户的列表
     */
    @GetMapping("/users")
    public Result<List<User>> listUsers() {
        // 调用 Biz 层获取用户列表
        List<User> userList = userBiz.getUserList();
        return Result.success(userList);
    }

    /**
     * 测试接口，用于验证后端服务是否正常运行
     *
     * @return "Hello World" 字符串
     */
    @GetMapping("/hello")
    public Result<String> hello() {
        return Result.success("Hello World from Car-Base Service");
    }

    /**
     * 用户注册接口
     *
     * @param registerRequest 包含 username 和 password 的 Map
     * @return 注册成功的用户信息
     */
    @PostMapping("/register")
    public Result<User> register(@RequestBody Map<String, String> registerRequest) {
        String username = registerRequest.get("username");
        String password = registerRequest.get("password");
        // 调用 Biz 层处理注册逻辑
        User user = userBiz.register(username, password);
        return Result.success(user);
    }
}
