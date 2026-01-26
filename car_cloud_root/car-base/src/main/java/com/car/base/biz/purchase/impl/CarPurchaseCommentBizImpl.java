package com.car.base.biz.purchase.impl;

import com.car.base.biz.purchase.CarPurchaseCommentBiz;
import com.car.base.entity.purchase.CarPurchaseComment;
import com.car.base.entity.purchase.vo.CarPurchaseCommentVO;
import com.car.base.service.purchase.CarPurchaseCommentService;
import com.car.base.service.purchase.CarPurchaseDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 求购评论 Biz 实现类
 * 负责业务逻辑处理
 * 
 * @author system
 * @date 2026-01-25
 */
@Service
public class CarPurchaseCommentBizImpl implements CarPurchaseCommentBiz {

    @Autowired
    private CarPurchaseCommentService carPurchaseCommentService;

    @Autowired
    private CarPurchaseDemandService carPurchaseDemandService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addComment(CarPurchaseComment comment) {
        // 业务逻辑：设置默认值
        if (comment.getStatus() == null) {
            comment.setStatus(1); // 默认正常
        }
        if (comment.getParentId() == null) {
            comment.setParentId(0L); // 默认顶级评论
        }
        if (comment.getCreateDate() == null) {
            comment.setCreateDate(new Date());
        }

        // 保存评论
        boolean success = carPurchaseCommentService.save(comment);
        if (success) {
            // 更新求购信息的评论数量
            carPurchaseDemandService.incrementCommentCount(comment.getDemandId(), 1);
        }

        return success;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeComment(Long tid, Long userId) {
        // 查询评论信息
        CarPurchaseComment comment = carPurchaseCommentService.getById(tid);
        if (comment == null) {
            return false;
        }

        // 业务逻辑：权限校验（只能删除自己的评论）
        if (!comment.getUserId().equals(userId)) {
            return false;
        }

        // 逻辑删除评论
        boolean success = carPurchaseCommentService.delete(tid);
        if (success) {
            // 更新求购信息的评论数量
            carPurchaseDemandService.incrementCommentCount(comment.getDemandId(), -1);
        }

        return success;
    }

    @Override
    public List<CarPurchaseCommentVO> queryByDemandId(Long demandId) {
        // 查询评论 VO 列表
        List<CarPurchaseCommentVO> voList = carPurchaseCommentService.getVoListByDemandId(demandId);

        // 生成相对时间文本
        for (CarPurchaseCommentVO vo : voList) {
            vo.setCreateTimeText(formatRelativeTime(vo.getCreateDate()));
        }

        return voList;
    }

    /**
     * 格式化相对时间
     * 
     * @param date 日期
     * @return 相对时间文本（如：5分钟前）
     */
    private String formatRelativeTime(Date date) {
        if (date == null) {
            return "";
        }

        long diff = System.currentTimeMillis() - date.getTime();
        long seconds = diff / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        if (days > 30) {
            return (days / 30) + "个月前";
        } else if (days > 0) {
            return days + "天前";
        } else if (hours > 0) {
            return hours + "小时前";
        } else if (minutes > 0) {
            return minutes + "分钟前";
        } else {
            return "刚刚";
        }
    }
}
