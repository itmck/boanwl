package com.boanwl.manager.dao;

import com.boanwl.manager.pojo.po.TbResp;
import com.boanwl.manager.pojo.po.TbRespExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbRespMapper {
    int countByExample(TbRespExample example);

    int deleteByExample(TbRespExample example);

    int deleteByPrimaryKey(String respId);

    int insert(TbResp record);

    int insertSelective(TbResp record);

    List<TbResp> selectByExample(TbRespExample example);

    TbResp selectByPrimaryKey(String respId);

    int updateByExampleSelective(@Param("record") TbResp record, @Param("example") TbRespExample example);

    int updateByExample(@Param("record") TbResp record, @Param("example") TbRespExample example);

    int updateByPrimaryKeySelective(TbResp record);

    int updateByPrimaryKey(TbResp record);
}