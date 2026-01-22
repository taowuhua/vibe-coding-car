package com.car.base.mapper.shop;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.car.base.entity.shop.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 微店信息 Mapper 接口
 * 继承 MyBatis-Plus 的 BaseMapper，提供基础 CRUD 功能
 *
 * @author system
 * @date 2026-01-16
 */
@Mapper
public interface ShopMapper extends BaseMapper<Shop> {

    /**
     * 根据用户ID查询微店
     *
     * @param userId 用户ID
     * @return 微店信息
     */
    Shop findByUserId(@Param("userId") Long userId);

    /**
     * 更新微店车辆数量
     *
     * @param shopId 微店ID
     * @param count  车辆数量
     * @return 影响行数
     */
    int updateCarCount(@Param("shopId") Long shopId, @Param("count") Integer count);
}
