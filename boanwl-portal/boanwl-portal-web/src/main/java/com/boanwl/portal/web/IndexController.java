package com.boanwl.portal.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: volker
 * Date: 2018/7/18
 * Time: 19:38
 * Version:V1.0
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public  String zero(){
        return "homepage";
    }
    //@GetMapping("/homepage")
    public String one(){
        return "homepage";
    }
    @RequestMapping(value="/pages/{page1}",method = {RequestMethod.GET})
    public String two(@PathVariable("page1")String page1){
        return "pages/"+page1;
    }
    @RequestMapping(value="/pages/{page1}/{page2}",method = {RequestMethod.GET})
    public String three(@PathVariable("page1")String page1,@PathVariable("page2")String page2){
        return "pages/"+page1+"/"+page2;
    }
    @RequestMapping(value="/logout",method = {RequestMethod.GET})
    public String logout( ){
        //清除session记录
        return "login";
    }

}
