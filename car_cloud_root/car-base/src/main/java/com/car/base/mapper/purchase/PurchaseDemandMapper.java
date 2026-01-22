package com.car.base.mapper.purchase;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.car.base.entity.purchase.PurchaseDemand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 求购需求 Mapper 接口
 * 继承 MyBatis-Plus 的 BaseMapper，提供基础 CRUD 功能
 *
 * @author system
 * @date 2026-01-16
 */
@Mapper
public interface PurchaseDemandMapper extends BaseMapper<PurchaseDemand> {

    /**
     * 根据用户ID查询求购需求
     *
     * @param userId 用户ID
     * @return 求购需求列表
     */
    List<PurchaseDemand> findByUserId(@Param("userId") Long userId);

    /**
     * 查询进行中的求购需求
     *
     * @return 求购需求列表
     */
    List<PurchaseDemand> findActive();

    /**
     * 根据品牌查询求购需求
     *
     * @param brand 品牌名称
     * @return 求购需求列表
     */
    List<PurchaseDemand> findByBrand(@Param("brand") String brand);
}
