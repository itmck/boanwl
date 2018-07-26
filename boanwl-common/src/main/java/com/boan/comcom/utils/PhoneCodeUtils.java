package com.boan.comcom.utils;

import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;


/**
 * User: Boan
 * Date: 2018/7/22
 * Time: 12:58
 * Version:V1.0
 */
public class PhoneCodeUtils {

    private static final String registerMsg1 = "【伯安物流】验证码为：";
    private static final String registerMsg2 = ",您正在注册伯安物流,请5分钟内完成注册,如非本人操作,请忽略本短信。";
    private static final String rePwdMsg1 = "【伯安物流】验证码为：";
    private static final String rePwdMsg2 = ",您正在重置密码,请在5分钟内按照页面提示提交验证码,切勿将验证码泄漏给他人！";
    private static final Map<String, String> headers = new HashMap<>();
    private static final String host, path, method, appcode;

    static {
        host = "http://dxyzm.market.alicloudapi.com";
        path = "/chuangxin/dxjk";
        method = "GET";
        appcode = "ae6a9ff137c741f3931a28f9a5907243";
        headers.put("Authorization", "APPCODE " + appcode);
    }

    /**
     * 发送验证码,
     *
     * @param phoneNumber 输入手机验证码
     * @return 返回发送的手机验证码
     */
    public static String sendLoginCode(String phoneNumber, boolean flg) {
        String code = getCode();
        if (flg) {
            Map<String, String> querys = new HashMap<String, String>();
            querys.put("content", registerMsg1 + code + registerMsg2);
            querys.put("mobile", phoneNumber);
            try {
                HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return  code;
        }
        return code;
    }

    /**
     * 找回密码
     * @param phoneNumber
     * @param flg 测试写false
     * @return
     */
    public static String sendRepwdCode(String phoneNumber, boolean flg) {

        String code = getCode();
        if (flg) {
            Map<String, String> querys = new HashMap<String, String>();
            querys.put("content", rePwdMsg1 + code + rePwdMsg2);
            querys.put("mobile", phoneNumber);
            try {
                HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return code;
    }

    private  static String getCode() {
        String code = "";
        for (int i = 0; i < 6; i++) {
            code += (int) (Math.random() * 10);
        }
        return code;
    }

}
