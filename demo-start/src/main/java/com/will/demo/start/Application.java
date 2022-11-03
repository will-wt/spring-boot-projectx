package com.will.demo.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Will.WT
 * @date 2022/10/19 12:15
 */
@SpringBootApplication(
        scanBasePackages = {"com.will.demo"}
)
@MapperScan(basePackages = "com.will.demo.dal.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
