-- ============================================
-- 数据库: car_cloud
-- 表名: inquiry (询价记录表)
-- 描述: 存储用户对车源的询价记录及回复信息
-- 创建时间: 2026-01-16
-- ============================================

-- 如果表已存在则不创建
CREATE TABLE IF NOT EXISTS inquiry (
    -- 序号，主键自增
    tid BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    
    -- 询价编号
    inquiry_no VARCHAR(50) NOT NULL COMMENT '询价编号',
    
    -- 关联信息
    car_id BIGINT NOT NULL COMMENT '车源ID',
    user_id BIGINT NOT NULL COMMENT '询价用户ID',
    
    -- 询价信息
    expected_price DECIMAL(12,2) COMMENT '期望价格(万)',
    message TEXT COMMENT '询价留言',
    
    -- 回复信息
    reply_content TEXT COMMENT '回复内容',
    reply_price DECIMAL(12,2) COMMENT '回复价格(万)',
    reply_time DATETIME COMMENT '回复时间',
    
    -- 通用字段
    status TINYINT DEFAULT 0 COMMENT '状态(0:待回复 1:已回复 2:已成交 3:已关闭)',
    memo VARCHAR(500) COMMENT '备注',
    create_user VARCHAR(50) COMMENT '创建用户',
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    oper_user VARCHAR(50) COMMENT '操作用户',
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    
    -- 索引
    INDEX idx_car_id (car_id),
    INDEX idx_user_id (user_id),
    INDEX idx_status (status)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='询价记录表';
