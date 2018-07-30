package com.boan.exp;

/**
 * User: Boan
 * Date: 2018/7/30
 * Time: 20:23
 * Version:V1.0
 */
public class RedisFirstConnectException extends RuntimeException{

    public RedisFirstConnectException() {
        super("第一次链接redis总是超时");
    }
    public RedisFirstConnectException(String msg) {
        super(msg);
    }
}
