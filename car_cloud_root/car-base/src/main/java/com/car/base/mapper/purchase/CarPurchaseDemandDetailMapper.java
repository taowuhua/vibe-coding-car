package com.car.base.mapper.purchase;

import com.car.base.entity.purchase.CarPurchaseDemandDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 求购车型明细 Mapper 接口
 * 
 * @author system
 * @date 2026-01-25
 */
@Mapper
public interface CarPurchaseDemandDetailMapper {

    /**
     * 新增车型明细
     * 
     * @param entity 实体对象
     * @return 影响行数
     */
    int insert(CarPurchaseDemandDetail entity);

    /**
     * 批量新增车型明细
     * 
     * @param list 实体列表
     * @return 影响行数
     */
    int batchInsert(@Param("list") List<CarPurchaseDemandDetail> list);

    /**
     * 根据ID更新
     * 
     * @param entity 实体对象
     * @return 影响行数
     */
    int update(CarPurchaseDemandDetail entity);

    /**
     * 根据ID删除
     * 
     * @param tid 主键ID
     * @return 影响行数
     */
    int deleteById(@Param("tid") Long tid);

    /**
     * 根据求购信息ID删除所有明细
     * 
     * @param demandId 求购信息ID
     * @return 影响行数
     */
    int deleteByDemandId(@Param("demandId") Long demandId);

    /**
     * 根据ID查询
     * 
     * @param tid 主键ID
     * @return 实体对象
     */
    CarPurchaseDemandDetail selectById(@Param("tid") Long tid);

    /**
     * 根据求购信息ID查询明细列表
     * 
     * @param demandId 求购信息ID
     * @return 明细列表
     */
    List<CarPurchaseDemandDetail> selectByDemandId(@Param("demandId") Long demandId);
}
