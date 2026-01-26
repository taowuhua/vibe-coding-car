package com.car.base.biz.purchase;

import com.car.base.entity.purchase.CarPurchaseComment;
import com.car.base.entity.purchase.vo.CarPurchaseCommentVO;

import java.util.List;

/**
 * 求购评论 Biz 接口
 * 负责业务逻辑处理
 * 
 * @author system
 * @date 2026-01-25
 */
public interface CarPurchaseCommentBiz {

    /**
     * 发表评论
     * 
     * @param comment 评论信息
     * @return 是否成功
     */
    boolean addComment(CarPurchaseComment comment);

    /**
     * 删除评论
     * 
     * @param tid    主键ID
     * @param userId 操作用户ID（用于权限校验）
     * @return 是否成功
     */
    boolean removeComment(Long tid, Long userId);

    /**
     * 查询某求购的评论列表
     * 
     * @param demandId 求购信息ID
     * @return VO 列表
     */
    List<CarPurchaseCommentVO> queryByDemandId(Long demandId);
}
