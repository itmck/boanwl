package com.boanwl.portal.web;


import com.boanwl.portal.pojo.po.TbImg;
import com.boanwl.portal.service.ImgService;
import com.dhc.util.PropKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: DHC
 * Date: 2018/7/25
 * Time: 14:12
 * Version:V1.0
 */
@Controller
public class PortalIndexAction {

    @Autowired
    private ImgService imgService;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> index(HttpServletRequest request){
        //0 读取配置文件获取分类编号
        Map<String,Object> map = new HashMap<>();
       Long imgid = PropKit.use("index.properties").getLong("lubo.imgid");
        //1 调用业务层代码
        List<TbImg> imglist = imgService.getImgListById(imgid);
        map.put("imglist",imglist);
        /*//2 存放到request域中
        request.setAttribute("imgList",imglist);
        //3 转发*/
        return map;
    }
}
