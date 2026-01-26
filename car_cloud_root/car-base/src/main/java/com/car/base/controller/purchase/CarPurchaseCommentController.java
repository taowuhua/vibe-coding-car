package com.car.base.controller.purchase;

import com.car.base.biz.purchase.CarPurchaseCommentBiz;
import com.car.base.common.Result;
import com.car.base.entity.purchase.CarPurchaseComment;
import com.car.base.entity.purchase.vo.CarPurchaseCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 求购评论控制器
 * 负责返回前端接口
 * 返回结构: {"code":"", "success":"", "data":{}, "message":""}
 * 
 * @author system
 * @date 2026-01-25
 */
@RestController
@RequestMapping("/api/purchase/comment")
public class CarPurchaseCommentController {

    @Autowired
    private CarPurchaseCommentBiz carPurchaseCommentBiz;

    /**
     * 发表评论
     * 
     * @param comment 评论信息
     * @return 结果
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody CarPurchaseComment comment) {
        // 参数校验
        if (comment.getDemandId() == null) {
            return Result.error("缺少求购信息ID");
        }
        if (comment.getUserId() == null) {
            return Result.error("缺少用户ID");
        }
        if (comment.getContent() == null || comment.getContent().trim().isEmpty()) {
            return Result.error("评论内容不能为空");
        }

        boolean success = carPurchaseCommentBiz.addComment(comment);
        return success ? Result.success(true, "评论成功") : Result.error("评论失败");
    }

    /**
     * 删除评论
     * 
     * @param params 请求参数，包含 tid 和 userId
     * @return 结果
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody Map<String, Object> params) {
        Object tidObj = params.get("tid");
        Object userIdObj = params.get("userId");

        if (tidObj == null) {
            return Result.error("缺少评论ID");
        }
        if (userIdObj == null) {
            return Result.error("缺少用户ID");
        }

        Long tid = Long.valueOf(tidObj.toString());
        Long userId = Long.valueOf(userIdObj.toString());

        boolean success = carPurchaseCommentBiz.removeComment(tid, userId);
        return success ? Result.success(true, "删除成功") : Result.error("删除失败，可能没有权限");
    }

    /**
     * 获取评论列表
     * 
     * @param params 请求参数，包含 demandId
     * @return 评论列表
     */
    @PostMapping("/list")
    public Result<List<CarPurchaseCommentVO>> list(@RequestBody Map<String, Object> params) {
        Object demandIdObj = params.get("demandId");
        if (demandIdObj == null) {
            return Result.error("缺少求购信息ID");
        }
        Long demandId = Long.valueOf(demandIdObj.toString());
        List<CarPurchaseCommentVO> list = carPurchaseCommentBiz.queryByDemandId(demandId);
        return Result.success(list);
    }
}
