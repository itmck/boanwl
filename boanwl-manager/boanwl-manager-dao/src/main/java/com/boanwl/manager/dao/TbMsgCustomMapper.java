package com.boanwl.manager.dao;

import com.boanwl.manager.pojo.vo.TbMsgCustom;

import java.util.List;
import java.util.Map;

public interface TbMsgCustomMapper extends TbMsgMapper {

    //查询总留言个数
    long getCounts( Map<String,Object> map);

    //查询总的data数据
    List<TbMsgCustom> getTbMsg(Map<String,Object> map);
}