package com.bench.bms.domain.model;

import lombok.Data;

/**
 * @Author bench
 * @Date 2024/06/17 13:04
 **/

@Data
public class SignalDo {
    private Integer carId;
    private Integer warnId;
    private Double max;
    private Double min;
}
