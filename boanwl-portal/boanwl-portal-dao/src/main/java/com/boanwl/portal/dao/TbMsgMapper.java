package com.boanwl.portal.dao;

import com.boanwl.portal.pojo.po.TbMsg;
import com.boanwl.portal.pojo.po.TbMsgExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbMsgMapper {
    int countByExample(TbMsgExample example);

    int deleteByExample(TbMsgExample example);

    int deleteByPrimaryKey(String orderNo);

    int insert(TbMsg record);

    int insertSelective(TbMsg record);

    List<TbMsg> selectByExample(TbMsgExample example);

    TbMsg selectByPrimaryKey(String orderNo);

    int updateByExampleSelective(@Param("record") TbMsg record, @Param("example") TbMsgExample example);

    int updateByExample(@Param("record") TbMsg record, @Param("example") TbMsgExample example);

    int updateByPrimaryKeySelective(TbMsg record);

    int updateByPrimaryKey(TbMsg record);
}