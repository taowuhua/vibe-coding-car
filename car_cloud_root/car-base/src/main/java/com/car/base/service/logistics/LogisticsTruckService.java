package com.car.base.service.logistics;

import com.car.base.entity.logistics.LogisticsTruck;

import java.time.LocalDate;
import java.util.List;

/**
 * 物流板车服务接口
 * 定义物流相关的基础业务方法
 *
 * @author system
 * @date 2026-01-16
 */
public interface LogisticsTruckService {

    /**
     * 分页查询物流板车列表
     *
     * @param fromCity 出发城市（可选）
     * @param toCity   目的城市（可选）
     * @param pageNum  页码
     * @param pageSize 每页数量
     * @return 物流板车列表
     */
    List<LogisticsTruck> listTrucks(String fromCity, String toCity, int pageNum, int pageSize);

    /**
     * 根据ID获取物流详情
     *
     * @param tid 物流ID
     * @return 物流板车信息
     */
    LogisticsTruck getById(Long tid);

    /**
     * 发布物流信息
     *
     * @param truck 物流板车信息
     * @return 发布后的物流板车
     */
    LogisticsTruck publish(LogisticsTruck truck);

    /**
     * 更新物流信息
     *
     * @param truck 物流板车信息
     * @return 更新后的物流板车
     */
    LogisticsTruck update(LogisticsTruck truck);

    /**
     * 获取有剩余位置的物流板车
     *
     * @return 物流板车列表
     */
    List<LogisticsTruck> getAvailable();

    /**
     * 根据日期范围查询物流板车
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 物流板车列表
     */
    List<LogisticsTruck> getByDateRange(LocalDate startDate, LocalDate endDate);
}
