package com.car.base.service.impl.purchase;

import com.car.base.entity.purchase.CarPurchaseDemandDetail;
import com.car.base.mapper.purchase.CarPurchaseDemandDetailMapper;
import com.car.base.service.purchase.CarPurchaseDemandDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 求购车型明细 Service 实现类
 * 负责事务控制
 * 
 * @author system
 * @date 2026-01-25
 */
@Service
public class CarPurchaseDemandDetailServiceImpl implements CarPurchaseDemandDetailService {

    @Autowired
    private CarPurchaseDemandDetailMapper carPurchaseDemandDetailMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(CarPurchaseDemandDetail entity) {
        // 保存车型明细
        return carPurchaseDemandDetailMapper.insert(entity) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean batchSave(List<CarPurchaseDemandDetail> list) {
        // 批量保存车型明细
        if (list == null || list.isEmpty()) {
            return true;
        }
        return carPurchaseDemandDetailMapper.batchInsert(list) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CarPurchaseDemandDetail entity) {
        // 更新车型明细
        return carPurchaseDemandDetailMapper.update(entity) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Long tid) {
        // 删除车型明细
        return carPurchaseDemandDetailMapper.deleteById(tid) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteByDemandId(Long demandId) {
        // 根据求购信息ID删除所有明细
        carPurchaseDemandDetailMapper.deleteByDemandId(demandId);
        return true;
    }

    @Override
    public CarPurchaseDemandDetail getById(Long tid) {
        // 根据ID查询
        return carPurchaseDemandDetailMapper.selectById(tid);
    }

    @Override
    public List<CarPurchaseDemandDetail> getByDemandId(Long demandId) {
        // 根据求购信息ID查询明细列表
        return carPurchaseDemandDetailMapper.selectByDemandId(demandId);
    }
}
