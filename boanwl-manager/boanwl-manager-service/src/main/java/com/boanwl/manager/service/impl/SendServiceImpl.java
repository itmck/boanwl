package com.boanwl.manager.service.impl;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.dao.TbSendMapper;
import com.boanwl.manager.pojo.dto.SendQueryDTO;
import com.boanwl.manager.pojo.po.TbSend;
import com.boanwl.manager.service.SendService;
import org.apache.activemq.kaha.impl.data.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * User: Boan
 * Date: 2018/7/23
 * Time: 20:11
 * Version:V1.0
 */
@Service
public class SendServiceImpl implements SendService {

    @Autowired
    TbSendMapper tbSendMapper;

    @Override
    public int saveSend(TbSend send) {
        send.setSeId(UUID.randomUUID().toString().replaceAll("-",""));
        double price  = 0.0;
        double weight  = send.getCargoWeight();
        if (weight <= 1.0) {
            price = 7.0;
        }else if(weight <=10.0){
            price = 20;
        }
        send.setTotalPrice(price);
        send.setOrderCrateData(new Date());
        return tbSendMapper.insert(send);
    }

    @Override
    public int updateSendBySids(List<String> sids) {
        return 0;
    }

    @Override
    public int updateSendBySid(String sid) {
        return 0;
    }

    @Override
    public int updateSend(TbSend tbSend) {
        return 0;
    }

    @Override
    public ItemDTO<TbSend> listSends(SendQueryDTO sendQueryDTO) {

        ItemDTO<TbSend> tbSendItemDTO = new ItemDTO<>();
        try{
            tbSendItemDTO.setCode(0);
           tbSendItemDTO.setData(tbSendMapper.selectByExample(null));
           tbSendItemDTO.setCount(1);
        }catch (Exception e) {
            tbSendItemDTO.setCode(1);
        }
        return tbSendItemDTO;
    }

    @Override
    public TbSend getSend(String sid) {
        return null;
    }
}
