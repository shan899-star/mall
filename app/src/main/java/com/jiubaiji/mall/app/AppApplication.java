package com.jiubaiji.mall.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.jiubaiji.mall.module.mapper")
@SpringBootApplication(scanBasePackages = "com.jiubaiji.mall")

public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
}
