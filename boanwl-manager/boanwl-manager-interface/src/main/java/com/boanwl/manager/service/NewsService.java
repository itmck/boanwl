package com.boanwl.manager.service;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.pojo.dto.NewsQueryDTO;
import com.boanwl.manager.pojo.po.TbNews;

import java.util.List; /**
 * User: Boan
 * Date: 2018/7/24
 * Time: 19:07
 * Version:V1.0
 */
public interface NewsService {
    String saveNews(TbNews tbNews);

    int updateNewsByNid(String nid);

    int updateNewsByNids(List<String> nids);

    int updateNews(TbNews tbNews);

    ItemDTO<TbNews> listNews(NewsQueryDTO newsQueryDTO);

    TbNews getNews(String nid);
}
