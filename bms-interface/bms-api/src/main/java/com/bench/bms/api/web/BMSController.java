package com.bench.bms.api.web;

import com.bench.bms.api.converter.SignalVoConverter;
import com.bench.bms.api.converter.WarnVoConverter;
import com.bench.bms.api.model.req.SignalReq;
import com.bench.bms.api.model.res.WarnVo;
import com.bench.bms.application.converter.WarnDtoConverter;
import com.bench.bms.application.model.SignalDto;
import com.bench.bms.application.model.WarnDto;
import com.bench.bms.application.service.BmsWarnService;
import com.bench.bms.common.model.BaseRes;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author bench
 * @Date 2024/06/16 13:34
 **/

@Slf4j
@RestController
@RequestMapping("/api")
public class BMSController {

    @Resource
    private SignalVoConverter signalVoConverter;

    @Resource
    private WarnVoConverter warnVoConverter;

    @Resource
    private BmsWarnService bmsWarnService;

    @PostMapping("warn")
    public BaseRes<List<WarnVo>> queryWarnLevel(@RequestBody List<SignalReq> signalReqList) {

        for (SignalReq signalReq : signalReqList){
            System.out.println(signalReq);
        }
//        将接受到的列表信息，通过lambda函数调用signalVoConverter
        List<SignalDto> signalDtoList = signalReqList.stream()
                .map(signalVoConverter::toDto)
                .collect(Collectors.toList());

        signalDtoList = bmsWarnService.signalHandle(signalDtoList);

        signalDtoList.forEach(System.out::println);
//        将接受到的signalReq，bmsWarnService得到warnInfo

//        WarnDto test = bmsWarnService.getWarn(signalDtoList.get(0));
        List<WarnDto> warnDtoList = signalDtoList.stream()
                .map(signalDto -> bmsWarnService.getWarn(signalDto))
                .collect(Collectors.toList());

        List<WarnVo> warnVoList = warnDtoList.stream()
                .map(warnVoConverter::toVo)
                .collect(Collectors.toList());

        return BaseRes.success(warnVoList);
    }

}
