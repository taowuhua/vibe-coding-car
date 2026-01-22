-- ============================================
-- 数据库: car_cloud
-- 表名: car_brand (品牌字典表)
-- 描述: 存储汽车品牌信息，用于品牌筛选和搜索
-- 创建时间: 2026-01-16
-- ============================================

-- 如果表已存在则不创建
CREATE TABLE IF NOT EXISTS car_brand (
    -- 序号，主键自增
    tid BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    
    -- 品牌信息
    brand_name VARCHAR(100) NOT NULL COMMENT '品牌名称',
    brand_logo VARCHAR(255) COMMENT '品牌Logo',
    brand_initial CHAR(1) COMMENT '品牌首字母',
    sort_order INT DEFAULT 0 COMMENT '排序',
    
    -- 通用字段
    status TINYINT DEFAULT 1 COMMENT '状态(0:停用 1:启用)',
    memo VARCHAR(500) COMMENT '备注',
    create_user VARCHAR(50) COMMENT '创建用户',
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    oper_user VARCHAR(50) COMMENT '操作用户',
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    
    -- 索引
    INDEX idx_brand_initial (brand_initial),
    INDEX idx_brand_name (brand_name),
    INDEX idx_sort_order (sort_order)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='品牌字典表';

-- ============================================
-- 初始化常用品牌数据
-- ============================================
INSERT IGNORE INTO car_brand (brand_name, brand_initial, sort_order, create_user) VALUES
('奥迪', 'A', 1, 'system'),
('宝马', 'B', 2, 'system'),
('奔驰', 'B', 3, 'system'),
('别克', 'B', 4, 'system'),
('本田', 'B', 5, 'system'),
('大众', 'D', 6, 'system'),
('丰田', 'F', 7, 'system'),
('福特', 'F', 8, 'system'),
('哈弗', 'H', 9, 'system'),
('吉利', 'J', 10, 'system'),
('凯迪拉克', 'K', 11, 'system'),
('雷克萨斯', 'L', 12, 'system'),
('路虎', 'L', 13, 'system'),
('马自达', 'M', 14, 'system'),
('日产', 'R', 15, 'system'),
('特斯拉', 'T', 16, 'system'),
('五菱', 'W', 17, 'system'),
('现代', 'X', 18, 'system'),
('雪佛兰', 'X', 19, 'system'),
('长安', 'C', 20, 'system'),
('长城', 'C', 21, 'system'),
('比亚迪', 'B', 22, 'system'),
('理想', 'L', 23, 'system'),
('蔚来', 'W', 24, 'system'),
('小鹏', 'X', 25, 'system');
