package com.demo.common.util;


public class ResponseUtil {


    public static <T> ResponseVO<T> success(T data) {
        ResponseVO<T> response = new ResponseVO<T>();
        response.setCode(ErrorCodeEnum.SUCCESS.getCode());
        response.setMsg(ErrorCodeEnum.SUCCESS.getMsg());
        response.setData(data);
        return response;
    }

    public static <T> ResponseVO<T> error(T data) {
        ResponseVO<T> response = new ResponseVO<T>();
        response.setCode(ErrorCodeEnum.SYSTEM_ERROR.getCode());
        response.setMsg(ErrorCodeEnum.SYSTEM_ERROR.getMsg());
        response.setData(data);
        return response;
    }

    public static <T> ResponseVO<T> error(T data, Integer code, String message) {
        ResponseVO<T> response = new ResponseVO<T>();
        response.setCode(code);
        response.setMsg(message);
        response.setData(data);
        return response;
    }

    /**
     * @param error 错误对象
     * @param data  传输内容
     * @param <T>   内容泛型
     * @return
     */
    public static <T> ResponseVO<T> get(Error error, T data) {
        ResponseVO<T> response = new ResponseVO<T>();
        response.setCode(error.code());
        response.setMsg(error.msg());
        response.setData(data);
        return response;
    }

    /**
     * @param error 错误对象
     * @param data  传输内容
     * @param <T>   内容泛型
     * @return
     */
    public static <T> ResponseVO<T> get(Integer code, String message, T data) {
        ResponseVO<T> response = new ResponseVO<T>();
        response.setCode(code);
        response.setMsg(message);
        response.setData(data);
        return response;
    }

}
