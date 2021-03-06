package com.boanwl.manager.service.impl;

import com.boan.comcom.utils.BugRobot;
import com.boan.comcom.utils.OrderNumberUtils;
import com.boan.jedis.JedisClient;
import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.dao.SendMapper;
import com.boanwl.manager.dao.TbSendMapper;
import com.boanwl.manager.pojo.dto.SendQueryDTO;
import com.boanwl.manager.pojo.po.TbSend;
import com.boanwl.manager.pojo.po.TbSendExample;
import com.boanwl.manager.service.SendService;
import com.dhc.util.JsonUtils;
import com.dhc.util.StrKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

//import com.boanwl.manager.pojo.dto.SendQueryDTO;
//import com.boanwl.manager.pojo.po.TbSend;
//import com.boanwl.manager.pojo.po.TbSendExample;

/**
 * User: Boan
 * Date: 2018/7/23
 * Time: 20:11
 * Version:V1.0
 */
@Service
public class SendServiceImpl implements SendService {

    @Autowired
    private JedisClient jedisClient;

    private BugRobot bugRobot = new BugRobot();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TbSendMapper tbSendMapper;
    @Autowired
    SendMapper sendMapper;

    @Override
    public int saveSend(TbSend send) {
        int i = 0;
        try {
            send.setSeId(OrderNumberUtils.getSendID());
            double price = 0.0;
            double weight = send.getCargoWeight();
            if (weight <= 1.0) {
                price = 7.0;
            } else if (weight <= 10.0) {
                price = 20;
            }
            send.setTotalPrice(price);
            send.setOrderCrateData(new Date());
            send.setSeState("0");
            i = tbSendMapper.insert(send);
        } catch (Exception e) {
            bugRobot.sendErrorToDD(e);
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int updateSendBySids(List<String> sids) {
        int i = 0;
        try {
            TbSend tbSend = new TbSend();
            tbSend.setSeState("1");
            TbSendExample tbSendExample = new TbSendExample();
            tbSendExample.createCriteria().andSeIdIn(sids);
            i = tbSendMapper.updateByExampleSelective(tbSend, tbSendExample);

        } catch (Exception e) {
            bugRobot.sendErrorToDD(e);
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int updateSendBySid(String sid) {
        int i = 0;
        try {

            TbSend tbSend = tbSendMapper.selectByPrimaryKey(sid);
            tbSend.setSeState("1");
            tbSendMapper.updateByPrimaryKeySelective(tbSend);

        } catch (Exception e) {

            bugRobot.sendErrorToDD(e);
            logger.error(e.getMessage(), e);
            e.printStackTrace();

        }
        return i;

    }

    @Override
    public int updateSend(TbSend tbSend) {
        return tbSendMapper.updateByPrimaryKeySelective(tbSend);
    }

    @Override
    public ItemDTO<TbSend> listSends(SendQueryDTO sendQueryDTO) {

        ItemDTO<TbSend> tbSendItemDTO = new ItemDTO<>();
        try {

            tbSendItemDTO.setCode(0);
            tbSendItemDTO.setData(sendMapper.listSends(sendQueryDTO));
            tbSendItemDTO.setCount(sendMapper.countSends(sendQueryDTO));

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            bugRobot.sendErrorToDD(e);
            tbSendItemDTO.setCode(1);
        }
        return tbSendItemDTO;
    }

    @Override
    public TbSend getSend(String sid) {

        TbSend tbSend = null;

        // 先到jdeis查
        try {
            String json = jedisClient.hget("send", sid);
            if (StrKit.notBlank(json)) {
                jedisClient.expire("send", 60 * 3600 * 30);
                return JsonUtils.jsonToPojo(json, TbSend.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //从数据库中查询
        try {

            tbSend = tbSendMapper.selectByPrimaryKey(sid);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            bugRobot.sendErrorToDD(e);
        }

        //存到jedis中
        try {
            jedisClient.hset("send", sid, JsonUtils.objectToJson(tbSend));
            jedisClient.expire("send", 60 * 3600 * 30);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return tbSend;
    }
}
