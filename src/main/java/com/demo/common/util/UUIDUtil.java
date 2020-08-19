package com.demo.common.util;

import java.util.UUID;

/**
 * UUIDUtil
 *
 * @author liujunping
 * @date 2019/10/9
 * @description 生成uuid
 */
public class UUIDUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
