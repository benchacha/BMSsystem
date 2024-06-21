package com.bench.bms.infra.repository.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @Author bench
 * @Date 2024/06/17 20:03
 **/

// 命名为CarPo是为了方便我对DDD架构的理解。

@Data
@TableName("car")
public class CarPo {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String vid;
    private Long carId;
    private String batteryType;
    private Long totalMileage;
    private Integer batteryStatus;

    @TableField(fill = FieldFill.INSERT)
    private Long createTime;

    @TableField(fill = FieldFill.INSERT)
    private String createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateUser;

}
