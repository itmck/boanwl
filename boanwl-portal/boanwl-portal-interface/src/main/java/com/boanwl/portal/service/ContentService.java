package com.boanwl.portal.service;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.portal.pojo.po.TbMsg;
import com.boanwl.portal.pojo.po.TbResp;

/**
 * Create by it_mck 2018/8/6 20:11
 *
 * @Description:
 * @Version: 1.0
 */
public interface ContentService {
    /**
     * 客户留言
     * @param tbMsg
     * @return
     */
    int insertContent(TbMsg tbMsg);

    /**
     *
     * 留言信息查询

     * @param utel
     */
    ItemDTO<TbResp> queryContent(String utel);


    /**
     *
     * 查询是否存在此手机号的留言
     * @param utel
     * @return
     */
    int queryUtel(String utel);
}
