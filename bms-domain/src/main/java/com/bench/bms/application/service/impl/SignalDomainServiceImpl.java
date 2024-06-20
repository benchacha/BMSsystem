package com.bench.bms.application.service.impl;

import com.bench.bms.domain.model.RuleDo;
import com.bench.bms.domain.model.SignalDo;
import com.bench.bms.domain.service.SignalDomainService;
import com.bench.bms.infra.repository.RuleRepository;
import com.bench.bms.infra.repository.SignalRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author bench
 * @Date 2024/06/19 13:32
 **/

@Service
public class SignalDomainServiceImpl implements SignalDomainService {

    @Resource
    private SignalRepository signalRepository;

//    private RulePo

    @Override
    public RuleDo getRuleBySignal(SignalDo signalDo) {

        RuleDo ruleDo = signalRepository.getRule(signalDo);

        return ruleDo;
    }
}
