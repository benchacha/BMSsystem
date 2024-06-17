package com.bench.bms.infra.repository;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author bench
 * @Date 2024/06/17 20:47
 **/

@MapperScan("com.bench.bms.infra.repository.mapper")
@Configuration
public class MybatisConfig {
}
