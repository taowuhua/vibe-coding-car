package com.car.base.service.car;

import com.car.base.entity.car.CarBrand;

import java.util.List;

/**
 * 品牌字典服务接口
 * 定义品牌相关的基础业务方法
 *
 * @author system
 * @date 2026-01-16
 */
public interface CarBrandService {

    /**
     * 获取所有启用的品牌列表
     *
     * @return 品牌列表
     */
    List<CarBrand> getAllBrands();

    /**
     * 根据首字母查询品牌
     *
     * @param initial 首字母
     * @return 品牌列表
     */
    List<CarBrand> getByInitial(String initial);

    /**
     * 根据关键词搜索品牌
     *
     * @param keyword 关键词
     * @return 品牌列表
     */
    List<CarBrand> search(String keyword);
}
