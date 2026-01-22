package com.car.base.entity.inquiry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 询价记录实体类
 * 对应数据库表: inquiry
 *
 * @author system
 * @date 2026-01-16
 */
@TableName("inquiry")
public class Inquiry {

    /**
     * 序号，主键自增
     */
    @TableId(type = IdType.AUTO)
    private Long tid;

    /**
     * 询价编号
     */
    private String inquiryNo;

    /**
     * 车源ID
     */
    private Long carId;

    /**
     * 询价用户ID
     */
    private Long userId;

    /**
     * 期望价格(万)
     */
    private BigDecimal expectedPrice;

    /**
     * 询价留言
     */
    private String message;

    /**
     * 回复内容
     */
    private String replyContent;

    /**
     * 回复价格(万)
     */
    private BigDecimal replyPrice;

    /**
     * 回复时间
     */
    private LocalDateTime replyTime;

    /**
     * 状态(0:待回复 1:已回复 2:已成交 3:已关闭)
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

    public Inquiry() {
    }

    // ==================== Getter/Setter 方法 ====================

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getInquiryNo() {
        return inquiryNo;
    }

    public void setInquiryNo(String inquiryNo) {
        this.inquiryNo = inquiryNo;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getExpectedPrice() {
        return expectedPrice;
    }

    public void setExpectedPrice(BigDecimal expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public BigDecimal getReplyPrice() {
        return replyPrice;
    }

    public void setReplyPrice(BigDecimal replyPrice) {
        this.replyPrice = replyPrice;
    }

    public LocalDateTime getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(LocalDateTime replyTime) {
        this.replyTime = replyTime;
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
        return "Inquiry{" +
                "tid=" + tid +
                ", inquiryNo='" + inquiryNo + '\'' +
                ", carId=" + carId +
                ", userId=" + userId +
                ", expectedPrice=" + expectedPrice +
                ", status=" + status +
                '}';
    }
}
