package com.car.base.entity.flashsale;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 秒杀活动车源实体类
 * 对应表: car_flash_sale
 */
public class CarFlashSale {

    /** 序号 */
    private Long tid;

    /** 车源ID */
    private Long carId;

    /** 秒杀价格(万) */
    private BigDecimal flashPrice;

    /** 开始时间 */
    private Date startTime;

    /** 结束时间 */
    private Date endTime;

    /** 活动名称 */
    private String activityName;

    /** 状态(0:停用 1:启用 2:已结束) */
    private Integer status;

    /** 备注 */
    private String memo;

    /** 创建用户 */
    private String createUser;

    /** 创建时间 */
    private Date createDate;

    /** 操作用户 */
    private String operUser;

    /** 更新时间 */
    private Date updateDate;

    // ================= Getters and Setters =================

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public BigDecimal getFlashPrice() {
        return flashPrice;
    }

    public void setFlashPrice(BigDecimal flashPrice) {
        this.flashPrice = flashPrice;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getOperUser() {
        return operUser;
    }

    public void setOperUser(String operUser) {
        this.operUser = operUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
