package com.boanwl.manager.service.impl;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.pojo.dto.NewsQueryDTO;
import com.boanwl.manager.pojo.po.TbNews;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

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
        TbNews tbNews = new TbNews();
        newsService.saveNews(tbNews);

    }

    @Test
    public void updateNewsByNid() throws Exception {
        newsService.updateNewsByNid("10");

    }

    @Test
    public void updateNewsByNids() throws Exception {
    }

    @Test
    public void updateNews() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("10");
        newsService.updateNewsByNids(list);
    }

    @Test
    public void listNews() throws Exception {
        NewsQueryDTO newsQueryDTO = new NewsQueryDTO();
//        newsQueryDTO.setTitle("关于");
        newsQueryDTO.setLimit(100);
        newsQueryDTO.setPage(1);
        ItemDTO<TbNews> tbNewsItemDTO = newsService.listNews(newsQueryDTO);



    }

    @Test
    public void getNews() throws Exception {
    }

}