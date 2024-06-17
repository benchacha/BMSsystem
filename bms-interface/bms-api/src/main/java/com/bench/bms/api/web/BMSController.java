package com.bench.bms.api.web;

import com.bench.bms.api.converter.SignalVoConverter;
import com.bench.bms.api.model.req.SignalReq;
import com.bench.bms.application.model.SignalDto;
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

    @PostMapping("warn")
    public BaseRes<Void> queryWarnLevel(@RequestBody List<SignalReq> signalReqList) {

        for (SignalReq signalReq : signalReqList){
            System.out.println(signalReq);
        }

        List<SignalDto> signalDtoList = signalReqList.stream()
                .map(signalVoConverter::toDto)
                .collect(Collectors.toList());

        signalDtoList.forEach(System.out::println);

        return BaseRes.success();
    }

}
