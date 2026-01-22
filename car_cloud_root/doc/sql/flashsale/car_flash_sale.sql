-- ============================================
-- 数据库: car_cloud
-- 表名: car_flash_sale
-- 描述: 秒杀活动车源表
-- 创建时间: 2026-01-16
-- ============================================

CREATE TABLE IF NOT EXISTS car_flash_sale (
    tid BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    car_id BIGINT NOT NULL COMMENT '车源ID',
    flash_price DECIMAL(12,2) NOT NULL COMMENT '秒杀价格(万)',
    start_time DATETIME NOT NULL COMMENT '开始时间',
    end_time DATETIME NOT NULL COMMENT '结束时间',
    activity_name VARCHAR(100) COMMENT '活动名称',
    
    -- 必填审计字段
    status TINYINT DEFAULT 1 COMMENT '状态(0:停用 1:启用 2:已结束)',
    memo VARCHAR(500) COMMENT '备注',
    create_user VARCHAR(50) COMMENT '创建用户',
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    oper_user VARCHAR(50) COMMENT '操作用户',
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

    -- 索引
    INDEX idx_car_id (car_id),
    INDEX idx_start_time (start_time),
    INDEX idx_end_time (end_time),
    INDEX idx_status (status)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='秒杀活动车源表';
