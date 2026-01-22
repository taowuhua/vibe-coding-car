package com.car.base.entity.record;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

/**
 * 用户记录实体类（收藏、浏览记录）
 * 对应数据库表: user_record
 *
 * @author system
 * @date 2026-01-16
 */
@TableName("user_record")
public class UserRecord {

    /**
     * 序号，主键自增
     */
    @TableId(type = IdType.AUTO)
    private Long tid;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 车源ID
     */
    private Long carId;

    /**
     * 微店ID
     */
    private Long shopId;

    /**
     * 记录类型(1:车源浏览 2:车源收藏 3:微店关注)
     */
    private Integer recordType;

    /**
     * 状态(0:已删除 1:正常)
     */
    private Integer status;

    /**
     * 备注
     */
    private String memo;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 操作用户
     */
    private String operUser;

    /**
     * 更新时间
     */
    private LocalDateTime updateDate;

    // ==================== 构造函数 ====================

    public UserRecord() {
    }

    // ==================== Getter/Setter 方法 ====================

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getOperUser() {
        return operUser;
    }

    public void setOperUser(String operUser) {
        this.operUser = operUser;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "UserRecord{" +
                "tid=" + tid +
                ", userId=" + userId +
                ", carId=" + carId +
                ", shopId=" + shopId +
                ", recordType=" + recordType +
                ", status=" + status +
                '}';
    }
}
