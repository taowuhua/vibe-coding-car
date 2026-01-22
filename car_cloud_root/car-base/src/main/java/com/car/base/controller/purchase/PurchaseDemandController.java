package com.car.base.controller.purchase;

import com.car.base.common.Result;
import com.car.base.entity.purchase.PurchaseDemand;
import com.car.base.service.purchase.PurchaseDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 求购需求控制器
 * 提供求购的增删改查接口
 *
 * @author system
 * @date 2026-01-16
 */
@RestController
@RequestMapping("/api/purchase")
public class PurchaseDemandController {

    /**
     * 求购需求服务
     */
    @Autowired
    private PurchaseDemandService purchaseDemandService;

    /**
     * 分页查询求购大厅列表
     *
     * @param pageNum  页码，默认1
     * @param pageSize 每页数量，默认10
     * @return 求购需求列表
     */
    @GetMapping("/list")
    public Result<List<PurchaseDemand>> list(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        List<PurchaseDemand> list = purchaseDemandService.listDemands(pageNum, pageSize);
        return Result.success(list);
    }

    /**
     * 获取我的求购需求
     *
     * @param userId 用户ID
     * @return 求购需求列表
     */
    @GetMapping("/my")
    public Result<List<PurchaseDemand>> my(@RequestParam Long userId) {
        List<PurchaseDemand> list = purchaseDemandService.getByUserId(userId);
        return Result.success(list);
    }

    /**
     * 获取求购详情
     *
     * @param tid 求购ID
     * @return 求购需求信息
     */
    @GetMapping("/detail/{tid}")
    public Result<PurchaseDemand> detail(@PathVariable Long tid) {
        PurchaseDemand demand = purchaseDemandService.getById(tid);
        if (demand == null) {
            return Result.error("求购需求不存在");
        }
        return Result.success(demand);
    }

    /**
     * 发布求购需求
     *
     * @param demand 求购需求信息
     * @return 发布后的求购需求
     */
    @PostMapping("/publish")
    public Result<PurchaseDemand> publish(@RequestBody PurchaseDemand demand) {
        PurchaseDemand result = purchaseDemandService.publish(demand);
        return Result.success(result, "发布成功");
    }

    /**
     * 更新求购需求
     *
     * @param demand 求购需求信息
     * @return 更新后的求购需求
     */
    @PutMapping("/update")
    public Result<PurchaseDemand> update(@RequestBody PurchaseDemand demand) {
        PurchaseDemand result = purchaseDemandService.update(demand);
        return Result.success(result, "更新成功");
    }

    /**
     * 关闭求购需求
     *
     * @param tid 求购ID
     * @return 操作结果
     */
    @PutMapping("/close/{tid}")
    public Result<Boolean> close(@PathVariable Long tid) {
        boolean success = purchaseDemandService.close(tid);
        if (success) {
            return Result.success(true, "已关闭");
        }
        return Result.error("关闭失败");
    }
}
