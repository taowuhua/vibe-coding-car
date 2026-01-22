package com.car.backend.biz.impl.user;

import com.car.backend.entity.user.User;
import java.util.List;
import java.util.Map;

/**
 * 用户业务层接口
 * 负责整合 Service 层逻辑，处理更复杂的业务规则（如 Token 生成、数据组装等）
 */
public interface UserBiz {

    /**
     * 用户登录业务方法
     * 
     * @param username 用户名
     * @param password 密码
     * @return 包含登录结果的 Map（通常包含 Token 和用户信息）
     */
    Map<String, Object> login(String username, String password);

    /**
     * 获取所有用户列表
     * 
     * @return 用户列表
     */
    List<User> getUserList();
}
