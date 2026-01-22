package com.car.base.service.impl.purchase;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.car.base.entity.purchase.PurchaseDemand;
import com.car.base.mapper.purchase.PurchaseDemandMapper;
import com.car.base.service.purchase.PurchaseDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 求购需求服务实现类
 *
 * @author system
 * @date 2026-01-16
 */
@Service
public class PurchaseDemandServiceImpl implements PurchaseDemandService {

    /**
     * 求购需求 Mapper
     */
    @Autowired
    private PurchaseDemandMapper purchaseDemandMapper;

    /**
     * 分页查询求购大厅列表
     */
    @Override
    public List<PurchaseDemand> listDemands(int pageNum, int pageSize) {
        Page<PurchaseDemand> page = new Page<>(pageNum, pageSize);
        // 查询进行中的求购需求
        return purchaseDemandMapper.findActive();
    }

    /**
     * 根据用户ID获取求购需求
     */
    @Override
    public List<PurchaseDemand> getByUserId(Long userId) {
        return purchaseDemandMapper.findByUserId(userId);
    }

    /**
     * 根据ID获取求购详情
     */
    @Override
    public PurchaseDemand getById(Long tid) {
        return purchaseDemandMapper.selectById(tid);
    }

    /**
     * 发布求购需求
     */
    @Override
    @Transactional
    public PurchaseDemand publish(PurchaseDemand demand) {
        // 设置默认值
        demand.setStatus(1);
        demand.setCreateDate(LocalDateTime.now());
        demand.setUpdateDate(LocalDateTime.now());

        // 生成求购编号
        demand.setDemandNo(generateDemandNo());

        // 插入数据库
        purchaseDemandMapper.insert(demand);
        return demand;
    }

    /**
     * 更新求购需求
     */
    @Override
    @Transactional
    public PurchaseDemand update(PurchaseDemand demand) {
        demand.setUpdateDate(LocalDateTime.now());
        purchaseDemandMapper.updateById(demand);
        return demand;
    }

    /**
     * 关闭求购需求
     */
    @Override
    @Transactional
    public boolean close(Long tid) {
        PurchaseDemand demand = new PurchaseDemand();
        demand.setTid(tid);
        demand.setStatus(0);
        demand.setUpdateDate(LocalDateTime.now());
        return purchaseDemandMapper.updateById(demand) > 0;
    }

    /**
     * 生成求购编号
     * 格式: QG + 时间戳 + 4位随机数
     */
    private String generateDemandNo() {
        long timestamp = System.currentTimeMillis();
        int random = (int) (Math.random() * 9000) + 1000;
        return "QG" + timestamp + random;
    }
}
