package com.bench.bms.infra.repository.entity;

import lombok.Data;

/**
 * @Author bench
 * @Date 2024/06/17 15:22
 **/

@Data
public class WarnPo {
    private Long id;
    private Long carNumber;
    private String batteryType;
    private String warnName;
    private Integer warnLevel;
}
