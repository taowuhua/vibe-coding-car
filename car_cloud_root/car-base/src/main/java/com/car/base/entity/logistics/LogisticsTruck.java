package com.car.base.entity.logistics;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 物流板车实体类
 * 对应数据库表: logistics_truck
 *
 * @author system
 * @date 2026-01-16
 */
@TableName("logistics_truck")
public class LogisticsTruck {

    /**
     * 序号，主键自增
     */
    @TableId(type = IdType.AUTO)
    private Long tid;

    /**
     * 板车编号
     */
    private String truckNo;

    /**
     * 司机姓名
     */
    private String driverName;

    /**
     * 司机电话
     */
    private String driverPhone;

    /**
     * 车牌号
     */
    private String truckPlate;

    /**
     * 出发城市
     */
    private String fromCity;

    /**
     * 出发省份
     */
    private String fromProvince;

    /**
     * 目的城市
     */
    private String toCity;

    /**
     * 目的省份
     */
    private String toProvince;

    /**
     * 装载数量
     */
    private Integer capacity;

    /**
     * 剩余位置
     */
    private Integer availableCount;

    /**
     * 出发日期
     */
    private LocalDate departureDate;

    /**
     * 单车运费
     */
    private BigDecimal pricePerCar;

    /**
     * 状态(0:已关闭 1:待发车 2:运输中 3:已完成)
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

    public LogisticsTruck() {
    }

    // ==================== Getter/Setter 方法 ====================

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getTruckNo() {
        return truckNo;
    }

    public void setTruckNo(String truckNo) {
        this.truckNo = truckNo;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getTruckPlate() {
        return truckPlate;
    }

    public void setTruckPlate(String truckPlate) {
        this.truckPlate = truckPlate;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getFromProvince() {
        return fromProvince;
    }

    public void setFromProvince(String fromProvince) {
        this.fromProvince = fromProvince;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getToProvince() {
        return toProvince;
    }

    public void setToProvince(String toProvince) {
        this.toProvince = toProvince;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(Integer availableCount) {
        this.availableCount = availableCount;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public BigDecimal getPricePerCar() {
        return pricePerCar;
    }

    public void setPricePerCar(BigDecimal pricePerCar) {
        this.pricePerCar = pricePerCar;
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
        return "LogisticsTruck{" +
                "tid=" + tid +
                ", truckNo='" + truckNo + '\'' +
                ", fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", departureDate=" + departureDate +
                ", status=" + status +
                '}';
    }
}
