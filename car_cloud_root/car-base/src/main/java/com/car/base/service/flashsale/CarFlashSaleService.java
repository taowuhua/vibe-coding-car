package com.car.base.service.flashsale;

import com.car.base.entity.flashsale.CarFlashSale;

import java.util.List;

/**
 * 秒杀活动 Service 接口
 * 负责事务处理
 */
public interface CarFlashSaleService {

    /**
     * 新增秒杀活动
     * 
     * @param carFlashSale 实体
     * @return 是否成功
     */
    boolean save(CarFlashSale carFlashSale);

    /**
     * 更新秒杀活动
     * 
     * @param carFlashSale 实体
     * @return 是否成功
     */
    boolean update(CarFlashSale carFlashSale);

    /**
     * 根据ID获取详情
     * 
     * @param tid 主键
     * @return 实体
     */
    CarFlashSale getById(Long tid);

    /**
     * 获取列表
     * 
     * @param carFlashSale 查询条件
     * @return 列表
     */
    List<CarFlashSale> getList(CarFlashSale carFlashSale);

    /**
     * 获取VO列表 (包含车源信息)
     *
     * @param carFlashSale 查询条件
     * @return VO列表
     */
    List<com.car.base.entity.flashsale.vo.CarFlashSaleVO> getVoList(CarFlashSale carFlashSale);
}
