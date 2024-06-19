package com.bench.bms.infra.repository.impl;

import com.bench.bms.domain.model.RuleDo;
import com.bench.bms.domain.model.SignalDo;
import com.bench.bms.domain.model.WarnDo;
import com.bench.bms.infra.repository.RuleRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author bench
 * @Date 2024/06/18 14:32
 **/

@Service
public class RuleRepositoryImpl implements RuleRepository {

    @Override
    public WarnDo getWarn(SignalDo signalDo, RuleDo ruleDo) {
        WarnDo warnDo = new WarnDo();
        warnDo.setCarNumber(signalDo.getCarId());
        warnDo.setWarnName(ruleDo.getWarnName());
        warnDo.setBatteryType(ruleDo.getBatteryType());

        double diff;

        // 获取Mx和Mi的差值
        if (signalDo.getWarnId() == 1) {
            diff = signalDo.getSignal().get("Mx") - signalDo.getSignal().get("Mi");
        } else {
            diff = signalDo.getSignal().get("Ix") - signalDo.getSignal().get("Ii");
        }


        // 根据差值查找对应的报警等级
        int warnLevel = findwarnLevel(diff, ruleDo.getRule());

        // 设置报警等级
        warnDo.setWarnLevel(warnLevel);

        return warnDo;
    }

    /**
     * 根据Mx和Mi的差值以及规则Map查找对应的报警等级
     * @param diff Mx和Mi的差值
     * @param ruleMap 规则Map，键为阈值，值为报警等级
     * @return 报警等级，如果找不到对应的阈值范围则返回-1表示不报警
     */
    private int findwarnLevel(double diff, Map<Double, Integer> ruleMap) {
        for (Map.Entry<Double, Integer> entry : ruleMap.entrySet()) {
            double threshold = entry.getKey();
            if (diff >= threshold) {
                return entry.getValue();
            }
        }
        // 如果没有匹配的阈值范围，不报警
        return -1;
    }
}