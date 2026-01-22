package com.car.base.mapper.car;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.car.base.entity.car.CarBrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 品牌字典 Mapper 接口
 * 继承 MyBatis-Plus 的 BaseMapper，提供基础 CRUD 功能
 *
 * @author system
 * @date 2026-01-16
 */
@Mapper
public interface CarBrandMapper extends BaseMapper<CarBrand> {

    /**
     * 根据首字母查询品牌
     *
     * @param initial 首字母
     * @return 品牌列表
     */
    List<CarBrand> findByInitial(@Param("initial") String initial);

    /**
     * 查询所有启用的品牌（按排序）
     *
     * @return 品牌列表
     */
    List<CarBrand> findAllActive();

    /**
     * 根据品牌名称模糊查询
     *
     * @param keyword 关键词
     * @return 品牌列表
     */
    List<CarBrand> searchByName(@Param("keyword") String keyword);
}
