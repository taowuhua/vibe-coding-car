package com.car.base.service.impl.record;

import com.car.base.entity.record.UserRecord;
import com.car.base.mapper.record.UserRecordMapper;
import com.car.base.service.record.UserRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户记录服务实现类
 *
 * @author system
 * @date 2026-01-16
 */
@Service
public class UserRecordServiceImpl implements UserRecordService {

    /**
     * 用户记录 Mapper
     */
    @Autowired
    private UserRecordMapper userRecordMapper;

    /**
     * 获取用户浏览记录
     */
    @Override
    public List<UserRecord> getBrowseHistory(Long userId) {
        return userRecordMapper.findBrowseHistory(userId);
    }

    /**
     * 获取用户收藏列表
     */
    @Override
    public List<UserRecord> getFavorites(Long userId) {
        return userRecordMapper.findFavorites(userId);
    }

    /**
     * 添加收藏
     */
    @Override
    @Transactional
    public UserRecord addFavorite(UserRecord record) {
        // 检查是否已收藏
        if (isFavorite(record.getUserId(), record.getCarId())) {
            // 已收藏，直接返回
            return record;
        }

        // 设置记录类型为收藏
        record.setRecordType(2);
        record.setStatus(1);
        record.setCreateDate(LocalDateTime.now());
        record.setUpdateDate(LocalDateTime.now());

        // 插入数据库
        userRecordMapper.insert(record);
        return record;
    }

    /**
     * 取消收藏
     */
    @Override
    @Transactional
    public boolean removeFavorite(Long userId, Long carId) {
        return userRecordMapper.removeFavorite(userId, carId) > 0;
    }

    /**
     * 添加浏览记录
     */
    @Override
    @Transactional
    public UserRecord addBrowseHistory(UserRecord record) {
        // 设置记录类型为浏览
        record.setRecordType(1);
        record.setStatus(1);
        record.setCreateDate(LocalDateTime.now());
        record.setUpdateDate(LocalDateTime.now());

        // 插入数据库
        userRecordMapper.insert(record);
        return record;
    }

    /**
     * 检查是否已收藏
     */
    @Override
    public boolean isFavorite(Long userId, Long carId) {
        return userRecordMapper.checkFavorite(userId, carId) > 0;
    }
}
