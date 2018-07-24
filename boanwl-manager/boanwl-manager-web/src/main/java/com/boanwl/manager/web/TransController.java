package com.boanwl.manager.web;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.pojo.dto.PageParam;
import com.boanwl.manager.pojo.po.TbTrans;
import com.boanwl.manager.service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @date 2018/7/23 22:37
 * @since jiangjun
 */
@Controller
public class TransController {
    @Autowired
    private TransService transService;
    /**
     * 条件查询订单流水记录*/
    @RequestMapping("/selectOrder")
    @ResponseBody
    public ItemDTO<TbTrans> selectOrder(String orderNum , PageParam pageParam){
        ItemDTO <TbTrans> transList= transService.selectOrder(orderNum,pageParam);
        return transList;
    }
    /**
     * 展示所有订单流水记录*/
    @RequestMapping("/showOrder")
    @ResponseBody
    public ItemDTO<TbTrans> showOrder(){
        ItemDTO <TbTrans> transList= transService.showOrder();
        return transList;
    }
    /**
     * 添加一条流水记录
     * */
    @RequestMapping("/saveMsg")
    @ResponseBody
    public Map<String,Object> saveTrans(){

        return null;
    }
    /**
     * 修改一条流水记录
     * */
    @RequestMapping("/modifyTrans")
    @ResponseBody
    public Map<String,Object> modifyTrans(){

        return null;
    }
    /**
     * 删除一条流水记录
     * */
    @RequestMapping("/delTrans")
    @ResponseBody
    public Map<String,Object> delTrans(){

        return null;
    }

}
