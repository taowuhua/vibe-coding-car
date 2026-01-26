package com.car.base.service.purchase;

import com.car.base.entity.purchase.CarPurchaseComment;
import com.car.base.entity.purchase.vo.CarPurchaseCommentVO;

import java.util.List;

/**
 * 求购评论 Service 接口
 * 负责事务控制
 * 
 * @author system
 * @date 2026-01-25
 */
public interface CarPurchaseCommentService {

    /**
     * 保存评论
     * 
     * @param entity 实体对象
     * @return 是否成功
     */
    boolean save(CarPurchaseComment entity);

    /**
     * 更新评论
     * 
     * @param entity 实体对象
     * @return 是否成功
     */
    boolean update(CarPurchaseComment entity);

    /**
     * 删除评论（逻辑删除）
     * 
     * @param tid 主键ID
     * @return 是否成功
     */
    boolean delete(Long tid);

    /**
     * 根据ID获取详情
     * 
     * @param tid 主键ID
     * @return 实体对象
     */
    CarPurchaseComment getById(Long tid);

    /**
     * 查询列表
     * 
     * @param entity 查询条件
     * @return 结果列表
     */
    List<CarPurchaseComment> getList(CarPurchaseComment entity);

    /**
     * 查询某求购信息的评论 VO 列表
     * 
     * @param demandId 求购信息ID
     * @return VO 列表
     */
    List<CarPurchaseCommentVO> getVoListByDemandId(Long demandId);

    /**
     * 统计评论数量
     * 
     * @param demandId 求购信息ID
     * @return 评论数量
     */
    int countByDemandId(Long demandId);
}
