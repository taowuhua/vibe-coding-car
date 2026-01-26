package com.car.base.entity.purchase;

import java.util.Date;

/**
 * 求购信息实体类
 * 对应表: car_purchase_demand
 * 
 * @author system
 * @date 2026-01-25
 */
public class CarPurchaseDemand {

    // ================= 主键 =================

    /** 序号 */
    private Long tid;

    // ================= 用户信息 =================

    /** 发布用户ID */
    private Long userId;

    /** 店铺名称 */
    private String shopName;

    // ================= 地区信息 =================

    /** 所在省份 */
    private String province;

    /** 所在城市 */
    private String city;

    // ================= 求购描述 =================

    /** 求购描述 */
    private String description;

    // ================= 联系方式 =================

    /** 联系电话 */
    private String contactPhone;

    /** 联系微信 */
    private String contactWechat;

    // ================= 统计字段 =================

    /** 浏览次数 */
    private Integer viewCount;

    /** 评论数量 */
    private Integer commentCount;

    // ================= 审计字段 =================

    /** 状态(0:停用 1:启用 2:已完成) */
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactWechat() {
        return contactWechat;
    }

    public void setContactWechat(String contactWechat) {
        this.contactWechat = contactWechat;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
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
