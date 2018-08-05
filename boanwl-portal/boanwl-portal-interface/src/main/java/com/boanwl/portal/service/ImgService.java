package com.boanwl.portal.service;

import com.boanwl.portal.pojo.po.TbImg;

import java.util.List;

/**
 * @date 2018/8/3 1:34
 * @since jiangjun
 */
public interface ImgService {
    List<TbImg> getImgListById(Long imgid);
}
