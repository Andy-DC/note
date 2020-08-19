package com.demo.common.util;

import lombok.Data;

/**
 * @param <T>
 * @author yinruidong
 * @ClassName: ResponseVO
 * @Description: 接口响应返回内容对象
 * @date 2019/2/3
 */
@Data
public class Response1VO {
    /**
     * 业务返回码 0 正功 其它错误
     */
    private int Result;

    /**
     * 错误信息
     */
    private String ResultMessage;

    /**
     * 数据部分, 只能是{}, 一定不要给 null ""
     */
    private Object Info;

}
