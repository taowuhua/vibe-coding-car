package com.car.base.service.shop;

import com.car.base.entity.shop.Shop;

/**
 * 微店信息服务接口
 * 定义微店相关的基础业务方法
 *
 * @author system
 * @date 2026-01-16
 */
public interface ShopService {

    /**
     * 根据用户ID获取微店
     *
     * @param userId 用户ID
     * @return 微店信息
     */
    Shop getByUserId(Long userId);

    /**
     * 根据ID获取微店详情
     *
     * @param tid 微店ID
     * @return 微店信息
     */
    Shop getById(Long tid);

    /**
     * 创建微店
     *
     * @param shop 微店信息
     * @return 创建后的微店
     */
    Shop create(Shop shop);

    /**
     * 更新微店信息
     *
     * @param shop 微店信息
     * @return 更新后的微店
     */
    Shop update(Shop shop);

    /**
     * 更新微店车辆数量
     *
     * @param shopId 微店ID
     * @param count  车辆数量
     * @return 是否成功
     */
    boolean updateCarCount(Long shopId, Integer count);
}
