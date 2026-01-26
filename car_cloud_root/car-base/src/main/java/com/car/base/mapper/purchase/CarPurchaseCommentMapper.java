package com.car.base.mapper.purchase;

import com.car.base.entity.purchase.CarPurchaseComment;
import com.car.base.entity.purchase.vo.CarPurchaseCommentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 求购评论 Mapper 接口
 * 
 * @author system
 * @date 2026-01-25
 */
@Mapper
public interface CarPurchaseCommentMapper {

    /**
     * 新增评论
     * 
     * @param entity 实体对象
     * @return 影响行数
     */
    int insert(CarPurchaseComment entity);

    /**
     * 根据ID更新
     * 
     * @param entity 实体对象
     * @return 影响行数
     */
    int update(CarPurchaseComment entity);

    /**
     * 根据ID删除（逻辑删除）
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
    CarPurchaseComment selectById(@Param("tid") Long tid);

    /**
     * 查询列表
     * 
     * @param entity 查询条件
     * @return 结果列表
     */
    List<CarPurchaseComment> selectList(CarPurchaseComment entity);

    /**
     * 查询 VO 列表（包含用户信息）
     * 
     * @param demandId 求购信息ID
     * @return VO 列表
     */
    List<CarPurchaseCommentVO> selectVoListByDemandId(@Param("demandId") Long demandId);

    /**
     * 统计求购信息的评论数量
     * 
     * @param demandId 求购信息ID
     * @return 评论数量
     */
    int countByDemandId(@Param("demandId") Long demandId);
}
