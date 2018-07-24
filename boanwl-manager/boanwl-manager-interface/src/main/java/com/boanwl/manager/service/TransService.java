package com.boanwl.manager.service;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.pojo.dto.PageParam;
import com.boanwl.manager.pojo.po.TbTrans;

/**
 * @date 2018/7/24 12:21
 * @since jiangjun
 */

public interface TransService {


    ItemDTO<TbTrans> selectOrder(String orderNum, PageParam pageParam);

    ItemDTO<TbTrans> showOrder();
}
