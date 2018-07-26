package com.boanwl.manager.web;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.pojo.dto.PageParam;
import com.boanwl.manager.pojo.dto.TransRespDto;
import com.boanwl.manager.pojo.po.TbSend;
import com.boanwl.manager.pojo.po.TbTrans;
import com.boanwl.manager.service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @date 2018/7/23 22:37
 * @since jiangjun
 */
@Controller
public class TransController {
    @Autowired
    private TransService transService;
   /* *//**
     * 条件查询订单流水记录ok*//*
    @RequestMapping("/selectOrder")
    @ResponseBody
    public ItemDTO<TbTrans> selectOrder(String orderNum , PageParam pageParam){
        ItemDTO <TbTrans> transList= transService.selectOrder(orderNum,pageParam);
        return transList;
    }*/
    /**
     * 展示所有订单流水记录ok*/
    @RequestMapping("/showOrder")
    @ResponseBody
    public ItemDTO<TransRespDto> showOrder(String orderNum , PageParam pageParam){
        ItemDTO <TransRespDto> transList;
        if(orderNum==null||orderNum.equals("")){
            transList= transService.showOrder();
        }else {
           transList= transService.selectOrder(orderNum,pageParam);
        }
        //ItemDTO <TransRespDto> transList= transService.showOrder();
        return transList;
    }
    /**
     * 添加一条初始状态的记录，从寄件处获得订单号给牛牛
     * */
    @RequestMapping("/saveOneMsg")
    public String saveOneMsg(TbSend tbSend, HttpSession session){
        long result=transService.saveOneMsg(tbSend);
        String orderNum = tbSend.getSeId();
        return "redirect:/showOrder";
    }
    /**
     * 点击订单按钮获得订单号用于添加页面订单号回显，然后快递员添加流转信息
     * */
    @RequestMapping("/getOrderNum")
    @ResponseBody
    public Map<String,Object> getOrderNum(@RequestParam("orderNum") String orderNum, HttpSession session){
        //System.out.println(orderNum);
        session.setAttribute("orderNum",orderNum);
        Map<String,Object> map = new HashMap<>();
        map.put("orderNum","orderNum");
        return map;
    }
    /**
     * 添加一条流水记录不是初始状态的记录
     * */
    @RequestMapping("/saveTrans")
    @ResponseBody
    public Map<String,Object> saveTrans(TbTrans trans){
        transService.saveTrans(trans);
        return null;
    }

    /**
     * 修改一条流水记录之前查询出当前记录的信息
     * */
    @RequestMapping("/getTrans")
    @ResponseBody
    public Map<String,Object> getTrans(String id, HttpSession session){
        TbTrans trans=transService.getTrans(id);
        session.setAttribute("trans",trans);
        return null;
    }
    /**
     * 修改一条流水记录
     * */
    @RequestMapping("/modifyTrans")
    @ResponseBody
    public String modifyTrans(TbTrans trans){
        long result=transService.modifyTrans(trans);
        return "回到显示所有记录的页面";
    }


}
