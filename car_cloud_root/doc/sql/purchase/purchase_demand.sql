-- ============================================
-- 数据库: car_cloud
-- 表名: purchase_demand (求购需求表)
-- 描述: 存储用户的求购需求信息，用于求购大厅展示
-- 创建时间: 2026-01-16
-- ============================================

-- 如果表已存在则不创建
CREATE TABLE IF NOT EXISTS purchase_demand (
    -- 序号，主键自增
    tid BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    
    -- 求购编号
    demand_no VARCHAR(50) NOT NULL COMMENT '求购编号',
    
    -- 用户信息
    user_id BIGINT NOT NULL COMMENT '发布用户ID',
    
    -- 意向车辆信息
    brand VARCHAR(100) COMMENT '意向品牌',
    model VARCHAR(200) COMMENT '意向车型',
    year_range VARCHAR(50) COMMENT '年份范围',
    
    -- 预算范围
    price_min DECIMAL(12,2) COMMENT '预算最低价(万)',
    price_max DECIMAL(12,2) COMMENT '预算最高价(万)',
    mileage_max DECIMAL(10,2) COMMENT '最大里程(万公里)',
    
    -- 联系信息
    city VARCHAR(50) COMMENT '所在城市',
    contact_name VARCHAR(50) COMMENT '联系人',
    contact_phone VARCHAR(20) COMMENT '联系电话',
    
    -- 详细描述
    description TEXT COMMENT '详细需求描述',
    
    -- 通用字段
    status TINYINT DEFAULT 1 COMMENT '状态(0:已关闭 1:进行中 2:已完成)',
    memo VARCHAR(500) COMMENT '备注',
    create_user VARCHAR(50) COMMENT '创建用户',
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    oper_user VARCHAR(50) COMMENT '操作用户',
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    
    -- 索引
    INDEX idx_user_id (user_id),
    INDEX idx_brand (brand),
    INDEX idx_status (status),
    INDEX idx_city (city)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='求购需求表';
