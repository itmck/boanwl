package com.boan.comcom.utils;

import java.util.UUID;

/**
 * User: volker
 * Date: 2018/7/24
 * Time: 19:41
 * Version:V1.0
 */
public class UUIDutil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
