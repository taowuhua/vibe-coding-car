package com.car.base.service.purchase;

import com.car.base.entity.purchase.CarPurchaseDemand;
import com.car.base.entity.purchase.vo.CarPurchaseDemandVO;

import java.util.List;

/**
 * 求购信息 Service 接口
 * 负责事务控制
 * 
 * @author system
 * @date 2026-01-25
 */
public interface CarPurchaseDemandService {

    /**
     * 保存求购信息
     * 
     * @param entity 实体对象
     * @return 是否成功
     */
    boolean save(CarPurchaseDemand entity);

    /**
     * 更新求购信息
     * 
     * @param entity 实体对象
     * @return 是否成功
     */
    boolean update(CarPurchaseDemand entity);

    /**
     * 删除求购信息（逻辑删除）
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
    CarPurchaseDemand getById(Long tid);

    /**
     * 查询列表
     * 
     * @param entity 查询条件
     * @return 结果列表
     */
    List<CarPurchaseDemand> getList(CarPurchaseDemand entity);

    /**
     * 查询 VO 列表
     * 
     * @param entity 查询条件
     * @return VO 列表
     */
    List<CarPurchaseDemandVO> getVoList(CarPurchaseDemand entity);

    /**
     * 查询用户的求购列表
     * 
     * @param userId 用户ID
     * @return 结果列表
     */
    List<CarPurchaseDemand> getByUserId(Long userId);

    /**
     * 增加浏览次数
     * 
     * @param tid 主键ID
     */
    void incrementViewCount(Long tid);

    /**
     * 增加评论数量
     * 
     * @param tid   主键ID
     * @param count 增加数量
     */
    void incrementCommentCount(Long tid, int count);
}
