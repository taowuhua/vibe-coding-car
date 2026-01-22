package com.car.base.controller.shop;

import com.car.base.common.Result;
import com.car.base.entity.car.CarSource;
import com.car.base.entity.shop.Shop;
import com.car.base.service.car.CarSourceService;
import com.car.base.service.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 微店信息控制器
 * 提供微店的增删改查接口
 *
 * @author system
 * @date 2026-01-16
 */
@RestController
@RequestMapping("/api/shop")
public class ShopController {

    /**
     * 微店信息服务
     */
    @Autowired
    private ShopService shopService;

    /**
     * 车源信息服务
     */
    @Autowired
    private CarSourceService carSourceService;

    /**
     * 获取我的微店信息
     *
     * @param userId 用户ID
     * @return 微店信息
     */
    @GetMapping("/my")
    public Result<Shop> my(@RequestParam Long userId) {
        Shop shop = shopService.getByUserId(userId);
        if (shop == null) {
            return Result.error("您还没有创建微店");
        }
        return Result.success(shop);
    }

    /**
     * 获取微店详情
     *
     * @param tid 微店ID
     * @return 微店信息
     */
    @GetMapping("/detail/{tid}")
    public Result<Shop> detail(@PathVariable Long tid) {
        Shop shop = shopService.getById(tid);
        if (shop == null) {
            return Result.error("微店不存在");
        }
        return Result.success(shop);
    }

    /**
     * 创建微店
     *
     * @param shop 微店信息
     * @return 创建后的微店
     */
    @PostMapping("/create")
    public Result<Shop> create(@RequestBody Shop shop) {
        // 检查用户是否已有微店
        Shop existingShop = shopService.getByUserId(shop.getUserId());
        if (existingShop != null) {
            return Result.error("您已经创建过微店");
        }
        Shop result = shopService.create(shop);
        return Result.success(result, "创建成功");
    }

    /**
     * 更新微店信息
     *
     * @param shop 微店信息
     * @return 更新后的微店
     */
    @PutMapping("/update")
    public Result<Shop> update(@RequestBody Shop shop) {
        Shop result = shopService.update(shop);
        return Result.success(result, "更新成功");
    }

    /**
     * 获取微店车源列表
     *
     * @param shopId 微店ID
     * @return 车源列表
     */
    @GetMapping("/cars/{shopId}")
    public Result<List<CarSource>> shopCars(@PathVariable Long shopId) {
        List<CarSource> list = carSourceService.getByShopId(shopId);
        return Result.success(list);
    }
}
