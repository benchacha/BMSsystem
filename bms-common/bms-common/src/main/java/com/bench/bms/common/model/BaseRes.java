package com.bench.bms.common.model;

import lombok.Data;

/**
 * @Author bench
 * @Date 2024/06/16 14:22
 **/
@Data
public class BaseRes<T>  {

    public static final int CODE_SUCCESS = 0;

    public static final int CODE_ERROR = -1;


    private int code;

    private String message;

    private T data;

    public BaseRes(int code, String message, T data) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
    }

    public static <T> BaseRes<T> success() {
        return new BaseRes<T>(CODE_SUCCESS, "success", null);
    }

    public static <T> BaseRes<T> success(T data) {
        return new BaseRes<T>(CODE_SUCCESS, "success", data);
    }

    public static <T> BaseRes<T> error(String msg) {
        return new BaseRes<T>(CODE_ERROR, msg, null);
    }

}
