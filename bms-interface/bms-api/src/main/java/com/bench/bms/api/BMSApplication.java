package com.bench.bms.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author bench
 * @Date 2024/06/16 13:13
 **/


@SpringBootApplication
@ComponentScan("com.bench")
@MapperScan("com.bench.bms.infra.repository.mapper")
public class BMSApplication {
    public static void main(String[] args){
        SpringApplication.run(BMSApplication.class, args);
    }
}
