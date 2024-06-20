package com.bench.bms.infra.repository.impl;

import com.bench.bms.domain.model.RuleDo;
import com.bench.bms.domain.model.SignalDo;
import com.bench.bms.infra.redisservice.RedisService;
import com.bench.bms.infra.repository.SignalRepository;
import com.bench.bms.infra.repository.converter.RulePoConverter;
import com.bench.bms.infra.repository.entity.RulePo;
import com.bench.bms.infra.repository.mapper.RulePoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author bench
 * @Date 2024/06/18 14:34
 **/
// 负责查询Rule
@Service
public class SignalRepositoryImpl implements SignalRepository {

    @Resource
    private RedisService<RulePo> ruleRedisService;

    @Resource
    private RulePoConverter rulePoConverter;

    @Resource
    private RulePoMapper rulePoMapper;

    private static final long CACHE_TIMEOUT = 18000L; // 定义缓存过期时间为18000秒

    @Override
    public RuleDo getRule(SignalDo signalDo) {
        String redisKey = "carId_" + signalDo.getCarId() + "_warnId_" + signalDo.getWarnId();

        RulePo rulePo = ruleRedisService.get(redisKey);

        if (rulePo == null) {
            rulePo = rulePoMapper.selectRulesBySignal(signalDo);
            ruleRedisService.set(redisKey, rulePo, CACHE_TIMEOUT);
            System.out.println("查询数据库");
        }

        return rulePoConverter.toDo(rulePo);
    }

}
