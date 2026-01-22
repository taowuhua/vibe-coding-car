package com.car.base.controller.car;

import com.car.base.common.Result;
import com.car.base.entity.car.CarBrand;
import com.car.base.service.car.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌字典控制器
 * 提供品牌查询接口
 *
 * @author system
 * @date 2026-01-16
 */
@RestController
@RequestMapping("/api/brand")
public class CarBrandController {

    /**
     * 品牌字典服务
     */
    @Autowired
    private CarBrandService carBrandService;

    /**
     * 获取所有启用的品牌列表
     *
     * @return 品牌列表
     */
    @GetMapping("/list")
    public Result<List<CarBrand>> list() {
        List<CarBrand> list = carBrandService.getAllBrands();
        return Result.success(list);
    }

    /**
     * 按首字母搜索品牌
     *
     * @param initial 首字母
     * @return 品牌列表
     */
    @GetMapping("/search")
    public Result<List<CarBrand>> search(
            @RequestParam(required = false) String initial,
            @RequestParam(required = false) String keyword) {
        List<CarBrand> list;
        if (initial != null && !initial.isEmpty()) {
            // 按首字母查询
            list = carBrandService.getByInitial(initial);
        } else if (keyword != null && !keyword.isEmpty()) {
            // 按关键词搜索
            list = carBrandService.search(keyword);
        } else {
            // 返回全部
            list = carBrandService.getAllBrands();
        }
        return Result.success(list);
    }
}
