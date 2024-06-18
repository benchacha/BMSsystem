package com.bench.bms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author bench
 * @Date 2024/06/18 09:10
 **/

@Data
@TableName("carInfo")
public class Car {
    private Long id;
    private String vId;
    private Long carNumber;
    private String batteryType;
    private Long totalMileage;
    private Integer batteryStatus;
}
