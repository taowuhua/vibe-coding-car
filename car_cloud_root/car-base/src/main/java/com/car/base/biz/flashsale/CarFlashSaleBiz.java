package com.car.base.biz.flashsale;

import com.car.base.entity.flashsale.CarFlashSale;

import java.util.List;

/**
 * 秒杀活动 Biz 业务逻辑接口
 */
public interface CarFlashSaleBiz {

    /**
     * 创建秒杀活动
     * 
     * @param carFlashSale 实体
     * @return 结果
     */
    boolean createFlashSale(CarFlashSale carFlashSale);

    /**
     * 更新秒杀活动
     * 
     * @param carFlashSale 实体
     * @return 结果
     */
    boolean modifyFlashSale(CarFlashSale carFlashSale);

    /**
     * 获取详情
     * 
     * @param tid ID
     * @return 实体
     */
    CarFlashSale getDetail(Long tid);

    /**
     * 查询列表
     * 
     * @param carFlashSale 查询条件
     * @return 列表
     */
    List<CarFlashSale> queryList(CarFlashSale carFlashSale);

    /**
     * 查询VO列表
     *
     * @param carFlashSale 查询条件
     * @return VO列表
     */
    List<com.car.base.entity.flashsale.vo.CarFlashSaleVO> queryVoList(CarFlashSale carFlashSale);
}
