package com.car.base.entity.purchase;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 求购需求实体类
 * 对应数据库表: purchase_demand
 *
 * @author system
 * @date 2026-01-16
 */
@TableName("purchase_demand")
public class PurchaseDemand {

    /**
     * 序号，主键自增
     */
    @TableId(type = IdType.AUTO)
    private Long tid;

    /**
     * 求购编号
     */
    private String demandNo;

    /**
     * 发布用户ID
     */
    private Long userId;

    /**
     * 意向品牌
     */
    private String brand;

    /**
     * 意向车型
     */
    private String model;

    /**
     * 年份范围
     */
    private String yearRange;

    /**
     * 预算最低价(万)
     */
    private BigDecimal priceMin;

    /**
     * 预算最高价(万)
     */
    private BigDecimal priceMax;

    /**
     * 最大里程(万公里)
     */
    private BigDecimal mileageMax;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 详细需求描述
     */
    private String description;

    /**
     * 状态(0:已关闭 1:进行中 2:已完成)
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

    public PurchaseDemand() {
    }

    // ==================== Getter/Setter 方法 ====================

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getDemandNo() {
        return demandNo;
    }

    public void setDemandNo(String demandNo) {
        this.demandNo = demandNo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYearRange() {
        return yearRange;
    }

    public void setYearRange(String yearRange) {
        this.yearRange = yearRange;
    }

    public BigDecimal getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(BigDecimal priceMin) {
        this.priceMin = priceMin;
    }

    public BigDecimal getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(BigDecimal priceMax) {
        this.priceMax = priceMax;
    }

    public BigDecimal getMileageMax() {
        return mileageMax;
    }

    public void setMileageMax(BigDecimal mileageMax) {
        this.mileageMax = mileageMax;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "PurchaseDemand{" +
                "tid=" + tid +
                ", demandNo='" + demandNo + '\'' +
                ", brand='" + brand + '\'' +
                ", priceMin=" + priceMin +
                ", priceMax=" + priceMax +
                ", status=" + status +
                '}';
    }
}
