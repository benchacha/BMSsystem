package com.bench.bms.application.model;

import lombok.Data;

import java.util.Map;

/**
 * @Author bench
 * @Date 2024/06/18 13:11
 **/

@Data
public class RuleDto {

    private Map<Double, Integer> rule;

}
