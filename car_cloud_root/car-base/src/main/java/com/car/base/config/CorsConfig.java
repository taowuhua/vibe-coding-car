package com.car.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 全局跨域配置
 * 注意：当通过 Gateway 访问时，请禁用此配置，避免 CORS 头重复
 * Gateway 和 car-base 都配置 CORS 会导致响应中出现重复的 Access-Control-Allow-Origin 头
 * 浏览器会拒绝此类响应
 * 
 * 如需直接访问 car-base (绕过 Gateway)，请取消下面的注释
 */
// @Configuration // 已禁用：CORS 统一在 Gateway 层处理
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        // 允许所有方法 (GET, POST, PUT, DELETE, etc.)
        config.addAllowedMethod("*");
        // 允许所有请求头
        config.addAllowedHeader("*");
        // 允许所有来源 (使用 Pattern 以支持 allowCredentials = true)
        config.addAllowedOriginPattern("*");
        // 允许携带凭证 (Cookies, Auth Headers)
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
