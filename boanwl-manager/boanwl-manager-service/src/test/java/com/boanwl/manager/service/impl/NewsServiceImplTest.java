package com.boanwl.manager.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: Boan
 * Date: 2018/7/24
 * Time: 19:40
 * Version:V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*servicetest.xml")
public class NewsServiceImplTest {

    @Autowired
    private NewsServiceImpl newsService;

    @Test
    public void saveNews() throws Exception {

    }

    @Test
    public void updateNewsByNid() throws Exception {


    }

    @Test
    public void updateNewsByNids() throws Exception {
    }

    @Test
    public void updateNews() throws Exception {

    }

    @Test
    public void listNews() throws Exception {




    }

    @Test
    public void getNews() throws Exception {
    }

}