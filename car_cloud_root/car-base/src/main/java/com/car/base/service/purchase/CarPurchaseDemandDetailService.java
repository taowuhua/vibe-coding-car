package com.car.base.service.purchase;

import com.car.base.entity.purchase.CarPurchaseDemandDetail;

import java.util.List;

/**
 * 求购车型明细 Service 接口
 * 负责事务控制
 * 
 * @author system
 * @date 2026-01-25
 */
public interface CarPurchaseDemandDetailService {

    /**
     * 保存车型明细
     * 
     * @param entity 实体对象
     * @return 是否成功
     */
    boolean save(CarPurchaseDemandDetail entity);

    /**
     * 批量保存车型明细
     * 
     * @param list 实体列表
     * @return 是否成功
     */
    boolean batchSave(List<CarPurchaseDemandDetail> list);

    /**
     * 更新车型明细
     * 
     * @param entity 实体对象
     * @return 是否成功
     */
    boolean update(CarPurchaseDemandDetail entity);

    /**
     * 删除车型明细
     * 
     * @param tid 主键ID
     * @return 是否成功
     */
    boolean delete(Long tid);

    /**
     * 根据求购信息ID删除所有明细
     * 
     * @param demandId 求购信息ID
     * @return 是否成功
     */
    boolean deleteByDemandId(Long demandId);

    /**
     * 根据ID获取详情
     * 
     * @param tid 主键ID
     * @return 实体对象
     */
    CarPurchaseDemandDetail getById(Long tid);

    /**
     * 根据求购信息ID查询明细列表
     * 
     * @param demandId 求购信息ID
     * @return 明细列表
     */
    List<CarPurchaseDemandDetail> getByDemandId(Long demandId);
}
