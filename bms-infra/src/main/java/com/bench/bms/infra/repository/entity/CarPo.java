package com.bench.bms.infra.repository.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author bench
 * @Date 2024/06/17 20:03
 **/

@Data
@TableName("VehicleInfo")
public class CarPo {

    @TableId("id")
    private Long id;
    private String vId;
    private Long carNumber;
    private String batteryType;
    private Long totalMileage;
    private Integer batteryStatus;

}