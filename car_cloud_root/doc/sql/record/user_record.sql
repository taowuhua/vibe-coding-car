-- ============================================
-- 数据库: car_cloud
-- 表名: user_record (用户记录表)
-- 描述: 存储用户的浏览记录、收藏记录、微店关注等
-- 创建时间: 2026-01-16
-- ============================================

-- 如果表已存在则不创建
CREATE TABLE IF NOT EXISTS user_record (
    -- 序号，主键自增
    tid BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    
    -- 用户信息
    user_id BIGINT NOT NULL COMMENT '用户ID',
    
    -- 关联对象
    car_id BIGINT COMMENT '车源ID',
    shop_id BIGINT COMMENT '微店ID',
    
    -- 记录类型
    record_type TINYINT NOT NULL COMMENT '记录类型(1:车源浏览 2:车源收藏 3:微店关注)',
    
    -- 通用字段
    status TINYINT DEFAULT 1 COMMENT '状态(0:已删除 1:正常)',
    memo VARCHAR(500) COMMENT '备注',
    create_user VARCHAR(50) COMMENT '创建用户',
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    oper_user VARCHAR(50) COMMENT '操作用户',
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    
    -- 索引
    INDEX idx_user_id (user_id),
    INDEX idx_car_id (car_id),
    INDEX idx_shop_id (shop_id),
    INDEX idx_record_type (record_type),
    INDEX idx_status (status)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户记录表';
