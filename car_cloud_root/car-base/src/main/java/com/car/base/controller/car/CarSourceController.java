package com.car.base.controller.car;

import com.car.base.common.Result;
import com.car.base.entity.car.CarSource;
import com.car.base.service.car.CarSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 车源信息控制器
 * 提供车源的增删改查接口
 *
 * @author system
 * @date 2026-01-16
 */
@RestController
@RequestMapping("/api/car")
public class CarSourceController {

    /**
     * 车源信息服务
     */
    @Autowired
    private CarSourceService carSourceService;

    /**
     * 分页查询车源列表
     * 支持品牌、城市、价格范围筛选
     *
     * @param brand    品牌（可选）
     * @param city     城市（可选）
     * @param minPrice 最低价格（可选）
     * @param maxPrice 最高价格（可选）
     * @param pageNum  页码，默认1
     * @param pageSize 每页数量，默认10
     * @return 车源列表
     */
    @GetMapping("/list")
    public Result<List<CarSource>> list(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        List<CarSource> list = carSourceService.listCars(brand, city, minPrice, maxPrice, pageNum, pageSize);
        return Result.success(list);
    }

    /**
     * 获取车源详情
     *
     * @param tid 车源ID
     * @return 车源详情
     */
    @GetMapping("/detail/{tid}")
    public Result<CarSource> detail(@PathVariable Long tid) {
        CarSource carSource = carSourceService.getById(tid);
        if (carSource == null) {
            return Result.error("车源不存在");
        }
        return Result.success(carSource);
    }

    /**
     * 发布车源
     *
     * @param carSource 车源信息
     * @return 发布后的车源
     */
    @PostMapping("/publish")
    public Result<CarSource> publish(@RequestBody CarSource carSource) {
        CarSource result = carSourceService.publish(carSource);
        return Result.success(result, "发布成功");
    }

    /**
     * 更新车源信息
     *
     * @param carSource 车源信息
     * @return 更新后的车源
     */
    @PutMapping("/update")
    public Result<CarSource> update(@RequestBody CarSource carSource) {
        CarSource result = carSourceService.update(carSource);
        return Result.success(result, "更新成功");
    }

    /**
     * 删除车源（逻辑删除）
     *
     * @param tid 车源ID
     * @return 操作结果
     */
    @DeleteMapping("/delete/{tid}")
    public Result<Boolean> delete(@PathVariable Long tid) {
        boolean success = carSourceService.delete(tid);
        if (success) {
            return Result.success(true, "删除成功");
        }
        return Result.error("删除失败");
    }

    /**
     * 获取限时秒杀车源
     *
     * @return 秒杀车源列表
     */
    @GetMapping("/flash-sale")
    public Result<List<CarSource>> flashSale() {
        List<CarSource> list = carSourceService.getFlashSale();
        return Result.success(list);
    }

    /**
     * 获取新能源车源列表
     *
     * @return 新能源车源列表
     */
    @GetMapping("/new-energy")
    public Result<List<CarSource>> newEnergy() {
        List<CarSource> list = carSourceService.getNewEnergy();
        return Result.success(list);
    }

    /**
     * 获取今日上新车源
     *
     * @return 今日上新车源列表
     */
    @GetMapping("/today-new")
    public Result<List<CarSource>> todayNew() {
        List<CarSource> list = carSourceService.getTodayNew();
        return Result.success(list);
    }
}
