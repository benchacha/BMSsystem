package com.bench.bms.infra.repository.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Map;

/**
 * @Author bench
 * @Date 2024/06/17 20:04
 **/

@Data
@TableName("WarningRules")
public class RulePo {

    @TableId("id")
    private Long id;
    private Integer warnId;
    private String warnName;
    private String batteryType;
    private String warnRule;

}
