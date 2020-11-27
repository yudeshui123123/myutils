package com.common.myutils.utils;

import java.util.UUID;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/9/7 9:53
 * @description:
 */
public class tool {

    public static String getUuId() {
        StringBuffer sb = new StringBuffer();
        String[] strArray = UUID.randomUUID().toString().split("-");
        for (String str : strArray) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(getUuId());
        }
    }
}
