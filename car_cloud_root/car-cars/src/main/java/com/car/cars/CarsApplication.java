package com.car.cars;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.car.cars.mapper")
public class CarsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarsApplication.class, args);
    }
}
