package com.boanwl.manager.web;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.pojo.dto.PageParam;
import com.boanwl.manager.pojo.vo.TbMsgCustom;
import com.boanwl.manager.service.TbMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用于获取用户留言信息
 *
 * @author it_mck 2018/7/24 20:34
 * @ version 1.0
 */
@Controller
public class RequestController {

    @Autowired
    private TbMsgService tbMsgService;

    @RequestMapping("/getList2")
    @ResponseBody
    public ItemDTO<TbMsgCustom> getRequestList(PageParam pageParam){


        ItemDTO<TbMsgCustom> result = null;
        try {
            result = tbMsgService.getRequestList(pageParam);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return result;
    }

}
