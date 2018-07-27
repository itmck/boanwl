package com.boanwl.manager.service;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.pojo.dto.PageParam;
import com.boanwl.manager.pojo.dto.TbQueryDTO;
import com.boanwl.manager.pojo.po.TbResp;
import com.boanwl.manager.pojo.vo.TbMsgCustom;

import java.util.List;

/**
 * @author it_mck 2018/7/24 20:43
 * @ version 1.0
 */
public interface TbMsgService {
    //查询
    ItemDTO<TbMsgCustom> getRequestList(PageParam pageParam, TbQueryDTO tbQueryDTO);

    //回复
    int respMsg(TbResp tbResp);

    //批量回复
    int mulResp(List<String> ids);
}
