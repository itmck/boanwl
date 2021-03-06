package com.boanwl.manager.dao;

import com.boanwl.manager.pojo.dto.PageParam;
import com.boanwl.manager.pojo.dto.TransRespDto;
import com.boanwl.manager.pojo.po.TbTrans;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @date 2018/7/24 13:38
 * @since jiangjun
 */
public interface transMapper {
    List<TransRespDto> showOrder();

    long showcount();

    long counttrans(@Param("orderNum")String orderNum);

    List<TransRespDto> selectOrder(@Param("orderNum") String orderNum, @Param("pageParam") PageParam pageParam);

    TbTrans getTrans(String id);

    long modifyTrans( @Param("tbTrans") TbTrans tbTrans);

    TbTrans selectById(@Param("id") String id);
}
