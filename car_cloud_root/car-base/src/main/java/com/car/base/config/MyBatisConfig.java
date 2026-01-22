package com.car.base.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.car.base.mapper")
public class MyBatisConfig {
}
