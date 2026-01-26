-- ============================================
-- 数据库: car_cloud
-- 表名: car_purchase_demand
-- 描述: 求购信息主表
-- 创建时间: 2026-01-25
-- ============================================

CREATE TABLE IF NOT EXISTS car_purchase_demand (
    -- 主键
    tid BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    
    -- 用户信息
    user_id BIGINT NOT NULL COMMENT '发布用户ID',
    shop_name VARCHAR(100) COMMENT '店铺名称',
    
    -- 地区信息
    province VARCHAR(50) COMMENT '所在省份',
    city VARCHAR(50) COMMENT '所在城市',
    
    -- 求购描述
    description TEXT COMMENT '求购描述',
    
    -- 联系方式
    contact_phone VARCHAR(20) COMMENT '联系电话',
    contact_wechat VARCHAR(50) COMMENT '联系微信',
    
    -- 统计字段
    view_count INT DEFAULT 0 COMMENT '浏览次数',
    comment_count INT DEFAULT 0 COMMENT '评论数量',
    
    -- 必填审计字段
    status TINYINT DEFAULT 1 COMMENT '状态(0:停用 1:启用 2:已完成)',
    memo VARCHAR(500) COMMENT '备注',
    create_user VARCHAR(50) COMMENT '创建用户',
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    oper_user VARCHAR(50) COMMENT '操作用户',
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

    -- 索引
    INDEX idx_user_id (user_id),
    INDEX idx_city (city),
    INDEX idx_status (status),
    INDEX idx_create_date (create_date)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='求购信息主表';
