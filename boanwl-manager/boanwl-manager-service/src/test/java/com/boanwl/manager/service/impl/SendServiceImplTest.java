package com.boanwl.manager.service.impl;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.pojo.dto.SendQueryDTO;
import com.boanwl.manager.pojo.po.TbSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Boan
 * Date: 2018/7/23
 * Time: 23:30
 * Version:V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*servicetest.xml")
public class SendServiceImplTest {
    @Autowired
    SendServiceImpl sendService;

    @Test
    public void saveSend() throws Exception {

        TbSend tbSend = new TbSend();
        tbSend.setCargoWeight(1.0);
        sendService.saveSend(tbSend);

    }

    @Test
    public void updateSendBySids()  {
        List<String> list = new ArrayList<>();
        list.add("SE1807220001");
        sendService.updateSendBySids(list);
    }

    @Test
    public void updateSendBySid() throws Exception {
        sendService.updateSendBySid("bc86030e808447d99d7dffce168bce89");
    }

    @Test
    public void updateSend() throws Exception {
    }

    @Test
    public void listSends() throws Exception {
        SendQueryDTO sendQueryDTO = new SendQueryDTO();
        sendQueryDTO.setLimit(10);
        sendQueryDTO.setPage(1);
        ItemDTO<TbSend> tbSendItemDTO = sendService.listSends(sendQueryDTO);
        System.out.println("ok");
    }

    @Test
    public void getSend() throws Exception {
    }

}