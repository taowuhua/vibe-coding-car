package com.car.base.entity.purchase.vo;

import com.car.base.entity.purchase.CarPurchaseDemand;
import com.car.base.entity.purchase.CarPurchaseDemandDetail;

import java.util.List;

/**
 * 求购信息展示 VO
 * 包含用户信息和车型明细列表
 * 
 * @author system
 * @date 2026-01-25
 */
public class CarPurchaseDemandVO extends CarPurchaseDemand {

    // ================= 用户扩展信息 =================

    /** 用户昵称 */
    private String nickname;

    /** 用户头像 */
    private String avatar;

    // ================= 关联数据 =================

    /** 求购车型明细列表 */
    private List<CarPurchaseDemandDetail> detailList;

    // ================= 格式化时间 =================

    /** 格式化的发布时间（如：5分钟前） */
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

    public List<CarPurchaseDemandDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<CarPurchaseDemandDetail> detailList) {
        this.detailList = detailList;
    }

    public String getCreateTimeText() {
        return createTimeText;
    }

    public void setCreateTimeText(String createTimeText) {
        this.createTimeText = createTimeText;
    }
}
