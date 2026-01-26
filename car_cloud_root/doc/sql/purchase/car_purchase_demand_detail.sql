-- ============================================
-- 数据库: car_cloud
-- 表名: car_purchase_demand_detail
-- 描述: 求购车型明细表
-- 创建时间: 2026-01-25
-- ============================================

CREATE TABLE IF NOT EXISTS car_purchase_demand_detail (
    -- 主键
    tid BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    
    -- 关联字段
    demand_id BIGINT NOT NULL COMMENT '求购信息ID（外键）',
    
    -- 车型信息
    brand VARCHAR(50) NOT NULL COMMENT '品牌',
    model VARCHAR(100) COMMENT '车型',
    year_start INT COMMENT '年份起',
    year_end INT COMMENT '年份止',
    
    -- 必填审计字段
    status TINYINT DEFAULT 1 COMMENT '状态(0:停用 1:启用)',
    memo VARCHAR(500) COMMENT '备注',
    create_user VARCHAR(50) COMMENT '创建用户',
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    oper_user VARCHAR(50) COMMENT '操作用户',
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

    -- 索引
    INDEX idx_demand_id (demand_id),
    INDEX idx_brand (brand),
    INDEX idx_status (status)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='求购车型明细表';
