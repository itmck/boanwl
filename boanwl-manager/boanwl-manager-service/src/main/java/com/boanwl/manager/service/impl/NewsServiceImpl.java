package com.boanwl.manager.service.impl;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.dao.NewsMapper;
import com.boanwl.manager.dao.TbNewsMapper;
import com.boanwl.manager.pojo.dto.NewsQueryDTO;
import com.boanwl.manager.pojo.po.TbNews;
import com.boanwl.manager.pojo.po.TbNewsExample;
import com.boanwl.manager.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * User: Boan
 * Date: 2018/7/24
 * Time: 19:08
 * Version:V1.0
 */
@Service
public class NewsServiceImpl implements NewsService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public TbNewsMapper tbNewsMapper;
    @Autowired
    NewsMapper newsMapper;

    @Override
    public int saveNews(TbNews tbNews) {
        int i = 0;
        try {
            tbNews.setId(UUID.randomUUID().toString().replace("-", ""));
            tbNews.setStatus(0);
            i = tbNewsMapper.insertSelective(tbNews);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }

    @Override
    public int updateNewsByNid(String nid) {

        int i = 0;
        try {
            TbNews tbNews = tbNewsMapper.selectByPrimaryKey(nid);
            tbNews.setStatus(1);
            i = tbNewsMapper.updateByPrimaryKeySelective(tbNews);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int updateNewsByNids(List<String> nids) {
        int i = 0;
        try {
            TbNews tbNews = new TbNews();
            tbNews.setStatus(1);
            TbNewsExample tbNewsExample = new TbNewsExample();
            tbNewsExample.createCriteria().andIdIn(nids);
            i = tbNewsMapper.updateByExampleSelective(tbNews, tbNewsExample);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int updateNews(TbNews tbNews) {
        int i = 0;
        try {
            i = tbNewsMapper.updateByPrimaryKeySelective(tbNews);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ItemDTO<TbNews> listNews(NewsQueryDTO newsQueryDTO) {

        ItemDTO<TbNews> item = new ItemDTO<>();
        try {
            item.setCount(newsMapper.countNews(newsQueryDTO));
            item.setData(newsMapper.listNews(newsQueryDTO));
            item.setCode(0);
        } catch (Exception e) {
            e.printStackTrace();
            item.setCode(1);
        }
        return item;
    }

    @Override
    public TbNews getNews(String nid) {

        try {
            return tbNewsMapper.selectByPrimaryKey(nid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
