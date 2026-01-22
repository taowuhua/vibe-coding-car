package com.car.base.service.purchase;

import com.car.base.entity.purchase.PurchaseDemand;

import java.util.List;

/**
 * 求购需求服务接口
 * 定义求购相关的基础业务方法
 *
 * @author system
 * @date 2026-01-16
 */
public interface PurchaseDemandService {

    /**
     * 分页查询求购大厅列表
     *
     * @param pageNum  页码
     * @param pageSize 每页数量
     * @return 求购需求列表
     */
    List<PurchaseDemand> listDemands(int pageNum, int pageSize);

    /**
     * 根据用户ID获取求购需求
     *
     * @param userId 用户ID
     * @return 求购需求列表
     */
    List<PurchaseDemand> getByUserId(Long userId);

    /**
     * 根据ID获取求购详情
     *
     * @param tid 求购ID
     * @return 求购需求信息
     */
    PurchaseDemand getById(Long tid);

    /**
     * 发布求购需求
     *
     * @param demand 求购需求信息
     * @return 发布后的求购需求
     */
    PurchaseDemand publish(PurchaseDemand demand);

    /**
     * 更新求购需求
     *
     * @param demand 求购需求信息
     * @return 更新后的求购需求
     */
    PurchaseDemand update(PurchaseDemand demand);

    /**
     * 关闭求购需求
     *
     * @param tid 求购ID
     * @return 是否成功
     */
    boolean close(Long tid);
}
