package com.car.base.service.car;

import com.car.base.entity.car.CarSource;

import java.math.BigDecimal;
import java.util.List;

/**
 * 车源信息服务接口
 * 定义车源相关的基础业务方法
 *
 * @author system
 * @date 2026-01-16
 */
public interface CarSourceService {

    /**
     * 分页查询车源列表
     *
     * @param brand    品牌（可选）
     * @param city     城市（可选）
     * @param minPrice 最低价格（可选）
     * @param maxPrice 最高价格（可选）
     * @param pageNum  页码
     * @param pageSize 每页数量
     * @return 车源列表
     */
    List<CarSource> listCars(String brand, String city, BigDecimal minPrice,
            BigDecimal maxPrice, int pageNum, int pageSize);

    /**
     * 根据ID获取车源详情
     *
     * @param tid 车源ID
     * @return 车源信息
     */
    CarSource getById(Long tid);

    /**
     * 发布车源
     *
     * @param carSource 车源信息
     * @return 发布后的车源
     */
    CarSource publish(CarSource carSource);

    /**
     * 更新车源信息
     *
     * @param carSource 车源信息
     * @return 更新后的车源
     */
    CarSource update(CarSource carSource);

    /**
     * 删除车源（逻辑删除）
     *
     * @param tid 车源ID
     * @return 是否成功
     */
    boolean delete(Long tid);

    /**
     * 获取今日上新车源
     *
     * @return 车源列表
     */
    List<CarSource> getTodayNew();

    /**
     * 获取秒杀车源
     *
     * @return 车源列表
     */
    List<CarSource> getFlashSale();

    /**
     * 获取新能源车源
     *
     * @return 车源列表
     */
    List<CarSource> getNewEnergy();

    /**
     * 根据微店ID获取车源列表
     *
     * @param shopId 微店ID
     * @return 车源列表
     */
    List<CarSource> getByShopId(Long shopId);
}
