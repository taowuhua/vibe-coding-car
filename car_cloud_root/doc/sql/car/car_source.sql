-- ============================================
-- 数据库: car_cloud
-- 表名: car_source (车源信息表)
-- 描述: 存储二手车车源信息，包括品牌、车型、价格、图片等
-- 创建时间: 2026-01-16
-- ============================================

-- 如果表已存在则不创建
CREATE TABLE IF NOT EXISTS car_source (
    -- 序号，主键自增
    tid BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    
    -- 车辆基本信息
    car_no VARCHAR(50) NOT NULL COMMENT '车辆编号',
    brand VARCHAR(100) NOT NULL COMMENT '品牌',
    model VARCHAR(200) NOT NULL COMMENT '车型',
    year_months VARCHAR(20) COMMENT '上牌年月',
    mileage DECIMAL(10,2) COMMENT '行驶里程(万公里)',
    price DECIMAL(12,2) COMMENT '批发价(万)',
    
    -- 地区信息
    city VARCHAR(50) COMMENT '所在城市',
    province VARCHAR(50) COMMENT '所在省份',
    
    -- 车辆配置
    color VARCHAR(20) COMMENT '车辆颜色',
    displacement VARCHAR(20) COMMENT '排量',
    gearbox VARCHAR(20) COMMENT '变速箱类型',
    fuel_type VARCHAR(20) COMMENT '燃料类型(汽油/柴油/新能源)',
    energy_type TINYINT DEFAULT 0 COMMENT '能源类型(0:传统燃油 1:新能源)',
    
    -- 车辆描述
    images TEXT COMMENT '车辆图片(JSON数组)',
    description TEXT COMMENT '车辆描述',
    
    -- 关联信息
    shop_id BIGINT COMMENT '所属微店ID',
    
    -- 车源类型标识
    source_type TINYINT DEFAULT 0 COMMENT '车源类型(0:普通 1:优势车源 2:秒杀车源)',
    is_new_today TINYINT DEFAULT 0 COMMENT '今日上新(0:否 1:是)',
    
    -- 通用字段
    status TINYINT DEFAULT 1 COMMENT '状态(0:下架 1:上架 2:已售)',
    memo VARCHAR(500) COMMENT '备注',
    create_user VARCHAR(50) COMMENT '创建用户',
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    oper_user VARCHAR(50) COMMENT '操作用户',
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    
    -- 索引
    INDEX idx_brand (brand),
    INDEX idx_city (city),
    INDEX idx_price (price),
    INDEX idx_shop_id (shop_id),
    INDEX idx_status (status),
    INDEX idx_source_type (source_type),
    INDEX idx_energy_type (energy_type)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='车源信息表';
