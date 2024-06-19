package com.bench.bms.infra.repository.entity;

import lombok.Data;

/**
 * @Author bench
 * @Date 2024/06/17 20:04
 **/

@Data
public class RulePo {

    private Long id;
    private Integer warnId;
    private String warnName;
    private String batteryType;
    private String warnRule;

}
