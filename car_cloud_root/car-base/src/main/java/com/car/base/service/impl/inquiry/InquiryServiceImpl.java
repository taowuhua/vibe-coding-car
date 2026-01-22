package com.car.base.service.impl.inquiry;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.car.base.entity.inquiry.Inquiry;
import com.car.base.mapper.inquiry.InquiryMapper;
import com.car.base.service.inquiry.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 询价记录服务实现类
 *
 * @author system
 * @date 2026-01-16
 */
@Service
public class InquiryServiceImpl implements InquiryService {

    /**
     * 询价记录 Mapper
     */
    @Autowired
    private InquiryMapper inquiryMapper;

    /**
     * 获取询价列表（车商视角）
     * 需要根据微店ID关联查询该店铺所有车源的询价
     */
    @Override
    public List<Inquiry> listInquiries(Long shopId, int pageNum, int pageSize) {
        // 这里简化处理，实际应该关联 car_source 表查询
        Page<Inquiry> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Inquiry> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_date");
        return inquiryMapper.selectPage(page, queryWrapper).getRecords();
    }

    /**
     * 获取我的询价记录（用户视角）
     */
    @Override
    public List<Inquiry> getByUserId(Long userId) {
        return inquiryMapper.findByUserId(userId);
    }

    /**
     * 提交询价
     */
    @Override
    @Transactional
    public Inquiry submit(Inquiry inquiry) {
        // 设置默认值
        inquiry.setStatus(0);
        inquiry.setCreateDate(LocalDateTime.now());
        inquiry.setUpdateDate(LocalDateTime.now());

        // 生成询价编号
        inquiry.setInquiryNo(generateInquiryNo());

        // 插入数据库
        inquiryMapper.insert(inquiry);
        return inquiry;
    }

    /**
     * 回复询价
     */
    @Override
    @Transactional
    public Inquiry reply(Inquiry inquiry) {
        // 设置回复状态和时间
        inquiry.setStatus(1);
        inquiry.setReplyTime(LocalDateTime.now());
        inquiry.setUpdateDate(LocalDateTime.now());

        // 更新数据库
        inquiryMapper.updateById(inquiry);
        return inquiry;
    }

    /**
     * 根据车源ID获取询价记录
     */
    @Override
    public List<Inquiry> getByCarId(Long carId) {
        return inquiryMapper.findByCarId(carId);
    }

    /**
     * 生成询价编号
     * 格式: INQ + 时间戳 + 4位随机数
     */
    private String generateInquiryNo() {
        long timestamp = System.currentTimeMillis();
        int random = (int) (Math.random() * 9000) + 1000;
        return "INQ" + timestamp + random;
    }
}
