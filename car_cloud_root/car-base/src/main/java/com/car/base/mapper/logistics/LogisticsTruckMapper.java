package com.car.base.mapper.logistics;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.car.base.entity.logistics.LogisticsTruck;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * 物流板车 Mapper 接口
 * 继承 MyBatis-Plus 的 BaseMapper，提供基础 CRUD 功能
 *
 * @author system
 * @date 2026-01-16
 */
@Mapper
public interface LogisticsTruckMapper extends BaseMapper<LogisticsTruck> {

    /**
     * 根据出发城市查询物流板车
     *
     * @param fromCity 出发城市
     * @return 物流板车列表
     */
    List<LogisticsTruck> findByFromCity(@Param("fromCity") String fromCity);

    /**
     * 根据目的城市查询物流板车
     *
     * @param toCity 目的城市
     * @return 物流板车列表
     */
    List<LogisticsTruck> findByToCity(@Param("toCity") String toCity);

    /**
     * 根据出发日期范围查询物流板车
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 物流板车列表
     */
    List<LogisticsTruck> findByDateRange(@Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

    /**
     * 查询有剩余位置的物流板车
     *
     * @return 物流板车列表
     */
    List<LogisticsTruck> findAvailable();
}
