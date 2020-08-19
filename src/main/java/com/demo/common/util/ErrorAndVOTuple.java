package com.demo.common.util;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * @author yinruidong
 * @ClassName: ErrorAndVOTuple
 * @Description: service层返回多个对象（错误码、错误信息和数据部分）
 * @date 2019/3/5
 */
@AllArgsConstructor
@ToString
public class ErrorAndVOTuple<V> {
    /**
     * 错误码
     */
    public final Integer code;
    /**
     * 错误内容
     */
    public final String msg;
    /**
     * 数据部分
     */
    public final V data;


}
