package com.car.base.service.impl.logistics;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.car.base.entity.logistics.LogisticsTruck;
import com.car.base.mapper.logistics.LogisticsTruckMapper;
import com.car.base.service.logistics.LogisticsTruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 物流板车服务实现类
 *
 * @author system
 * @date 2026-01-16
 */
@Service
public class LogisticsTruckServiceImpl implements LogisticsTruckService {

    /**
     * 物流板车 Mapper
     */
    @Autowired
    private LogisticsTruckMapper logisticsTruckMapper;

    /**
     * 分页查询物流板车列表
     */
    @Override
    public List<LogisticsTruck> listTrucks(String fromCity, String toCity, int pageNum, int pageSize) {
        // 构建查询条件
        QueryWrapper<LogisticsTruck> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1);

        // 出发城市筛选
        if (StringUtils.hasText(fromCity)) {
            queryWrapper.eq("from_city", fromCity);
        }

        // 目的城市筛选
        if (StringUtils.hasText(toCity)) {
            queryWrapper.eq("to_city", toCity);
        }

        // 按出发日期排序
        queryWrapper.orderByAsc("departure_date");

        // 分页查询
        Page<LogisticsTruck> page = new Page<>(pageNum, pageSize);
        return logisticsTruckMapper.selectPage(page, queryWrapper).getRecords();
    }

    /**
     * 根据ID获取物流详情
     */
    @Override
    public LogisticsTruck getById(Long tid) {
        return logisticsTruckMapper.selectById(tid);
    }

    /**
     * 发布物流信息
     */
    @Override
    @Transactional
    public LogisticsTruck publish(LogisticsTruck truck) {
        // 设置默认值
        truck.setStatus(1);
        truck.setCreateDate(LocalDateTime.now());
        truck.setUpdateDate(LocalDateTime.now());

        // 生成板车编号
        truck.setTruckNo(generateTruckNo());

        // 插入数据库
        logisticsTruckMapper.insert(truck);
        return truck;
    }

    /**
     * 更新物流信息
     */
    @Override
    @Transactional
    public LogisticsTruck update(LogisticsTruck truck) {
        truck.setUpdateDate(LocalDateTime.now());
        logisticsTruckMapper.updateById(truck);
        return truck;
    }

    /**
     * 获取有剩余位置的物流板车
     */
    @Override
    public List<LogisticsTruck> getAvailable() {
        return logisticsTruckMapper.findAvailable();
    }

    /**
     * 根据日期范围查询物流板车
     */
    @Override
    public List<LogisticsTruck> getByDateRange(LocalDate startDate, LocalDate endDate) {
        return logisticsTruckMapper.findByDateRange(startDate, endDate);
    }

    /**
     * 生成板车编号
     * 格式: TK + 时间戳 + 4位随机数
     */
    private String generateTruckNo() {
        long timestamp = System.currentTimeMillis();
        int random = (int) (Math.random() * 9000) + 1000;
        return "TK" + timestamp + random;
    }
}
