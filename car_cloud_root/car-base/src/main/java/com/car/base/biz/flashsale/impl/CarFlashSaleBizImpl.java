package com.car.base.biz.flashsale.impl;

import com.car.base.biz.flashsale.CarFlashSaleBiz;
import com.car.base.entity.flashsale.CarFlashSale;
import com.car.base.service.flashsale.CarFlashSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 秒杀活动 Biz 业务逻辑实现类
 */
@Service
public class CarFlashSaleBizImpl implements CarFlashSaleBiz {

    @Autowired
    private CarFlashSaleService carFlashSaleService;

    @Override
    public boolean createFlashSale(CarFlashSale carFlashSale) {
        // 业务逻辑: 设置初始状态和时间
        if (carFlashSale.getStatus() == null) {
            carFlashSale.setStatus(1); // 默认启用
        }
        if (carFlashSale.getCreateDate() == null) {
            carFlashSale.setCreateDate(new Date());
        }
        return carFlashSaleService.save(carFlashSale);
    }

    @Override
    public boolean modifyFlashSale(CarFlashSale carFlashSale) {
        // 业务逻辑: 设置更新时间
        carFlashSale.setUpdateDate(new Date());
        return carFlashSaleService.update(carFlashSale);
    }

    @Override
    public CarFlashSale getDetail(Long tid) {
        return carFlashSaleService.getById(tid);
    }

    @Override
    public List<CarFlashSale> queryList(CarFlashSale carFlashSale) {
        return carFlashSaleService.getList(carFlashSale);
    }

    @Override
    public List<com.car.base.entity.flashsale.vo.CarFlashSaleVO> queryVoList(CarFlashSale carFlashSale) {
        return carFlashSaleService.getVoList(carFlashSale);
    }
}
