package com.common.myutils;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.common.myutils.mapper"})
public class MyutilsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyutilsApplication.class, args);
    }

}
