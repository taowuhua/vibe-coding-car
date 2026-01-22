-- ============================================
-- 数据库: car_cloud
-- 表名: shop (微店信息表)
-- 描述: 存储车商微店信息，包括店铺名称、联系方式、地址等
-- 创建时间: 2026-01-16
-- ============================================

-- 如果表已存在则不创建
CREATE TABLE IF NOT EXISTS shop (
    -- 序号，主键自增
    tid BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    
    -- 店铺基本信息
    shop_name VARCHAR(100) NOT NULL COMMENT '店铺名称',
    user_id BIGINT NOT NULL COMMENT '所属用户ID',
    logo VARCHAR(255) COMMENT '店铺Logo',
    
    -- 联系信息
    contact_name VARCHAR(50) COMMENT '联系人',
    contact_phone VARCHAR(20) COMMENT '联系电话',
    
    -- 地址信息
    address VARCHAR(200) COMMENT '店铺地址',
    city VARCHAR(50) COMMENT '所在城市',
    province VARCHAR(50) COMMENT '所在省份',
    
    -- 店铺描述
    description TEXT COMMENT '店铺描述',
    
    -- 统计信息
    car_count INT DEFAULT 0 COMMENT '在售车辆数',
    
    -- 通用字段
    status TINYINT DEFAULT 1 COMMENT '状态(0:停用 1:正常)',
    memo VARCHAR(500) COMMENT '备注',
    create_user VARCHAR(50) COMMENT '创建用户',
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    oper_user VARCHAR(50) COMMENT '操作用户',
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    
    -- 索引
    INDEX idx_user_id (user_id),
    INDEX idx_city (city),
    INDEX idx_status (status)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='微店信息表';
