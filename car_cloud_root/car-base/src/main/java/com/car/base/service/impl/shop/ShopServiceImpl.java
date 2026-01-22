package com.car.base.service.impl.shop;

import com.car.base.entity.shop.Shop;
import com.car.base.mapper.shop.ShopMapper;
import com.car.base.service.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * 微店信息服务实现类
 *
 * @author system
 * @date 2026-01-16
 */
@Service
public class ShopServiceImpl implements ShopService {

    /**
     * 微店信息 Mapper
     */
    @Autowired
    private ShopMapper shopMapper;

    /**
     * 根据用户ID获取微店
     */
    @Override
    public Shop getByUserId(Long userId) {
        return shopMapper.findByUserId(userId);
    }

    /**
     * 根据ID获取微店详情
     */
    @Override
    public Shop getById(Long tid) {
        return shopMapper.selectById(tid);
    }

    /**
     * 创建微店
     */
    @Override
    @Transactional
    public Shop create(Shop shop) {
        // 设置默认值
        shop.setStatus(1);
        shop.setCarCount(0);
        shop.setCreateDate(LocalDateTime.now());
        shop.setUpdateDate(LocalDateTime.now());

        // 插入数据库
        shopMapper.insert(shop);
        return shop;
    }

    /**
     * 更新微店信息
     */
    @Override
    @Transactional
    public Shop update(Shop shop) {
        shop.setUpdateDate(LocalDateTime.now());
        shopMapper.updateById(shop);
        return shop;
    }

    /**
     * 更新微店车辆数量
     */
    @Override
    @Transactional
    public boolean updateCarCount(Long shopId, Integer count) {
        return shopMapper.updateCarCount(shopId, count) > 0;
    }
}
