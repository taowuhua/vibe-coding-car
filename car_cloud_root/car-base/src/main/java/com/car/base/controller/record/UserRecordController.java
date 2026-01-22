package com.car.base.controller.record;

import com.car.base.common.Result;
import com.car.base.entity.record.UserRecord;
import com.car.base.service.record.UserRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户记录控制器
 * 提供浏览记录、收藏等接口
 *
 * @author system
 * @date 2026-01-16
 */
@RestController
@RequestMapping("/api/record")
public class UserRecordController {

    /**
     * 用户记录服务
     */
    @Autowired
    private UserRecordService userRecordService;

    /**
     * 获取浏览记录
     *
     * @param userId 用户ID
     * @return 浏览记录列表
     */
    @GetMapping("/browse")
    public Result<List<UserRecord>> browse(@RequestParam Long userId) {
        List<UserRecord> list = userRecordService.getBrowseHistory(userId);
        return Result.success(list);
    }

    /**
     * 获取收藏列表
     *
     * @param userId 用户ID
     * @return 收藏记录列表
     */
    @GetMapping("/favorite")
    public Result<List<UserRecord>> favorite(@RequestParam Long userId) {
        List<UserRecord> list = userRecordService.getFavorites(userId);
        return Result.success(list);
    }

    /**
     * 添加收藏
     *
     * @param record 记录信息
     * @return 添加后的记录
     */
    @PostMapping("/add-favorite")
    public Result<UserRecord> addFavorite(@RequestBody UserRecord record) {
        // 检查是否已收藏
        if (userRecordService.isFavorite(record.getUserId(), record.getCarId())) {
            return Result.error("已收藏过该车源");
        }
        UserRecord result = userRecordService.addFavorite(record);
        return Result.success(result, "收藏成功");
    }

    /**
     * 取消收藏
     *
     * @param tid    记录ID（此处用carId作为参数更合理，但保持接口一致性）
     * @param userId 用户ID
     * @param carId  车源ID
     * @return 操作结果
     */
    @DeleteMapping("/remove-favorite/{tid}")
    public Result<Boolean> removeFavorite(
            @PathVariable Long tid,
            @RequestParam Long userId,
            @RequestParam Long carId) {
        boolean success = userRecordService.removeFavorite(userId, carId);
        if (success) {
            return Result.success(true, "取消收藏成功");
        }
        return Result.error("取消收藏失败");
    }
}
