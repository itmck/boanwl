package com.boanwl.manager.dao;

import com.boanwl.manager.pojo.dto.NewsQueryDTO;
import com.boanwl.manager.pojo.po.TbNews;

import java.util.List;

/**
 * User: Boan
 * Date: 2018/7/24
 * Time: 19:22
 * Version:V1.0
 */
public interface NewsMapper {

    long countNews(NewsQueryDTO newsQueryDTO);

    List<TbNews> listNews(NewsQueryDTO newsQueryDTO);

}
