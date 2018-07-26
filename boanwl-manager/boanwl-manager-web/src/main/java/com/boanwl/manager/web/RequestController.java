package com.boanwl.manager.web;


import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.pojo.dto.PageParam;
import com.boanwl.manager.pojo.dto.TbQueryDTO;
import com.boanwl.manager.pojo.po.TbResp;
import com.boanwl.manager.pojo.vo.TbMsgCustom;
import com.boanwl.manager.service.TbMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于获取用户留言信息
 *
 * @author it_mck 2018/7/24 20:34
 * @ version 1.0
 */
@Controller
@RequestMapping("/mck")
public class RequestController {

    @Autowired
    private TbMsgService tbMsgService;

    @RequestMapping("/getList2")
    @ResponseBody
    public ItemDTO<TbMsgCustom> getRequestList(PageParam pageParam, TbQueryDTO tbQueryDTO) {


        ItemDTO<TbMsgCustom> result = null;
        try {
            result = tbMsgService.getRequestList(pageParam, tbQueryDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return result;
    }

    @ResponseBody
    @RequestMapping("/resp")
    public Object respMsg(TbResp tbResp) {

        //接收前端发来的数据

        Map<String, Object> map = new HashMap<>();
        int i = 0;
        try {
            i = tbMsgService.respMsg(tbResp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i > 0) {
            //回复成功
            map.put("flg", 1);

        } else {
            //失败
            map.put("flg", 0);
        }
        return map;
    }


    @ResponseBody
    @RequestMapping("/mulResp")
    public Object mulResp(@RequestParam("ids[]") List<String> ids) {

        //测试
//        for (long id : ids) {
//            System.out.println(id);
        Map<String, Object> map = new HashMap<>();
//        }
        int i = 0;
        try {
            i = tbMsgService.mulResp(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (i > 0) {
            //回复成功
            map.put("flg", 1);

        } else {
            //失败
            map.put("flg", 0);
        }

        return map;
    }

}
