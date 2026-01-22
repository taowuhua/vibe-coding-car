package com.car.base.mapper.record;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.car.base.entity.record.UserRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户记录 Mapper 接口
 * 继承 MyBatis-Plus 的 BaseMapper，提供基础 CRUD 功能
 *
 * @author system
 * @date 2026-01-16
 */
@Mapper
public interface UserRecordMapper extends BaseMapper<UserRecord> {

    /**
     * 查询用户的浏览记录
     *
     * @param userId 用户ID
     * @return 浏览记录列表
     */
    List<UserRecord> findBrowseHistory(@Param("userId") Long userId);

    /**
     * 查询用户的收藏列表
     *
     * @param userId 用户ID
     * @return 收藏记录列表
     */
    List<UserRecord> findFavorites(@Param("userId") Long userId);

    /**
     * 查询用户关注的微店
     *
     * @param userId 用户ID
     * @return 关注记录列表
     */
    List<UserRecord> findFollowedShops(@Param("userId") Long userId);

    /**
     * 检查是否已收藏
     *
     * @param userId 用户ID
     * @param carId  车源ID
     * @return 记录数量
     */
    int checkFavorite(@Param("userId") Long userId, @Param("carId") Long carId);

    /**
     * 删除收藏记录（逻辑删除）
     *
     * @param userId 用户ID
     * @param carId  车源ID
     * @return 影响行数
     */
    int removeFavorite(@Param("userId") Long userId, @Param("carId") Long carId);
}
