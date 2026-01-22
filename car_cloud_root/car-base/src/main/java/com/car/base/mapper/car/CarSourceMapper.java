package com.car.base.mapper.car;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.car.base.entity.car.CarSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * 车源信息 Mapper 接口
 * 继承 MyBatis-Plus 的 BaseMapper，提供基础 CRUD 功能
 *
 * @author system
 * @date 2026-01-16
 */
@Mapper
public interface CarSourceMapper extends BaseMapper<CarSource> {

    /**
     * 根据品牌查询车源列表
     *
     * @param brand 品牌名称
     * @return 车源列表
     */
    List<CarSource> findByBrand(@Param("brand") String brand);

    /**
     * 根据价格范围查询车源列表
     *
     * @param minPrice 最低价格
     * @param maxPrice 最高价格
     * @return 车源列表
     */
    List<CarSource> findByPriceRange(@Param("minPrice") BigDecimal minPrice,
            @Param("maxPrice") BigDecimal maxPrice);

    /**
     * 根据城市查询车源列表
     *
     * @param city 城市名称
     * @return 车源列表
     */
    List<CarSource> findByCity(@Param("city") String city);

    /**
     * 查询今日上新车源
     *
     * @return 今日上新车源列表
     */
    List<CarSource> findTodayNew();

    /**
     * 查询秒杀车源
     *
     * @return 秒杀车源列表
     */
    List<CarSource> findFlashSale();

    /**
     * 查询新能源车源
     *
     * @return 新能源车源列表
     */
    List<CarSource> findNewEnergy();

    /**
     * 根据微店ID查询车源列表
     *
     * @param shopId 微店ID
     * @return 车源列表
     */
    List<CarSource> findByShopId(@Param("shopId") Long shopId);
}
