package com.car.base.service.flashsale.impl;

import com.car.base.entity.flashsale.CarFlashSale;
import com.car.base.mapper.flashsale.CarFlashSaleMapper;
import com.car.base.service.flashsale.CarFlashSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 秒杀活动 Service 实现类
 */
@Service
public class CarFlashSaleServiceImpl implements CarFlashSaleService {

    @Autowired
    private CarFlashSaleMapper carFlashSaleMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(CarFlashSale carFlashSale) {
        return carFlashSaleMapper.insert(carFlashSale) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CarFlashSale carFlashSale) {
        return carFlashSaleMapper.update(carFlashSale) > 0;
    }

    @Override
    public CarFlashSale getById(Long tid) {
        return carFlashSaleMapper.selectById(tid);
    }

    @Override
    public List<CarFlashSale> getList(CarFlashSale carFlashSale) {
        return carFlashSaleMapper.selectList(carFlashSale);
    }

    @Override
    public List<com.car.base.entity.flashsale.vo.CarFlashSaleVO> getVoList(CarFlashSale carFlashSale) {
        return carFlashSaleMapper.selectVoList(carFlashSale);
    }
}
