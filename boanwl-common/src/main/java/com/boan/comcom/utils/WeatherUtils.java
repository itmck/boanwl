package com.boan.comcom.utils;

import com.boanwl.common.dto.CityDTO;
import com.dhc.util.JsonUtils;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * User: Boan
 * Date: 2018/7/29
 * Time: 21:51
 * Version:V1.0
 */
public class WeatherUtils {

    public static String getWeatherJson(String ip) {

        try {
            String cityInput = getCityByid(ip).getData().getCity();
            String city = java.net.URLEncoder.encode(cityInput, "utf-8");
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

    public static CityDTO getCityByid(String ip) {
        try {
            String apiUrl = String.format("http://ip.taobao.com/service/getIpInfo.php?ip=" + ip);
            URL url = new URL(apiUrl);
            URLConnection open = url.openConnection();
            InputStream input = open.getInputStream();
            return JsonUtils.jsonToPojo(IOUtils.toString(input, "utf-8"), CityDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
