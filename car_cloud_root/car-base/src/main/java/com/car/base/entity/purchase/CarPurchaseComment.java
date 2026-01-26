package com.car.base.entity.purchase;

import java.util.Date;

/**
 * 求购评论实体类
 * 对应表: car_purchase_comment
 * 
 * @author system
 * @date 2026-01-25
 */
public class CarPurchaseComment {

    // ================= 主键 =================

    /** 序号 */
    private Long tid;

    // ================= 关联字段 =================

    /** 求购信息ID（外键） */
    private Long demandId;

    /** 评论用户ID */
    private Long userId;

    /** 父评论ID（支持回复，0表示顶级评论） */
    private Long parentId;

    // ================= 评论内容 =================

    /** 评论内容 */
    private String content;

    // ================= 审计字段 =================

    /** 状态(0:已删除 1:正常) */
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
