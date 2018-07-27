package com.boanwl.manager.service.impl.boan;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.boan.comcom.utils.BugRobot;
import com.boan.jedis.JedisClient;
import com.boanwl.manager.service.boan.PhoneCodeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: Boan
 * Date: 2018/7/26
 * Time: 22:34
 * Version:V1.0
 */
public class PhoneCodeServiceImpl implements PhoneCodeService {

    @Autowired
    private JedisClient jedisClient;

    private BugRobot bugRobot = new BugRobot();
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public String sendCode(String ip, String phoneNumber) {

        String count = jedisClient.hget(ip, phoneNumber);

        return null;
    }
}
