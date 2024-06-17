package com.bench.bms.application.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Author bench
 * @Date 2024/06/16 21:42
 **/

@Data
public class SignalDto {
    private Integer carId;
    private Integer warnId;
    private Map<String, Double> signal;

    public SignalDto(Integer carId, Integer warnId, Map<String, Double> signal){
        this.carId = carId;
        this.warnId = warnId;
        this.signal = signal;
    }
}
