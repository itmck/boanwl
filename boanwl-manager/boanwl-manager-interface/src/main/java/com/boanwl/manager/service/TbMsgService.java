package com.boanwl.manager.service;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.pojo.dto.PageParam;
import com.boanwl.manager.pojo.vo.TbMsgCustom;

/**
 * @author it_mck 2018/7/24 20:43
 * @ version 1.0
 */
public interface TbMsgService {
    ItemDTO<TbMsgCustom> getRequestList(PageParam pageParam);
}
