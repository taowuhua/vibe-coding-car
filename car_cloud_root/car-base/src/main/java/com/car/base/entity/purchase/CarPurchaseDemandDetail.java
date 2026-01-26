package com.car.base.entity.purchase;

import java.util.Date;

/**
 * 求购车型明细实体类
 * 对应表: car_purchase_demand_detail
 * 
 * @author system
 * @date 2026-01-25
 */
public class CarPurchaseDemandDetail {

    // ================= 主键 =================

    /** 序号 */
    private Long tid;

    // ================= 关联字段 =================

    /** 求购信息ID（外键） */
    private Long demandId;

    // ================= 车型信息 =================

    /** 品牌 */
    private String brand;

    /** 车型 */
    private String model;

    /** 年份起 */
    private Integer yearStart;

    /** 年份止 */
    private Integer yearEnd;

    // ================= 审计字段 =================

    /** 状态(0:停用 1:启用) */
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

    public Long getDemandId() {
        return demandId;
    }

    public void setDemandId(Long demandId) {
        this.demandId = demandId;
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

    public Integer getYearStart() {
        return yearStart;
    }

    public void setYearStart(Integer yearStart) {
        this.yearStart = yearStart;
    }

    public Integer getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(Integer yearEnd) {
        this.yearEnd = yearEnd;
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
