package com.boanwl.manager.web;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.pojo.dto.SendQueryDTO;
import com.boanwl.manager.pojo.po.TbSend;
import com.boanwl.manager.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Boan
 * Date: 2018/7/23
 * Time: 17:05
 * Version:V1.0
 */
@Controller
@RequestMapping("/send")
public class SendAction {

    @Autowired
    SendService sendService;

    /**
     * 插入一条记录
     * @param send
     * @return
     */
    @ResponseBody
    @PostMapping("/save")
    public Object saveSend(TbSend send) {

        Map<String ,Object> map  = new HashMap<>();
        try {
           int  i =  sendService.saveSend(send);
           map.put("save_code","0");
        }catch (Exception e) {
            map.put("save_code","1");
            e.printStackTrace();
        }
        return map ;
    }

    /**
     * 批量删除表面删除
     * @param sids
     * @return
     */
    @PutMapping("/updateIds")
    @ResponseBody
    public Object updateSendBySids( @RequestParam("sids[]") List<String> sids ) {

        Map<String ,Object> map  = new HashMap<>();
        try {
            int  i =  sendService.updateSendBySids(sids);
            map.put("update_code","0");
        }catch (Exception e) {
            map.put("update_code","1");
            e.printStackTrace();
        }
        return map ;
    }

    /**
     *单个删除某个寄件单
     * @param sid
     * @return
     */
    @PutMapping("/update/{sid}")
    @ResponseBody
    public Object updateSendBySid(@PathVariable String sid) {
        Map<String ,Object> map  = new HashMap<>();
        try {
            int  i = sendService.updateSendBySid(sid);
            map.put("update_code","0");
        }catch (Exception e) {
            map.put("update_code","1");
            e.printStackTrace();
        }
        return map ;
    }


    /**
     * 修改寄件信息
     * @param tbSend
     * @return
     */
    @PutMapping("/update")
    @ResponseBody
    public Object updateSend(TbSend tbSend) {
        Map<String ,Object> map  = new HashMap<>();
        try {
            int  i =  sendService.updateSend(tbSend);
            map.put("update_code","0");
        }catch (Exception e) {
            map.put("update_code","1");
            e.printStackTrace();
        }
        return map ;
    }

    /**
     * 根据条件分页查询
     * @param sendQueryDTO
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public ItemDTO<TbSend> listSends(SendQueryDTO sendQueryDTO) {

        ItemDTO<TbSend> tbSendItemDTO = null;
        try {
            tbSendItemDTO = sendService.listSends(sendQueryDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbSendItemDTO;
    }
    @RequestMapping("/{sid}")
    @ResponseBody
    public TbSend getSend(@PathVariable  String sid) {

        try{
            return sendService.getSend(sid);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
