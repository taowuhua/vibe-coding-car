package com.car.base.service.impl.user;

import com.car.base.entity.user.User;
import com.car.base.mapper.user.UserMapper;
import com.car.base.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.annotation.PostConstruct;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    /**
     * User Mapper 接口，用于数据库 CRUD 操作
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 初始化方法，在 Bean 创建完成后执行
     * 用于检查数据库表结构和初始化默认数据
     */
    @PostConstruct
    public void init() {
        // 自动初始化表结构（如果表不存在则创建）
        userMapper.createTableIfNotExists();
        
        // 检查是否存在管理员账号，如果不存在则创建默认管理员
        // 账号: admin, 密码: 123456
        if (userMapper.findByUsername("admin") == null) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("123456");
            userMapper.insert(admin);
        }
    }

    /**
     * 获取所有用户信息
     *
     * @return 包含所有用户的列表
     */
    @Override
    public List<User> getAllUsers() {
        // use MyBatis-Plus selectList
        return userMapper.selectList(null);
    }

    /**
     * 执行用户登录逻辑
     *
     * @param username 用户名
     * @param password 密码
     * @return 如果用户名存在且密码匹配，返回用户对象；否则返回 null
     */
    @Override
    public User login(String username, String password) {
        // 根据用户名查询用户
        User user = userMapper.findByUsername(username);
        
        // 验证用户是否存在以及密码是否正确
        // 注意：生产环境建议使用加密存储密码（如 BCrypt）
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null; // 登录失败
    }

    /**
     * 用户注册实现
     *
     * @param username 用户名
     * @param password 密码
     * @return 注册成功的 User 对象
     */
    @Override
    @Transactional
    public User register(String username, String password) {
        // 1. 检查用户名是否已存在
        User existingUser = userMapper.findByUsername(username);
        if (existingUser != null) {
            throw new RuntimeException("用户名已存在");
        }

        // 2. 创建新用户对象
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password); // 注意：此处仍为明文，生产环境需加密

        // 3. 插入数据库
        userMapper.insert(newUser);

        return newUser;
    }
}
