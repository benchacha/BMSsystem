package com.bench.bms.infra.repository.converter;

import com.bench.bms.domain.model.RuleDo;
import com.bench.bms.infra.repository.entity.RulePo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author bench
 * @Date 2024/06/18 14:18
 **/
@Component
@Mapper(componentModel = "spring")
public interface RulePoConverter {

    @Mapping(source = "warnRule", target = "rule", qualifiedByName = "stringToSortedMap")
    RuleDo toDo(RulePo rulePo);

    RulePo toPo(RuleDo ruleDo);

    @Named("stringToSortedMap")
    default Map<Double, Integer> stringToSortedMap(String warnRule) {
        Map<Double, Integer> ruleMap = new LinkedHashMap<>();

        // 去除首尾的空格并去除分号
        warnRule = warnRule.trim().replaceAll(";$", "");

        // 按逗号和分号分割字符串
        String[] pairs = warnRule.split("[,;]\\s*");

        // 解析每个键值对
        for (String pair : pairs) {
            String[] keyValue = pair.split(":\\s*");
            if (keyValue.length == 2) {
                try {
                    Double key = Double.parseDouble(keyValue[0]);
                    Integer value = Integer.parseInt(keyValue[1]);
                    ruleMap.put(key, value);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid format for warnRule: " + warnRule);
                }
            } else {
                throw new IllegalArgumentException("Invalid format for warnRule: " + warnRule);
            }
        }

        return ruleMap;
    }
}
