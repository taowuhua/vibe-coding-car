package com.car.base.controller.inquiry;

import com.car.base.common.Result;
import com.car.base.entity.inquiry.Inquiry;
import com.car.base.service.inquiry.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 询价记录控制器
 * 提供询价的增删改查接口
 *
 * @author system
 * @date 2026-01-16
 */
@RestController
@RequestMapping("/api/inquiry")
public class InquiryController {

    /**
     * 询价记录服务
     */
    @Autowired
    private InquiryService inquiryService;

    /**
     * 获取询价列表（车商视角）
     *
     * @param shopId   微店ID
     * @param pageNum  页码，默认1
     * @param pageSize 每页数量，默认10
     * @return 询价记录列表
     */
    @GetMapping("/list")
    public Result<List<Inquiry>> list(
            @RequestParam Long shopId,
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        List<Inquiry> list = inquiryService.listInquiries(shopId, pageNum, pageSize);
        return Result.success(list);
    }

    /**
     * 获取我的询价记录（用户视角）
     *
     * @param userId 用户ID
     * @return 询价记录列表
     */
    @GetMapping("/my")
    public Result<List<Inquiry>> my(@RequestParam Long userId) {
        List<Inquiry> list = inquiryService.getByUserId(userId);
        return Result.success(list);
    }

    /**
     * 提交询价
     *
     * @param inquiry 询价信息
     * @return 提交后的询价记录
     */
    @PostMapping("/submit")
    public Result<Inquiry> submit(@RequestBody Inquiry inquiry) {
        Inquiry result = inquiryService.submit(inquiry);
        return Result.success(result, "询价提交成功");
    }

    /**
     * 回复询价
     *
     * @param inquiry 询价信息（包含回复内容）
     * @return 回复后的询价记录
     */
    @PostMapping("/reply")
    public Result<Inquiry> reply(@RequestBody Inquiry inquiry) {
        Inquiry result = inquiryService.reply(inquiry);
        return Result.success(result, "回复成功");
    }
}
