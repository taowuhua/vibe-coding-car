-- ============================================
-- 数据库: car_cloud
-- 文件: init_all_tables.sql
-- 描述: 一键初始化所有业务表（按依赖顺序执行）
-- 创建时间: 2026-01-16
-- ============================================

-- 1. 品牌字典表（无依赖）
SOURCE car/car_brand.sql;

-- 2. 微店表（依赖 users 表）
SOURCE shop/shop.sql;

-- 3. 车源表（依赖 shop 表）
SOURCE car/car_source.sql;

-- 4. 求购需求表（依赖 users 表）
SOURCE purchase/purchase_demand.sql;

-- 5. 物流板车表（无依赖）
SOURCE logistics/logistics_truck.sql;

-- 6. 询价表（依赖 car_source, users 表）
SOURCE inquiry/inquiry.sql;

-- 7. 用户记录表（依赖 car_source, shop, users 表）
SOURCE record/user_record.sql;

-- ============================================
-- 如果不支持 SOURCE 命令，可直接复制下面的完整 SQL
-- ============================================

-- 品牌字典表
CREATE TABLE IF NOT EXISTS car_brand (
    tid BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    brand_name VARCHAR(100) NOT NULL COMMENT '品牌名称',
    brand_logo VARCHAR(255) COMMENT '品牌Logo',
    brand_initial CHAR(1) COMMENT '品牌首字母',
    sort_order INT DEFAULT 0 COMMENT '排序',
    status TINYINT DEFAULT 1 COMMENT '状态(0:停用 1:启用)',
    memo VARCHAR(500) COMMENT '备注',
    create_user VARCHAR(50) COMMENT '创建用户',
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    oper_user VARCHAR(50) COMMENT '操作用户',
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_brand_initial (brand_initial),
    INDEX idx_brand_name (brand_name),
    INDEX idx_sort_order (sort_order)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='品牌字典表';

-- 微店信息表
CREATE TABLE IF NOT EXISTS shop (
    tid BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    shop_name VARCHAR(100) NOT NULL COMMENT '店铺名称',
    user_id BIGINT NOT NULL COMMENT '所属用户ID',
    logo VARCHAR(255) COMMENT '店铺Logo',
    contact_name VARCHAR(50) COMMENT '联系人',
    contact_phone VARCHAR(20) COMMENT '联系电话',
    address VARCHAR(200) COMMENT '店铺地址',
    city VARCHAR(50) COMMENT '所在城市',
    province VARCHAR(50) COMMENT '所在省份',
    description TEXT COMMENT '店铺描述',
    car_count INT DEFAULT 0 COMMENT '在售车辆数',
    status TINYINT DEFAULT 1 COMMENT '状态(0:停用 1:正常)',
    memo VARCHAR(500) COMMENT '备注',
    create_user VARCHAR(50) COMMENT '创建用户',
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    oper_user VARCHAR(50) COMMENT '操作用户',
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_user_id (user_id),
    INDEX idx_city (city),
    INDEX idx_status (status)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='微店信息表';

-- 车源信息表
CREATE TABLE IF NOT EXISTS car_source (
    tid BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    car_no VARCHAR(50) NOT NULL COMMENT '车辆编号',
    brand VARCHAR(100) NOT NULL COMMENT '品牌',
    model VARCHAR(200) NOT NULL COMMENT '车型',
    year_months VARCHAR(20) COMMENT '上牌年月',
    mileage DECIMAL(10,2) COMMENT '行驶里程(万公里)',
    price DECIMAL(12,2) COMMENT '批发价(万)',
    city VARCHAR(50) COMMENT '所在城市',
    province VARCHAR(50) COMMENT '所在省份',
    color VARCHAR(20) COMMENT '车辆颜色',
    displacement VARCHAR(20) COMMENT '排量',
    gearbox VARCHAR(20) COMMENT '变速箱类型',
    fuel_type VARCHAR(20) COMMENT '燃料类型(汽油/柴油/新能源)',
    energy_type TINYINT DEFAULT 0 COMMENT '能源类型(0:传统燃油 1:新能源)',
    images TEXT COMMENT '车辆图片(JSON数组)',
    description TEXT COMMENT '车辆描述',
    shop_id BIGINT COMMENT '所属微店ID',
    source_type TINYINT DEFAULT 0 COMMENT '车源类型(0:普通 1:优势车源 2:秒杀车源)',
    is_new_today TINYINT DEFAULT 0 COMMENT '今日上新(0:否 1:是)',
    status TINYINT DEFAULT 1 COMMENT '状态(0:下架 1:上架 2:已售)',
    memo VARCHAR(500) COMMENT '备注',
    create_user VARCHAR(50) COMMENT '创建用户',
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    oper_user VARCHAR(50) COMMENT '操作用户',
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_brand (brand),
    INDEX idx_city (city),
    INDEX idx_price (price),
    INDEX idx_shop_id (shop_id),
    INDEX idx_status (status),
    INDEX idx_source_type (source_type),
    INDEX idx_energy_type (energy_type)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='车源信息表';

-- 求购需求表
CREATE TABLE IF NOT EXISTS purchase_demand (
    tid BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    demand_no VARCHAR(50) NOT NULL COMMENT '求购编号',
    user_id BIGINT NOT NULL COMMENT '发布用户ID',
    brand VARCHAR(100) COMMENT '意向品牌',
    model VARCHAR(200) COMMENT '意向车型',
    year_range VARCHAR(50) COMMENT '年份范围',
    price_min DECIMAL(12,2) COMMENT '预算最低价(万)',
    price_max DECIMAL(12,2) COMMENT '预算最高价(万)',
    mileage_max DECIMAL(10,2) COMMENT '最大里程(万公里)',
    city VARCHAR(50) COMMENT '所在城市',
    contact_name VARCHAR(50) COMMENT '联系人',
    contact_phone VARCHAR(20) COMMENT '联系电话',
    description TEXT COMMENT '详细需求描述',
    status TINYINT DEFAULT 1 COMMENT '状态(0:已关闭 1:进行中 2:已完成)',
    memo VARCHAR(500) COMMENT '备注',
    create_user VARCHAR(50) COMMENT '创建用户',
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    oper_user VARCHAR(50) COMMENT '操作用户',
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_user_id (user_id),
    INDEX idx_brand (brand),
    INDEX idx_status (status),
    INDEX idx_city (city)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='求购需求表';

-- 物流板车表
CREATE TABLE IF NOT EXISTS logistics_truck (
    tid BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    truck_no VARCHAR(50) NOT NULL COMMENT '板车编号',
    driver_name VARCHAR(50) COMMENT '司机姓名',
    driver_phone VARCHAR(20) COMMENT '司机电话',
    truck_plate VARCHAR(20) COMMENT '车牌号',
    from_city VARCHAR(50) COMMENT '出发城市',
    from_province VARCHAR(50) COMMENT '出发省份',
    to_city VARCHAR(50) COMMENT '目的城市',
    to_province VARCHAR(50) COMMENT '目的省份',
    capacity INT COMMENT '装载数量',
    available_count INT COMMENT '剩余位置',
    departure_date DATE COMMENT '出发日期',
    price_per_car DECIMAL(10,2) COMMENT '单车运费',
    status TINYINT DEFAULT 1 COMMENT '状态(0:已关闭 1:待发车 2:运输中 3:已完成)',
    memo VARCHAR(500) COMMENT '备注',
    create_user VARCHAR(50) COMMENT '创建用户',
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    oper_user VARCHAR(50) COMMENT '操作用户',
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_from_city (from_city),
    INDEX idx_to_city (to_city),
    INDEX idx_departure_date (departure_date),
    INDEX idx_status (status)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='物流板车表';

-- 询价记录表
CREATE TABLE IF NOT EXISTS inquiry (
    tid BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    inquiry_no VARCHAR(50) NOT NULL COMMENT '询价编号',
    car_id BIGINT NOT NULL COMMENT '车源ID',
    user_id BIGINT NOT NULL COMMENT '询价用户ID',
    expected_price DECIMAL(12,2) COMMENT '期望价格(万)',
    message TEXT COMMENT '询价留言',
    reply_content TEXT COMMENT '回复内容',
    reply_price DECIMAL(12,2) COMMENT '回复价格(万)',
    reply_time DATETIME COMMENT '回复时间',
    status TINYINT DEFAULT 0 COMMENT '状态(0:待回复 1:已回复 2:已成交 3:已关闭)',
    memo VARCHAR(500) COMMENT '备注',
    create_user VARCHAR(50) COMMENT '创建用户',
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    oper_user VARCHAR(50) COMMENT '操作用户',
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_car_id (car_id),
    INDEX idx_user_id (user_id),
    INDEX idx_status (status)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='询价记录表';

-- 用户记录表
CREATE TABLE IF NOT EXISTS user_record (
    tid BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    user_id BIGINT NOT NULL COMMENT '用户ID',
    car_id BIGINT COMMENT '车源ID',
    shop_id BIGINT COMMENT '微店ID',
    record_type TINYINT NOT NULL COMMENT '记录类型(1:车源浏览 2:车源收藏 3:微店关注)',
    status TINYINT DEFAULT 1 COMMENT '状态(0:已删除 1:正常)',
    memo VARCHAR(500) COMMENT '备注',
    create_user VARCHAR(50) COMMENT '创建用户',
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    oper_user VARCHAR(50) COMMENT '操作用户',
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_user_id (user_id),
    INDEX idx_car_id (car_id),
    INDEX idx_shop_id (shop_id),
    INDEX idx_record_type (record_type),
    INDEX idx_status (status)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户记录表';

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


-- 初始化常用品牌数据
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

-- ============================================
-- 初始化完成
-- ============================================
