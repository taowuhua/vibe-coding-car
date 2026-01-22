package com.car.base.mapper.inquiry;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.car.base.entity.inquiry.Inquiry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 询价记录 Mapper 接口
 * 继承 MyBatis-Plus 的 BaseMapper，提供基础 CRUD 功能
 *
 * @author system
 * @date 2026-01-16
 */
@Mapper
public interface InquiryMapper extends BaseMapper<Inquiry> {

    /**
     * 根据用户ID查询询价记录
     *
     * @param userId 用户ID
     * @return 询价记录列表
     */
    List<Inquiry> findByUserId(@Param("userId") Long userId);

    /**
     * 根据车源ID查询询价记录
     *
     * @param carId 车源ID
     * @return 询价记录列表
     */
    List<Inquiry> findByCarId(@Param("carId") Long carId);

    /**
     * 查询待回复的询价记录
     *
     * @return 询价记录列表
     */
    List<Inquiry> findPending();

    /**
     * 统计车源的询价数量
     *
     * @param carId 车源ID
     * @return 询价数量
     */
    int countByCarId(@Param("carId") Long carId);
}
