package com.superb.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private Integer code; //编码：1成功，0和其它数字为失败
    private String msg; //错误信息
    private T data; //数据

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 1;
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.code = 1;
        return result;
    }

    /**
     * code = 2，账号不存在
     * code = 3，账号异常（停用/删除）
     * code = 4，账号密码错误
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(Integer code, String msg) {
        Result result = new Result();
        result.msg = msg;
        result.code = code;
        return result;
    }

}