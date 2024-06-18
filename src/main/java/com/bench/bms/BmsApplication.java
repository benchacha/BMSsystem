package com.bench.bms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author bench
 * @Date 2024/06/18 09:04
 **/

@MapperScan("com.bench.bms.mapper")
@SpringBootApplication
public class BmsApplication {
    public static void main(String[] args){
        SpringApplication.run(Appendable.class, args);
    }
}
