package com.boanwl.manager.service.impl.boan;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.boanwl.manager.service.boan.PhoneCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Boan
 * Date: 2018/7/26
 * Time: 22:34
 * Version:V1.0
 */
@Service
public class PhoneCodeServiceImpl implements PhoneCodeService {

    private final boolean really = false;

    @Autowired
    private JedisClient jedisClient;
    private BugRobot bugRobot = new BugRobot();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Map<String, Object> sendRegisterCode(String phoneNumber) {
        return getCode(phoneNumber, true);
    }

    @Override
    public Map<String, Object> sendResetPasswordCode(String phoneNumber) {
        return getCode(phoneNumber, false);
    }

    @Override
    public boolean checkRegisterCode(String phoneNumber, String code) {
        return checkCode(phoneNumber, code);
    }

    @Override
    public boolean checkResetPasswordCode(String phoneNumber, String code) {
        return checkCode(phoneNumber, code);
    }

    public boolean checkCode(String phoneNumber, String code) {

        String codeKey = phoneNumber + "code";
        if (!jedisClient.exists(codeKey))
            return false;
        if (!jedisClient.get(codeKey).equals(code))
            return false;
        return true;

    }

    private Map<String, Object> getCode(String phoneNumber, boolean register) {

        String countKey = phoneNumber + "count";
        String codeKey = phoneNumber + "code";

        Map<String, Object> map = new HashMap<>();
        boolean flg = false;
        try {
            flg = jedisClient.exists(countKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (flg) {

            int count = Integer.parseInt(jedisClient.get(countKey));
            if (count >= 5) {

                map.put("state", "1");
                map.put("msg", "一个手机一天只能发送5次");

            } else {

                map.put("code", sendCode(phoneNumber, register));
                jedisClient.incr(countKey);
                map.put("state", "0");
            }
            return map;
        } else {
            map.put("code", sendCode(phoneNumber, true));
            jedisClient.set(countKey, "1");
            jedisClient.expire(countKey, 86400);
            map.put("state", "0");
            return map;
        }
    }

    private String sendCode(String phoneNumber, boolean register) {
        String code = null, codeKey = phoneNumber + "code";
        try {
            if (register) {
                code = PhoneCodeUtils.sendLoginCode(phoneNumber,really);
            } else {
                code = PhoneCodeUtils.sendRepwdCode(phoneNumber, really);
            }
        } catch (Exception e) {
            bugRobot.sendErrorToDD(e, "13567557892");
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        jedisClient.set(codeKey, code);
        jedisClient.expire(codeKey, 300);
        return code;
    }
}
