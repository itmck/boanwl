package com.boanwl.portal.dao;

import com.boanwl.common.dto.NewsSlorDTO;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: Boan
 * Date: 2018/8/5
 * Time: 15:34
 * Version:V1.0
 */
@Repository
public class NewsSerachDao {

    @Autowired
    private SolrServer solrServer;
    public NewsSlorDTO search(SolrQuery query) throws Exception {
        //根据query查询索引库
        QueryResponse queryResponse = solrServer.query(query);
        //取查询结果。
        SolrDocumentList solrDocumentList = queryResponse.getResults();

        NewsSlorDTO dto = new NewsSlorDTO();
        //取查询结果总记录数
        dto.setNumFound(solrDocumentList.getNumFound()); ;

        List<NewsSlorDTO.DocsBean> dosc = new ArrayList<>();

        for (SolrDocument solrDocument : solrDocumentList) {
            NewsSlorDTO.DocsBean item = new NewsSlorDTO.DocsBean();
            item.setId((String) solrDocument.get("id"));
            item.setNews_title((String) solrDocument.get("news_title"));
            item.setNews_content((String) solrDocument.get("news_content"));
            item.setNews_image((String) solrDocument.get("news_image"));
            item.setNews_time((Date) solrDocument.get("news_time"));

            //添加到商品列表
            dosc.add(item);
        }
        dto.setDocs(dosc);
        //返回结果
        return dto;
    }
}
