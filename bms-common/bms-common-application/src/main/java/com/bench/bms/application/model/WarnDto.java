package com.bench.bms.application.model;

import lombok.Data;

/**
 * @Author bench
 * @Date 2024/06/16 21:44
 **/

@Data
public class WarnDto {

    private Integer carId;

    private String batteryType;

    private String warnName;

    private Integer warnLevel;

}
