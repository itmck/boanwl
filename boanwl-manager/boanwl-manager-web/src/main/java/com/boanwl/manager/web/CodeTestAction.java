package com.boanwl.manager.web;

import com.boanwl.manager.service.boan.PhoneCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * User: Boan
 * Date: 2018/7/28
 * Time: 9:34
 * Version:V1.0
 */
@Controller
public class CodeTestAction {

    @Autowired
    private PhoneCodeService phoneCodeService;

    @ResponseBody
    @GetMapping("/test/{phoneNumber}")
    public Map<String,Object> testCode(@PathVariable String phoneNumber) {
        return phoneCodeService.sendRegisterCode(phoneNumber);
    }

    @GetMapping("/test/{phoneNumber}/{code}")
    @ResponseBody
    public String checkCode(@PathVariable String phoneNumber,@PathVariable String code) {
        if (phoneCodeService.checkRegisterCode(phoneNumber,code))
            return "0";
        return "1";
    }

}
