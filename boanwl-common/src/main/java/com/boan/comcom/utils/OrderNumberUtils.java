package com.boan.comcom.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * User: Boan
 * Date: 2018/7/29
 * Time: 16:18
 * Version:V1.0
 */
public class OrderNumberUtils {

    private static ArrayList<Character> list = new ArrayList<>();

    static {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            list.add(ch);
        }
    }

    public static String getSendID() {

        return "SE" + LocalDateTime.now().toString().replaceAll("-", "").substring(2, 8)
                + (long) (Math.random() * 1000_0000_0000_0000L) + getTailId();

    }

    private static String getTailId() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(list.get((int) (Math.random() * 26)));
        }
        return sb.toString();
    }


}
