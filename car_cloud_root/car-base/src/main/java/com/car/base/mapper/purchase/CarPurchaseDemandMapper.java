package com.car.base.mapper.purchase;

import com.car.base.entity.purchase.CarPurchaseDemand;
import com.car.base.entity.purchase.vo.CarPurchaseDemandVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 求购信息 Mapper 接口
 * 
 * @author system
 * @date 2026-01-25
 */
@Mapper
public interface CarPurchaseDemandMapper {

    /**
     * 新增求购信息
     * 
     * @param entity 实体对象
     * @return 影响行数
     */
    int insert(CarPurchaseDemand entity);

    /**
     * 根据ID更新求购信息
     * 
     * @param entity 实体对象
     * @return 影响行数
     */
    int update(CarPurchaseDemand entity);

    /**
     * 根据ID删除（逻辑删除，更新status为0）
     * 
     * @param tid 主键ID
     * @return 影响行数
     */
    int deleteById(@Param("tid") Long tid);

    /**
     * 根据ID查询
     * 
     * @param tid 主键ID
     * @return 实体对象
     */
    CarPurchaseDemand selectById(@Param("tid") Long tid);

    /**
     * 查询列表
     * 
     * @param entity 查询条件
     * @return 结果列表
     */
    List<CarPurchaseDemand> selectList(CarPurchaseDemand entity);

    /**
     * 查询 VO 列表（包含用户信息）
     * 
     * @param entity 查询条件
     * @return VO 列表
     */
    List<CarPurchaseDemandVO> selectVoList(CarPurchaseDemand entity);

    /**
     * 查询用户的求购列表
     * 
     * @param userId 用户ID
     * @return 结果列表
     */
    List<CarPurchaseDemand> selectByUserId(@Param("userId") Long userId);

    /**
     * 增加浏览次数
     * 
     * @param tid 主键ID
     * @return 影响行数
     */
    int incrementViewCount(@Param("tid") Long tid);

    /**
     * 增加评论数量
     * 
     * @param tid   主键ID
     * @param count 增加数量（可为负数）
     * @return 影响行数
     */
    int incrementCommentCount(@Param("tid") Long tid, @Param("count") int count);
}
