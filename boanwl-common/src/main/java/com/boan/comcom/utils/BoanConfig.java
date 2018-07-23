package com.boan.comcom.utils;

import java.util.ResourceBundle;

/**
 * User: Boan
 * Date: 2018/7/22
 * Time: 13:08
 * Version:V1.0
 */
public class BoanConfig {

    private  static final ResourceBundle resource = ResourceBundle.getBundle("boan_configs");
    public static final  String CHATBOT_WEBHOOK = resource.getString("bugRobot.webhook");

}
