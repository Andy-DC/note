package com.demo.common.util;


/**
 * @Auther: yinruidong
 * @Date: 2019/4/13 16:23
 * @Description: 错误工具类
 */
public class ErrorUtil {

    /**
     * 判断响应是否错误
     *
     * @param responseVO
     * @return true 是 false 否
     */
    public static boolean responseError(ResponseVO responseVO) {
        if (ErrorCodeEnum.SUCCESS.getCode() != responseVO.getCode()) {
            // 如果调用失败,直接返回错误信息
            return true;
        } else {
            return false;
        }
    }

}
