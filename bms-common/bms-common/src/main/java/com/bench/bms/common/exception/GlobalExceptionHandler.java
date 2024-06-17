package com.bench.bms.common.exception;

import com.bench.bms.common.model.BaseRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author bench
 * @Date 2024/06/16 14:21
 **/

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseRes<Void> unexpectedException(Exception e){
        log.error("request error", e);
        return BaseRes.error("系统异常");
    }

}
