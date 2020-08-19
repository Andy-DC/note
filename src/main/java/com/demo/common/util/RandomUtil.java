package com.demo.common.util;

import java.util.Random;

/**
 * @author wangxujie
 * @2020/3/31
 * @description 处理随机生成的
 */
public class RandomUtil {


    public static String getRandomNickname(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }


}
