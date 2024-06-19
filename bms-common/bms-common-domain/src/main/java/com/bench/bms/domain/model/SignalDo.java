package com.bench.bms.domain.model;

import lombok.Data;

import java.util.Map;

/**
 * @Author bench
 * @Date 2024/06/17 13:04
 **/

@Data
public class SignalDo {
    private Long carId;
    private Integer warnId;
    private Map<String, Double> signal;
}
