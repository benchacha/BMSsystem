package com.bench.bms.entity;

import lombok.Data;

/**
 * @Author bench
 * @Date 2024/06/18 09:10
 **/

@Data
public class Rule {

    private Long id;
    private Integer warnId;
    private String warnName;
    private String batteryType;
    private String warnRule;

}
