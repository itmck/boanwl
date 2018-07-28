package com.boanwl.manager.service.boan;

import java.util.Map;

/**
 * User: Boan
 * Date: 2018/7/26
 * Time: 22:31
 * Version:V1.0
 */

public interface PhoneCodeService {

    Map<String ,Object> sendRegisterCode(String phoneNumber);
    Map<String ,Object> sendResetPasswordCode(String phoneNumber);
    boolean checkRegisterCode(String phoneNumber,String code);
    boolean checkResetPasswordCode(String phoneNumber,String code);

}
