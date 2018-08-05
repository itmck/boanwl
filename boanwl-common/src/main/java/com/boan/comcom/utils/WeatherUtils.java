package com.boan.comcom.utils;

import com.boanwl.common.dto.CityDTO;
import com.dhc.util.JsonUtils;
import org.apache.commons.io.IOUtils;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

/**
 * User: Boan
 * Date: 2018/7/29
 * Time: 21:51
 * Version:V1.0
 */
public class WeatherUtils {

    public static String getWeatherJson(HttpServletRequest request) {

     /*   String ip = getIp(request);
        ip = "116.62.242.123";
        try {
            String cityInput = getCityByid(ip).getData().getCity();
            String city = java.net.URLEncoder.encode("杭州", "utf-8");

            String apiUrl = String.format("https://www.sojson.com/open/api/weather/json.shtml?city=%s", city);
            URL url = new URL(apiUrl);
            URLConnection open = url.openConnection();
            InputStream input   = open.getInputStream();
            return IOUtils.toString(input, "utf-8");


        } catch (IOException e) {
            e.printStackTrace();*/
            return null;
//        }

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
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if(ip.equals("127.0.0.1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ip= inet.getHostAddress();
            }
        }
        // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ip != null && ip.length() > 15){
            if(ip.indexOf(",")>0){
                ip = ip.substring(0,ip.indexOf(","));
            }
        }
        return ip;
    }

    public static void main(String[] args) {
        System.out.println(getWeatherJson(null));
    }


}
