package com.bench.bms.application.service.impl;

import com.bench.bms.domain.model.RuleDo;
import com.bench.bms.domain.model.SignalDo;
import com.bench.bms.domain.model.WarnDo;
import com.bench.bms.domain.service.RuleDomainService;
import com.bench.bms.infra.repository.RuleRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author bench
 * @Date 2024/06/19 13:31
 **/

@Service
public class RuleDomainServiceImpl implements RuleDomainService {

    @Resource
    private RuleRepository ruleRepository;

    @Override
    public WarnDo getWarn(SignalDo signalDo, RuleDo ruleDo) {

        return ruleRepository.getWarn(signalDo, ruleDo);
    }
}
