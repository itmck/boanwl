package com.boanwl.manager.dao;

import com.boanwl.manager.pojo.dto.PageParam;
import com.boanwl.manager.pojo.vo.TbMsgCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbMsgCustomMapper extends TbMsgMapper {

    //查询总留言个数
    long getCounts();

    //查询总的data数据
    List<TbMsgCustom> getTbMsg(PageParam pageParam);
}