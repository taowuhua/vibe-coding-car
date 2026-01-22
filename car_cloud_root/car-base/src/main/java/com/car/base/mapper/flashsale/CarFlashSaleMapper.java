package com.car.base.mapper.flashsale;

import com.car.base.entity.flashsale.CarFlashSale;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 秒杀活动 Mapper 接口
 */
@Mapper
public interface CarFlashSaleMapper {

    /**
     * 新增秒杀活动
     * 
     * @param carFlashSale 实体对象
     * @return 影响行数
     */
    int insert(CarFlashSale carFlashSale);

    /**
     * 根据ID更新秒杀活动
     * 
     * @param carFlashSale 实体对象
     * @return 影响行数
     */
    int update(CarFlashSale carFlashSale);

    /**
     * 根据ID查询
     * 
     * @param tid 主键ID
     * @return 实体对象
     */
    CarFlashSale selectById(@Param("tid") Long tid);

    /**
     * 查询列表
     * 
     * @param carFlashSale 查询条件
     * @return 结果列表
     */
    List<CarFlashSale> selectList(CarFlashSale carFlashSale);

    /**
     * 查询VO列表 (包含车源信息)
     *
     * @param carFlashSale 查询条件
     * @return VO列表
     */
    List<com.car.base.entity.flashsale.vo.CarFlashSaleVO> selectVoList(CarFlashSale carFlashSale);
}
