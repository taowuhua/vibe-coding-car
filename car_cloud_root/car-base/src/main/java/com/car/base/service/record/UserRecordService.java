package com.car.base.service.record;

import com.car.base.entity.record.UserRecord;

import java.util.List;

/**
 * 用户记录服务接口
 * 定义浏览记录、收藏等相关的基础业务方法
 *
 * @author system
 * @date 2026-01-16
 */
public interface UserRecordService {

    /**
     * 获取用户浏览记录
     *
     * @param userId 用户ID
     * @return 浏览记录列表
     */
    List<UserRecord> getBrowseHistory(Long userId);

    /**
     * 获取用户收藏列表
     *
     * @param userId 用户ID
     * @return 收藏记录列表
     */
    List<UserRecord> getFavorites(Long userId);

    /**
     * 添加收藏
     *
     * @param record 记录信息
     * @return 添加后的记录
     */
    UserRecord addFavorite(UserRecord record);

    /**
     * 取消收藏
     *
     * @param userId 用户ID
     * @param carId  车源ID
     * @return 是否成功
     */
    boolean removeFavorite(Long userId, Long carId);

    /**
     * 添加浏览记录
     *
     * @param record 记录信息
     * @return 添加后的记录
     */
    UserRecord addBrowseHistory(UserRecord record);

    /**
     * 检查是否已收藏
     *
     * @param userId 用户ID
     * @param carId  车源ID
     * @return 是否已收藏
     */
    boolean isFavorite(Long userId, Long carId);
}
