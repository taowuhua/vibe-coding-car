-- ============================================
-- 数据库: car_cloud
-- 表名: logistics_truck (物流板车表)
-- 描述: 存储物流板车信息，用于车辆运输服务
-- 创建时间: 2026-01-16
-- ============================================

-- 如果表已存在则不创建
CREATE TABLE IF NOT EXISTS logistics_truck (
    -- 序号，主键自增
    tid BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    
    -- 板车编号
    truck_no VARCHAR(50) NOT NULL COMMENT '板车编号',
    
    -- 司机信息
    driver_name VARCHAR(50) COMMENT '司机姓名',
    driver_phone VARCHAR(20) COMMENT '司机电话',
    truck_plate VARCHAR(20) COMMENT '车牌号',
    
    -- 出发地
    from_city VARCHAR(50) COMMENT '出发城市',
    from_province VARCHAR(50) COMMENT '出发省份',
    
    -- 目的地
    to_city VARCHAR(50) COMMENT '目的城市',
    to_province VARCHAR(50) COMMENT '目的省份',
    
    -- 装载信息
    capacity INT COMMENT '装载数量',
    available_count INT COMMENT '剩余位置',
    departure_date DATE COMMENT '出发日期',
    
    -- 价格信息
    price_per_car DECIMAL(10,2) COMMENT '单车运费',
    
    -- 通用字段
    status TINYINT DEFAULT 1 COMMENT '状态(0:已关闭 1:待发车 2:运输中 3:已完成)',
    memo VARCHAR(500) COMMENT '备注',
    create_user VARCHAR(50) COMMENT '创建用户',
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    oper_user VARCHAR(50) COMMENT '操作用户',
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    
    -- 索引
    INDEX idx_from_city (from_city),
    INDEX idx_to_city (to_city),
    INDEX idx_departure_date (departure_date),
    INDEX idx_status (status)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='物流板车表';
