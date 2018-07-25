package com.boanwl.manager.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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


    }

    @Test
    public void updateSendBySids()  {

    }

    @Test
    public void updateSendBySid() throws Exception {

    }

    @Test
    public void updateSend() throws Exception {
    }

    @Test
    public void listSends() throws Exception {

    }

    @Test
    public void getSend() throws Exception {
    }

}