package com.boanwl.manager.service.impl;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.dao.TbMsgCustomMapper;
import com.boanwl.manager.pojo.dto.PageParam;
import com.boanwl.manager.pojo.vo.TbMsgCustom;
import com.boanwl.manager.service.TbMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author it_mck 2018/7/24 20:44
 * @ version 1.0
 */
@Service
public class TbMsgServiceImpl implements TbMsgService {


    @Autowired
    private TbMsgCustomMapper tbMsgCustomDao;


    @Override
    public ItemDTO<TbMsgCustom> getRequestList(PageParam pageParam) {

        ItemDTO<TbMsgCustom> result = new ItemDTO<TbMsgCustom>();
        //默认正常状态码为0
        result.setCode(0);
        result.setMsg("select success!!!");
        try {
            //查询留言总个数count
            long count = tbMsgCustomDao.getCounts();
            result.setCount(count);
            //查询留言总数据data
            List<TbMsgCustom> data= tbMsgCustomDao.getTbMsg(pageParam);
            result.setData(data);
        } catch (Exception e) {
            //若出现异常
            result.setCode(-1);
            result.setMsg("select failed!!!");
            e.printStackTrace();
        }
        return result;
    }
}
