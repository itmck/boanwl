package com.boanwl.portal.service.impl;

import com.boanwl.common.dto.NewsSlorDTO;
import com.boanwl.portal.dao.NewsSerachDao;
import com.boanwl.portal.service.NewsService;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Boan
 * Date: 2018/8/5
 * Time: 15:54
 * Version:V1.0
 */
@Service
public class NewsServiceImpl implements NewsService{

    @Autowired
    NewsSerachDao newsSerachDao;


    @Override
    public NewsSlorDTO search(String keyword, int page, int rows) throws Exception {

        //创建一个SolrQuery对象
        SolrQuery query = new SolrQuery();
        //设置查询条件
        query.setQuery(keyword);
        //设置分页条件
        query.setStart((page - 1) * rows);
        query.setRows(rows);
        //设置默认搜索域
        query.set("df", "news_keywords");
        NewsSlorDTO searchDto = newsSerachDao.search(query);
        int total = (int) ((searchDto.getNumFound() - page + 1)/rows);
        searchDto.setTotalpage(total);
        searchDto.setPage(page);
        return searchDto;
    }
}
