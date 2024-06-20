package com.bench.bms.infra.repository.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author bench
 * @Date 2024/06/17 20:03
 **/

@Data
public class CarPo {
    private Long id;
    private String vId;
    private Long carId;
    private String batteryType;
    private Long totalMileage;
    private Integer batteryStatus;

}
