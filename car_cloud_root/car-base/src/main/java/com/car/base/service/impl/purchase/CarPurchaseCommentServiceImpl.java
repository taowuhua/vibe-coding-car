package com.car.base.service.impl.purchase;

import com.car.base.entity.purchase.CarPurchaseComment;
import com.car.base.entity.purchase.vo.CarPurchaseCommentVO;
import com.car.base.mapper.purchase.CarPurchaseCommentMapper;
import com.car.base.service.purchase.CarPurchaseCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 求购评论 Service 实现类
 * 负责事务控制
 * 
 * @author system
 * @date 2026-01-25
 */
@Service
public class CarPurchaseCommentServiceImpl implements CarPurchaseCommentService {

    @Autowired
    private CarPurchaseCommentMapper carPurchaseCommentMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(CarPurchaseComment entity) {
        // 保存评论
        return carPurchaseCommentMapper.insert(entity) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CarPurchaseComment entity) {
        // 更新评论
        return carPurchaseCommentMapper.update(entity) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Long tid) {
        // 逻辑删除评论
        return carPurchaseCommentMapper.deleteById(tid) > 0;
    }

    @Override
    public CarPurchaseComment getById(Long tid) {
        // 根据ID查询
        return carPurchaseCommentMapper.selectById(tid);
    }

    @Override
    public List<CarPurchaseComment> getList(CarPurchaseComment entity) {
        // 查询列表
        return carPurchaseCommentMapper.selectList(entity);
    }

    @Override
    public List<CarPurchaseCommentVO> getVoListByDemandId(Long demandId) {
        // 查询评论 VO 列表
        return carPurchaseCommentMapper.selectVoListByDemandId(demandId);
    }

    @Override
    public int countByDemandId(Long demandId) {
        // 统计评论数量
        return carPurchaseCommentMapper.countByDemandId(demandId);
    }
}
