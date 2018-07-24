package com.boanwl.manager.service.impl;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.dao.TbTransMapper;
import com.boanwl.manager.dao.transMapper;
import com.boanwl.manager.pojo.dto.PageParam;
import com.boanwl.manager.pojo.po.TbTrans;
import com.boanwl.manager.service.TransService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @date 2018/7/24 12:22
 * @since jiangjun
 */
@Service
public class TransServiceImpl implements TransService{
    @Autowired
    private TbTransMapper tbTransMapper;
    @Autowired
    private transMapper transMapper;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 条件查询流水单ok
     * */
    @Override
    public ItemDTO<TbTrans> selectOrder(String orderNum, PageParam pageParam) {
        ItemDTO<TbTrans> tbTransItemDTO = new ItemDTO<>();
        try {
            tbTransItemDTO.setCode(0);
            tbTransItemDTO.setMsg("select success");
            tbTransItemDTO.setData(transMapper.selectOrder(orderNum,pageParam));
            tbTransItemDTO.setCount(transMapper.counttrans(orderNum));

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        /*return tbSendItemDTO;
        List<TbTrans> transList=tbTransMapper.selectOrder(orderNum);*/
        return tbTransItemDTO;
    }
    /**
     * 展示所有流水记录*/
    @Override
    public ItemDTO<TbTrans> showOrder() {
        ItemDTO<TbTrans> tbTransItemDTO = new ItemDTO<>();
        try {

            tbTransItemDTO.setCode(0);
            tbTransItemDTO.setMsg("select success");
            tbTransItemDTO.setData(transMapper.showOrder());
            tbTransItemDTO.setCount(transMapper.showcount());

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return tbTransItemDTO;
    }
}
