package com.bench.bms.api.converter;

import com.bench.bms.api.model.res.WarnVo;
import com.bench.bms.application.model.WarnDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @Author bench
 * @Date 2024/06/18 13:40
 **/

@Mapper(componentModel = "spring")
public interface WarnVoConverter {

//    @Mapping(source = "carId", target = "carNumber")
    @Mapping(source = "batteryType", target = "batteryType")
    @Mapping(source = "warnName", target = "warnName")
    @Mapping(source = "warnLevel", target = "warnLevel")
    WarnVo toVo(WarnDto warnDto);
}
