package com.boanwl.manager.service.impl;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.dao.TbTransMapper;
import com.boanwl.manager.dao.transMapper;
import com.boanwl.manager.pojo.dto.PageParam;
import com.boanwl.manager.pojo.po.TbSend;
import com.boanwl.manager.pojo.po.TbTrans;
import com.boanwl.manager.service.TransService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;


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
    /**
     * 添加第一条流水单信息*/
    @Override
    public long saveOneMsg(TbSend tbSend) {
        try {
        TbTrans tbTrans = new TbTrans();
        tbTrans.setDateCreated(new Date());
        tbTrans.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        tbTrans.setOrderNum(tbSend.getSeId());
        tbTrans.setCity(tbSend.getSenderAddress());
        tbTrans.setName("张三");
        tbTrans.setStatus(0);
        tbTrans.setMsg("快件已在"+tbSend.getSenderAddress()+"揽收");
        tbTransMapper.insert(tbTrans);
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return 0;
    }
    /**
     * 添加不是第一条的流水单信息，快递员进行添加
     * */
    @Override
    public void saveTrans(TbTrans trans) {
        try {
        TbTrans tbTrans = new TbTrans();
        tbTrans.setDateCreated(new Date());
        tbTrans.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        tbTrans.setOrderNum(trans.getOrderNum());
        tbTrans.setCity(trans.getCity());
        tbTrans.setName(trans.getName());
        tbTrans.setStatus(trans.getStatus());
        tbTransMapper.insert(trans);
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }
    /**
     * 修改信息之前的根据id查询的信息用于回显
     * */
    @Override
    public TbTrans getTrans(String id) {

        TbTrans trans = transMapper.getTrans(id);
        return trans;
    }
    /**
     * 修改流水单信息
     * */
    @Override
    public long modifyTrans(String id, TbTrans trans) {
        TbTrans tbTrans = new TbTrans();
        tbTrans.setId(id);
        tbTrans.setDateCreated(trans.getDateCreated());
        tbTrans.setMsg(trans.getMsg());
        tbTrans.setStatus(trans.getStatus());
        tbTrans.setName(trans.getName());
        tbTrans.setOrderNum(trans.getOrderNum());
        trans.setCity(trans.getCity());
       long result= transMapper.modifyTrans(tbTrans);
        return 0;
    }

}
