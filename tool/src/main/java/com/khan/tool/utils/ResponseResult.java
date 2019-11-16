package com.khan.tool.utils;

import java.io.Serializable;

/**
 * 返回类
 * @param <T>
 */
public class ResponseResult<T> implements Serializable {

    private Integer code;

    private T data;

    public ResponseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public static <T> ResponseResult<T> ok(Integer code, T data) {
        return new ResponseResult(code, data);
    }
    public static <T>  ResponseResult<T> ok() {
        return new ResponseResult(0, "ok");
    }
    public static <T>  ResponseResult<T> ok(T data) {
        return new ResponseResult(0, data);
    }

    public static <T>  ResponseResult<T> error(Integer code, T data) {
        return new ResponseResult(code, data);
    }

    public static <T>  ResponseResult<T> error(T data) {
        return new ResponseResult(1, data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
