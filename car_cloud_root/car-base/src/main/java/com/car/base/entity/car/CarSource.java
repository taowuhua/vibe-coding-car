package com.car.base.entity.car;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 车源信息实体类
 * 对应数据库表: car_source
 *
 * @author system
 * @date 2026-01-16
 */
@TableName("car_source")
public class CarSource {

    /**
     * 序号，主键自增
     */
    @TableId(type = IdType.AUTO)
    private Long tid;

    /**
     * 车辆编号
     */
    private String carNo;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 车型
     */
    private String model;

    /**
     * 上牌年月
     */
    private String yearMonths;

    /**
     * 行驶里程(万公里)
     */
    private BigDecimal mileage;

    /**
     * 批发价(万)
     */
    private BigDecimal price;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 所在省份
     */
    private String province;

    /**
     * 车辆颜色
     */
    private String color;

    /**
     * 排量
     */
    private String displacement;

    /**
     * 变速箱类型
     */
    private String gearbox;

    /**
     * 燃料类型(汽油/柴油/新能源)
     */
    private String fuelType;

    /**
     * 能源类型(0:传统燃油 1:新能源)
     */
    private Integer energyType;

    /**
     * 车辆图片(JSON数组)
     */
    private String images;

    /**
     * 车辆描述
     */
    private String description;

    /**
     * 所属微店ID
     */
    private Long shopId;

    /**
     * 车源类型(0:普通 1:优势车源 2:秒杀车源)
     */
    private Integer sourceType;

    /**
     * 今日上新(0:否 1:是)
     */
    private Integer isNewToday;

    /**
     * 状态(0:下架 1:上架 2:已售)
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

    public CarSource() {
    }

    // ==================== Getter/Setter 方法 ====================

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
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

    public String getYearMonths() {
        return yearMonths;
    }

    public void setYearMonths(String yearMonths) {
        this.yearMonths = yearMonths;
    }

    public BigDecimal getMileage() {
        return mileage;
    }

    public void setMileage(BigDecimal mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getEnergyType() {
        return energyType;
    }

    public void setEnergyType(Integer energyType) {
        this.energyType = energyType;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getIsNewToday() {
        return isNewToday;
    }

    public void setIsNewToday(Integer isNewToday) {
        this.isNewToday = isNewToday;
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
        return "CarSource{" +
                "tid=" + tid +
                ", carNo='" + carNo + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", city='" + city + '\'' +
                ", status=" + status +
                '}';
    }
}
