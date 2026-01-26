package com.car.base.entity.purchase.vo;

import com.car.base.entity.purchase.CarPurchaseComment;

/**
 * 求购评论展示 VO
 * 包含评论用户信息
 * 
 * @author system
 * @date 2026-01-25
 */
public class CarPurchaseCommentVO extends CarPurchaseComment {

    // ================= 用户扩展信息 =================

    /** 评论用户昵称 */
    private String nickname;

    /** 评论用户头像 */
    private String avatar;

    // ================= 格式化时间 =================

    /** 格式化的评论时间（如：5分钟前） */
    private String createTimeText;

    // ================= Getters and Setters =================

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCreateTimeText() {
        return createTimeText;
    }

    public void setCreateTimeText(String createTimeText) {
        this.createTimeText = createTimeText;
    }
}
