package com.car.base.service.impl.car;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.car.base.entity.car.CarSource;
import com.car.base.mapper.car.CarSourceMapper;
import com.car.base.service.car.CarSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 车源信息服务实现类
 *
 * @author system
 * @date 2026-01-16
 */
@Service
public class CarSourceServiceImpl implements CarSourceService {

    /**
     * 车源信息 Mapper
     */
    @Autowired
    private CarSourceMapper carSourceMapper;

    /**
     * 分页查询车源列表
     */
    @Override
    public List<CarSource> listCars(String brand, String city, BigDecimal minPrice,
            BigDecimal maxPrice, int pageNum, int pageSize) {
        // 构建查询条件
        QueryWrapper<CarSource> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1);

        // 品牌筛选
        if (StringUtils.hasText(brand)) {
            queryWrapper.eq("brand", brand);
        }

        // 城市筛选
        if (StringUtils.hasText(city)) {
            queryWrapper.eq("city", city);
        }

        // 价格范围筛选
        if (minPrice != null) {
            queryWrapper.ge("price", minPrice);
        }
        if (maxPrice != null) {
            queryWrapper.le("price", maxPrice);
        }

        // 按创建时间倒序
        queryWrapper.orderByDesc("create_date");

        // 分页查询
        Page<CarSource> page = new Page<>(pageNum, pageSize);
        return carSourceMapper.selectPage(page, queryWrapper).getRecords();
    }

    /**
     * 根据ID获取车源详情
     */
    @Override
    public CarSource getById(Long tid) {
        return carSourceMapper.selectById(tid);
    }

    /**
     * 发布车源
     */
    @Override
    @Transactional
    public CarSource publish(CarSource carSource) {
        // 设置默认值
        carSource.setStatus(1);
        carSource.setIsNewToday(1);
        carSource.setCreateDate(LocalDateTime.now());
        carSource.setUpdateDate(LocalDateTime.now());

        // 生成车辆编号
        carSource.setCarNo(generateCarNo());

        // 插入数据库
        carSourceMapper.insert(carSource);
        return carSource;
    }

    /**
     * 更新车源信息
     */
    @Override
    @Transactional
    public CarSource update(CarSource carSource) {
        carSource.setUpdateDate(LocalDateTime.now());
        carSourceMapper.updateById(carSource);
        return carSource;
    }

    /**
     * 删除车源（逻辑删除）
     */
    @Override
    @Transactional
    public boolean delete(Long tid) {
        CarSource carSource = new CarSource();
        carSource.setTid(tid);
        carSource.setStatus(0);
        carSource.setUpdateDate(LocalDateTime.now());
        return carSourceMapper.updateById(carSource) > 0;
    }

    /**
     * 获取今日上新车源
     */
    @Override
    public List<CarSource> getTodayNew() {
        return carSourceMapper.findTodayNew();
    }

    /**
     * 获取秒杀车源
     */
    @Override
    public List<CarSource> getFlashSale() {
        return carSourceMapper.findFlashSale();
    }

    /**
     * 获取新能源车源
     */
    @Override
    public List<CarSource> getNewEnergy() {
        return carSourceMapper.findNewEnergy();
    }

    /**
     * 根据微店ID获取车源列表
     */
    @Override
    public List<CarSource> getByShopId(Long shopId) {
        return carSourceMapper.findByShopId(shopId);
    }

    /**
     * 生成车辆编号
     * 格式: CAR + 时间戳 + 4位随机数
     */
    private String generateCarNo() {
        long timestamp = System.currentTimeMillis();
        int random = (int) (Math.random() * 9000) + 1000;
        return "CAR" + timestamp + random;
    }
}
