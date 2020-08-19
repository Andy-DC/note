package com.demo.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;


/**
 * ErrorProperties
 *
 * @author liujunping
 * @date 2019/10/8
 * @description 错误信息配置
 */
@Component
@ConfigurationProperties(prefix = "error")
@Lazy
@Slf4j
public class ErrorProperties {

    private HashMap<Integer, String> map = new HashMap<>();

    public HashMap<Integer, String> getMap() {
        return map;
    }

    public String getErrorMsg(Integer code) {
        String msg = map.get(code);
        if (StringUtils.isEmpty(msg)) {
            msg = "失败！";
        }
        log.info("getErrorMsg:{}", msg);
        return msg;
    }
}

