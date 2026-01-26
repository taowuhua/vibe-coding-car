package com.car.base.service.impl.purchase;

import com.car.base.entity.purchase.CarPurchaseDemand;
import com.car.base.entity.purchase.vo.CarPurchaseDemandVO;
import com.car.base.mapper.purchase.CarPurchaseDemandMapper;
import com.car.base.service.purchase.CarPurchaseDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 求购信息 Service 实现类
 * 负责事务控制
 * 
 * @author system
 * @date 2026-01-25
 */
@Service
public class CarPurchaseDemandServiceImpl implements CarPurchaseDemandService {

    @Autowired
    private CarPurchaseDemandMapper carPurchaseDemandMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(CarPurchaseDemand entity) {
        // 保存求购信息
        return carPurchaseDemandMapper.insert(entity) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CarPurchaseDemand entity) {
        // 更新求购信息
        return carPurchaseDemandMapper.update(entity) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Long tid) {
        // 逻辑删除求购信息
        return carPurchaseDemandMapper.deleteById(tid) > 0;
    }

    @Override
    public CarPurchaseDemand getById(Long tid) {
        // 根据ID查询
        return carPurchaseDemandMapper.selectById(tid);
    }

    @Override
    public List<CarPurchaseDemand> getList(CarPurchaseDemand entity) {
        // 查询列表
        return carPurchaseDemandMapper.selectList(entity);
    }

    @Override
    public List<CarPurchaseDemandVO> getVoList(CarPurchaseDemand entity) {
        // 查询 VO 列表
        return carPurchaseDemandMapper.selectVoList(entity);
    }

    @Override
    public List<CarPurchaseDemand> getByUserId(Long userId) {
        // 查询用户的求购列表
        return carPurchaseDemandMapper.selectByUserId(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void incrementViewCount(Long tid) {
        // 增加浏览次数
        carPurchaseDemandMapper.incrementViewCount(tid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void incrementCommentCount(Long tid, int count) {
        // 增加评论数量
        carPurchaseDemandMapper.incrementCommentCount(tid, count);
    }
}
