package com.boanwl.manager.dao;

import com.boanwl.manager.pojo.dto.PageParam;
import com.boanwl.manager.pojo.po.TbTrans;

import java.util.List;

/**
 * @date 2018/7/24 13:38
 * @since jiangjun
 */
public interface transMapper {
    List<TbTrans> showOrder();

    long showcount();

    long counttrans(String orderNum);

    List<TbTrans> selectOrder(String orderNum, PageParam pageParam);
}
