package com.boanwl.manager.dao;

import com.boanwl.manager.pojo.po.TbTrans;
import com.boanwl.manager.pojo.po.TbTransExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbTransMapper {
    int countByExample(TbTransExample example);

    int deleteByExample(TbTransExample example);

    int insert(TbTrans record);

    int insertSelective(TbTrans record);

    List<TbTrans> selectByExample(TbTransExample example);

    int updateByExampleSelective(@Param("record") TbTrans record, @Param("example") TbTransExample example);

    int updateByExample(@Param("record") TbTrans record, @Param("example") TbTransExample example);
}