package com.bench.bms.application.service.impl;

import com.bench.bms.application.converter.SignalDtoConverter;
import com.bench.bms.application.converter.WarnDtoConverter;
import com.bench.bms.application.model.SignalDto;
import com.bench.bms.application.model.WarnDto;
import com.bench.bms.application.service.BmsWarnService;
import com.bench.bms.domain.model.RuleDo;
import com.bench.bms.domain.model.SignalDo;
import com.bench.bms.domain.model.WarnDo;
import com.bench.bms.domain.service.RuleDomainService;
import com.bench.bms.domain.service.SignalDomainService;
import com.bench.bms.domain.service.WarnDomainService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author bench
 * @Date 2024/06/18 13:35
 **/

@Service
public class BmsWarnServiceImpl implements BmsWarnService {

    @Resource
    private SignalDtoConverter signalDtoConverter;

    @Resource
    private WarnDtoConverter warnDtoConverter;

    @Resource
    private SignalDomainService signalDomainService;

    @Resource
    private RuleDomainService ruleDomainService;

    @Resource
    private WarnDomainService warnDomainService;

    @Override
    public WarnDto getWarn(SignalDto signalDto) {

//        1、根据输入的信号查找对应的规则
        SignalDo signalDo = signalDtoConverter.toDo(signalDto);

        RuleDo ruleDo = signalDomainService.getRuleBySignal(signalDo);
//        2、根据查询到的规则和信号，判断报警信息
        WarnDo warnDo = ruleDomainService.getWarn(signalDo, ruleDo);
//        3、保存报警信息
        if (warnDomainService.saveWarn(warnDo)){
            System.out.println("保存成功");
        } else {
            System.out.println("保存失败");
        }
        System.out.println(warnDo);
//        4、向接口返回预警信息
        WarnDto warnDto = warnDtoConverter.toDto(warnDo);
        return warnDto;
    }

//    将二和一的信号拆分为俩个
    @Override
    public List<SignalDto> signalHandle(List<SignalDto> signalDtoList) {

        List<SignalDto> newSignalDtoList = new ArrayList<SignalDto>();

        for (SignalDto signalDto : signalDtoList){
            if (signalDto.getWarnId() == null){

                Map<String, Double> signal = signalDto.getSignal();

                Map<String, Double> signal1 = new HashMap<>();
                signal1.put("Mx", signal.get("Mx"));
                signal1.put("Mi", signal.get("Mi"));

                Map<String, Double> signal2 = new HashMap<>();
                signal2.put("Ix", signal.get("Ix"));
                signal2.put("Ii", signal.get("Ii"));

                SignalDto signalDto1 = new SignalDto(signalDto.getCarId(), 1, signal1);
                SignalDto signalDto2 = new SignalDto(signalDto.getCarId(), 2, signal2);

                newSignalDtoList.add(signalDto1);
                newSignalDtoList.add(signalDto2);

            } else {
                newSignalDtoList.add(signalDto);
            }
        }
        return newSignalDtoList;
    }
}
