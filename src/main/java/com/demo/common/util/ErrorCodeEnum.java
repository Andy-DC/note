package com.demo.common.util;

/**
 * ErrorCodeEnum
 *
 * @author yinruidong
 * @date 2019/7/30
 * @description TODO
 */
public enum ErrorCodeEnum {
    /**
     * 成功
     */
    SUCCESS(0, "请求成功"),
    /**
     * 系统错误
     */
    SYSTEM_ERROR(1, "系统错误！");

    private Integer code;
    private String msg;

    ErrorCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
