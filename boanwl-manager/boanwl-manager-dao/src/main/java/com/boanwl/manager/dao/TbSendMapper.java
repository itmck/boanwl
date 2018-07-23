package com.boanwl.manager.dao;

import com.boanwl.manager.pojo.po.TbSend;
import com.boanwl.manager.pojo.po.TbSendExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSendMapper {
    int countByExample(TbSendExample example);

    int deleteByExample(TbSendExample example);

    int deleteByPrimaryKey(String seId);

    int insert(TbSend record);

    int insertSelective(TbSend record);

    List<TbSend> selectByExample(TbSendExample example);

    TbSend selectByPrimaryKey(String seId);

    int updateByExampleSelective(@Param("record") TbSend record, @Param("example") TbSendExample example);

    int updateByExample(@Param("record") TbSend record, @Param("example") TbSendExample example);

    int updateByPrimaryKeySelective(TbSend record);

    int updateByPrimaryKey(TbSend record);
}