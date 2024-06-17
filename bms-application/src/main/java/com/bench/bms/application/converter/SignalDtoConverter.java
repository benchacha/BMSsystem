package com.bench.bms.application.converter;

import com.bench.bms.application.model.SignalDto;
import com.bench.bms.domain.model.SignalDo;

/**
 * @Author bench
 * @Date 2024/06/17 13:03
 **/
public interface SignalDtoConverter {

    SignalDo toDo(SignalDto signalDto);

    SignalDto toDto(SignalDo signalDo);

}
