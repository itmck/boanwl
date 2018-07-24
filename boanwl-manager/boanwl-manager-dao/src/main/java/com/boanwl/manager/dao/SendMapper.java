package com.boanwl.manager.dao;

import com.boanwl.manager.pojo.dto.SendQueryDTO;
import com.boanwl.manager.pojo.po.TbSend;

import java.util.List;

/**
 * User: Boan
 * Date: 2018/7/23
 * Time: 22:42
 * Version:V1.0
 */
public interface SendMapper {

    List<TbSend> listSends(SendQueryDTO sendQueryDTO);

    Long countSends(SendQueryDTO sendQueryDTO);
}
