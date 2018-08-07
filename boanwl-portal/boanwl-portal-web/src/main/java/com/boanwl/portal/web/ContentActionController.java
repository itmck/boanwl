package com.boanwl.portal.web;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.portal.pojo.po.TbMsg;
import com.boanwl.portal.pojo.po.TbResp;
import com.boanwl.portal.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by it_mck 2018/8/6 20:01
 *
 * @Description:留言
 * @Version: 1.0
 */
@Controller
@RequestMapping("/mck")
public class ContentActionController {

    @Autowired
    private ContentService contentService;

    /**
     * 插入留言信息
     *
     * @param tbMsg :接收前台传来的数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Map<String, Object> insertContent(TbMsg tbMsg) {

        Map<String, Object> map = new HashMap<>();

        int i = 0;
        try {
            i = contentService.insertContent(tbMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (i > 0) {
            //留言成功
            map.put("flg", 1);
        } else {
            //留言失败
            map.put("flg", 0);
        }

        return map;

    }

    /**
     * 根据手机号查询留言回复信息
     *
     * @param utel
     * @return
     */
//http://localhost:8282/boanwl/mck/query?utel=178654345
    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ItemDTO<TbResp> queryContent(String utel) {
        System.out.println(utel);
        ItemDTO<TbResp> result = new ItemDTO<>();
        int i=0;
        try {
            //先去数据库查询是否存在此手机号
            i = contentService.queryUtel(utel);
            if (i == 0) {
                //不存在此手机号的留言
                result.setCode(-1);
                result.setData(null);
                return result;
            }else{
                //存在此手机号的留言,去数据句库查询
                result = contentService.queryContent(utel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
