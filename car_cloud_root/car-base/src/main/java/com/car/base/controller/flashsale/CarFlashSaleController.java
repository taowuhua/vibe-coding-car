package com.car.base.controller.flashsale;

import com.car.base.biz.flashsale.CarFlashSaleBiz;
import com.car.base.common.Result;
import com.car.base.entity.flashsale.CarFlashSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 秒杀活动控制器
 * 负责返回前端接口
 * 返回结构: {"code":"", "success":"", "data":{}, "message":""}
 */
@RestController
@RequestMapping("/api/flashsale")
public class CarFlashSaleController {

    @Autowired
    private CarFlashSaleBiz carFlashSaleBiz;

    /**
     * 新增秒杀活动
     * 
     * @param carFlashSale 实体
     * @return 结果
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody CarFlashSale carFlashSale) {
        boolean success = carFlashSaleBiz.createFlashSale(carFlashSale);
        return success ? Result.success(true, "创建成功") : Result.error("创建失败");
    }

    /**
     * 更新秒杀活动
     * 
     * @param carFlashSale 实体
     * @return 结果
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody CarFlashSale carFlashSale) {
        boolean success = carFlashSaleBiz.modifyFlashSale(carFlashSale);
        return success ? Result.success(true, "更新成功") : Result.error("更新失败");
    }

    /**
     * 获取秒杀活动列表
     * 
     * @param carFlashSale 查询条件
     * @return 列表
     */
    @PostMapping("/list")
    public Result<List<com.car.base.entity.flashsale.vo.CarFlashSaleVO>> list(
            @RequestBody(required = false) CarFlashSale carFlashSale) {
        if (carFlashSale == null) {
            carFlashSale = new CarFlashSale();
        }
        List<com.car.base.entity.flashsale.vo.CarFlashSaleVO> list = carFlashSaleBiz.queryVoList(carFlashSale);
        return Result.success(list);
    }

    /**
     * 获取详情
     * 
     * @param tid 序号
     * @return 详情
     */
    @GetMapping("/detail")
    public Result<CarFlashSale> detail(@RequestParam Long tid) {
        CarFlashSale detail = carFlashSaleBiz.getDetail(tid);
        return Result.success(detail);
    }
}
