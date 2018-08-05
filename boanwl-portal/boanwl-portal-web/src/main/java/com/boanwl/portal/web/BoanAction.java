package com.boanwl.portal.web;

import com.boan.comcom.utils.WeatherUtils;
import com.boanwl.common.dto.CityDTO;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * User: Boan
 * Date: 2018/8/5
 * Time: 22:37
 * Version:V1.0
 */
@Controller
public class BoanAction {


    @GetMapping(value = "/weather",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getWeather() {
        try {
            String city = java.net.URLEncoder.encode("杭州", "utf-8");
            String apiUrl = String.format("https://www.sojson.com/open/api/weather/json.shtml?city=%s", city);
            URL url = new URL(apiUrl);
            URLConnection open = url.openConnection();
            InputStream input   = open.getInputStream();
            return IOUtils.toString(input, "utf-8");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/city/{ip}")
    @ResponseBody
    public CityDTO getCity(@PathVariable  String ip) {
        return WeatherUtils.getCityByid(ip);
    }

}
