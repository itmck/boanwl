package com.boanwl.manager.service;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.pojo.dto.SendQueryDTO;
import com.boanwl.manager.pojo.po.TbSend;

import java.util.List; /**
 * User: Boan
 * Date: 2018/7/23
 * Time: 20:10
 * Version:V1.0
 */
public interface SendService {
    /**
     * 插入一条数据
     * @param send
     * @return
     */
    int saveSend(TbSend send);

    /**
     * 批量删除
     * @param sids
     * @return
     */
    int updateSendBySids(List<String> sids);

    /**
     * 单个删除
     * @param sid
     * @return
     */
    int updateSendBySid(String sid);

    /**
     * 更新
     * @param tbSend
     * @return
     */
    int updateSend(TbSend tbSend);

    /**
     * 分页查询
     * @param sendQueryDTO
     * @return
     */
    ItemDTO<TbSend> listSends(SendQueryDTO sendQueryDTO);

    /**
     *根据主键查询寄件所有信息
     * @return
     */
    TbSend getSend(String sid);
}
