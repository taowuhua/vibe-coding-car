package com.car.base.controller.logistics;

import com.car.base.common.Result;
import com.car.base.entity.logistics.LogisticsTruck;
import com.car.base.service.logistics.LogisticsTruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 物流板车控制器
 * 提供物流的增删改查接口
 *
 * @author system
 * @date 2026-01-16
 */
@RestController
@RequestMapping("/api/logistics")
public class LogisticsTruckController {

    /**
     * 物流板车服务
     */
    @Autowired
    private LogisticsTruckService logisticsTruckService;

    /**
     * 分页查询物流板车列表
     *
     * @param fromCity 出发城市（可选）
     * @param toCity   目的城市（可选）
     * @param pageNum  页码，默认1
     * @param pageSize 每页数量，默认10
     * @return 物流板车列表
     */
    @GetMapping("/list")
    public Result<List<LogisticsTruck>> list(
            @RequestParam(required = false) String fromCity,
            @RequestParam(required = false) String toCity,
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        List<LogisticsTruck> list = logisticsTruckService.listTrucks(fromCity, toCity, pageNum, pageSize);
        return Result.success(list);
    }

    /**
     * 获取物流详情
     *
     * @param tid 物流ID
     * @return 物流板车信息
     */
    @GetMapping("/detail/{tid}")
    public Result<LogisticsTruck> detail(@PathVariable Long tid) {
        LogisticsTruck truck = logisticsTruckService.getById(tid);
        if (truck == null) {
            return Result.error("物流信息不存在");
        }
        return Result.success(truck);
    }

    /**
     * 发布物流信息
     *
     * @param truck 物流板车信息
     * @return 发布后的物流板车
     */
    @PostMapping("/publish")
    public Result<LogisticsTruck> publish(@RequestBody LogisticsTruck truck) {
        LogisticsTruck result = logisticsTruckService.publish(truck);
        return Result.success(result, "发布成功");
    }

    /**
     * 更新物流信息
     *
     * @param truck 物流板车信息
     * @return 更新后的物流板车
     */
    @PutMapping("/update")
    public Result<LogisticsTruck> update(@RequestBody LogisticsTruck truck) {
        LogisticsTruck result = logisticsTruckService.update(truck);
        return Result.success(result, "更新成功");
    }

    /**
     * 获取有剩余位置的物流板车
     *
     * @return 物流板车列表
     */
    @GetMapping("/available")
    public Result<List<LogisticsTruck>> available() {
        List<LogisticsTruck> list = logisticsTruckService.getAvailable();
        return Result.success(list);
    }
}
