package com.car.base.service.inquiry;

import com.car.base.entity.inquiry.Inquiry;

import java.util.List;

/**
 * 询价记录服务接口
 * 定义询价相关的基础业务方法
 *
 * @author system
 * @date 2026-01-16
 */
public interface InquiryService {

    /**
     * 获取询价列表（车商视角）
     *
     * @param shopId   微店ID
     * @param pageNum  页码
     * @param pageSize 每页数量
     * @return 询价记录列表
     */
    List<Inquiry> listInquiries(Long shopId, int pageNum, int pageSize);

    /**
     * 获取我的询价记录（用户视角）
     *
     * @param userId 用户ID
     * @return 询价记录列表
     */
    List<Inquiry> getByUserId(Long userId);

    /**
     * 提交询价
     *
     * @param inquiry 询价信息
     * @return 提交后的询价记录
     */
    Inquiry submit(Inquiry inquiry);

    /**
     * 回复询价
     *
     * @param inquiry 询价信息（包含回复内容）
     * @return 回复后的询价记录
     */
    Inquiry reply(Inquiry inquiry);

    /**
     * 根据车源ID获取询价记录
     *
     * @param carId 车源ID
     * @return 询价记录列表
     */
    List<Inquiry> getByCarId(Long carId);
}
