package com.car.base.entity.flashsale.vo;

import com.car.base.entity.flashsale.CarFlashSale;
import java.math.BigDecimal;

/**
 * 秒杀活动 VO
 * 包含车源详细信息
 */
public class CarFlashSaleVO extends CarFlashSale {

    /** 品牌 */
    private String brandName;

    /** 车型 */
    private String model;

    /** 车系 (Optional, can be null if not in CarSource) */
    private String series;

    /** 上牌年月/年份 */
    private String year;

    /** 里程(万公里) */
    private BigDecimal mileage;

    /** 城市 */
    private String city;

    /** 批发价/原价(万) */
    private BigDecimal originalPrice;

    /** 图片 */
    private String images;

    /** 主图 */
    private String mainImage;

    // Getters and Setters

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public BigDecimal getMileage() {
        return mileage;
    }

    public void setMileage(BigDecimal mileage) {
        this.mileage = mileage;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }
}
