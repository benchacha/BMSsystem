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

    public enum WarnId {
        MX_MI(1),
        IX_II(2);

        private final int value;

        WarnId(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    @Override
    public WarnDo getWarn(SignalDo signalDo, RuleDo ruleDo) {
        WarnDo warnDo = new WarnDo();
        warnDo.setCarId(signalDo.getCarId());
        warnDo.setWarnName(ruleDo.getWarnName());
        warnDo.setBatteryType(ruleDo.getBatteryType());

        double diff;

        // 电压/电流的差值
        if (WarnId.MX_MI.getValue() == signalDo.getWarnId()) {
            diff = signalDo.getSignal().get("Mx") - signalDo.getSignal().get("Mi");
        } else if (WarnId.IX_II.getValue() == signalDo.getWarnId()) {
            diff = signalDo.getSignal().get("Ix") - signalDo.getSignal().get("Ii");
        } else {
            // 处理未知的warnId情况，这里根据实际情况进行逻辑处理
            diff = 0; // 或者抛出异常，视情况而定
        }

        // 根据差值查找对应的报警等级
        int warnLevel = findWarnLevel(diff, ruleDo.getRule());
        warnDo.setWarnLevel(warnLevel);
        return warnDo;
    }

    /**
     * 根据Mx和Mi的差值以及规则Map查找对应的报警等级
     * @param diff Mx和Mi的差值
     * @param ruleMap 规则Map，键为阈值，值为报警等级
     * @return 报警等级，如果找不到对应的阈值范围则返回-1表示不报警
     */
    private int findWarnLevel(double diff, Map<Double, Integer> ruleMap) {
        for (Map.Entry<Double, Integer> entry : ruleMap.entrySet()) {
            double threshold = entry.getKey();
            if (diff >= threshold) {
                return entry.getValue();
            }
        }
        return -1;
    }
}
