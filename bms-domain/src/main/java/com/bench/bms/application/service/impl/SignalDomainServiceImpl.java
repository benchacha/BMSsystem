package com.bench.bms.application.service.impl;

import com.bench.bms.domain.model.RuleDo;
import com.bench.bms.domain.model.SignalDo;
import com.bench.bms.domain.service.SignalDomainService;
import com.bench.bms.infra.redisservice.RedisService;
import com.bench.bms.infra.repository.SignalRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author bench
 * @Date 2024/06/19 13:32
 **/
@Slf4j
@Service
public class SignalDomainServiceImpl implements SignalDomainService {

    @Resource
    private SignalRepository signalRepository;

    @Resource
    private RedisService<RuleDo> ruleRedisService;

    private static final long CACHE_TIMEOUT = 18000L; // 定义缓存过期时间为18000秒

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RuleDo getRuleBySignal(SignalDo signalDo) {

        String redisKey = "carId:" + signalDo.getCarId() + ":warnId:" + signalDo.getWarnId();
        RuleDo ruleDo = ruleRedisService.get(redisKey);

        if (ruleDo == null){
            ruleDo = signalRepository.getRule(signalDo);
            ruleRedisService.set(redisKey, ruleDo, CACHE_TIMEOUT);
            log.info("数据库查询rule" + redisKey);
        }
//        throw new RuntimeException("预警信息事务回滚测试");
        return ruleDo;
    }
}
