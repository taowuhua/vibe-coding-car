-- ============================================
-- 数据库: car_cloud
-- 表名: car_purchase_comment
-- 描述: 求购评论表
-- 创建时间: 2026-01-25
-- ============================================

CREATE TABLE IF NOT EXISTS car_purchase_comment (
    -- 主键
    tid BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    
    -- 关联字段
    demand_id BIGINT NOT NULL COMMENT '求购信息ID（外键）',
    user_id BIGINT NOT NULL COMMENT '评论用户ID',
    parent_id BIGINT DEFAULT 0 COMMENT '父评论ID（支持回复，0表示顶级评论）',
    
    -- 评论内容
    content TEXT NOT NULL COMMENT '评论内容',
    
    -- 必填审计字段
    status TINYINT DEFAULT 1 COMMENT '状态(0:已删除 1:正常)',
    memo VARCHAR(500) COMMENT '备注',
    create_user VARCHAR(50) COMMENT '创建用户',
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    oper_user VARCHAR(50) COMMENT '操作用户',
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

    -- 索引
    INDEX idx_demand_id (demand_id),
    INDEX idx_user_id (user_id),
    INDEX idx_parent_id (parent_id),
    INDEX idx_status (status),
    INDEX idx_create_date (create_date)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='求购评论表';
