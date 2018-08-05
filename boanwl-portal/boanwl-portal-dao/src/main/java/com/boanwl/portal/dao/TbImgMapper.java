package com.boanwl.portal.dao;

import com.boanwl.portal.pojo.po.TbImg;
import com.boanwl.portal.pojo.po.TbImgExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbImgMapper {
    int countByExample(TbImgExample example);

    int deleteByExample(TbImgExample example);

    int insert(TbImg record);

    int insertSelective(TbImg record);

    List<TbImg> selectByExample(TbImgExample example);

    int updateByExampleSelective(@Param("record") TbImg record, @Param("example") TbImgExample example);

    int updateByExample(@Param("record") TbImg record, @Param("example") TbImgExample example);
}