package com.boanwl.portal.service.impl;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.portal.dao.TbMsgMapper;
import com.boanwl.portal.dao.TbRespMapper;
import com.boanwl.portal.pojo.po.TbMsg;
import com.boanwl.portal.pojo.po.TbMsgExample;
import com.boanwl.portal.pojo.po.TbResp;
import com.boanwl.portal.pojo.po.TbRespExample;
import com.boanwl.portal.service.ContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by it_mck 2018/8/6 20:11
 *
 * @Description:
 * @Version: 1.0
 */
@Service
public class ContentServiceImpl implements ContentService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbMsgMapper tbMsgMapper;
    @Autowired
    private TbRespMapper tbRespMapper;


    /**
     * 留言
     *
     * @param tbMsg
     * @return
     */
    @Override
    public int insertContent(TbMsg tbMsg) {

        int i = 0;
        try {
            //先去数据库查询此订单是否已经留言
            String orderNo = tbMsg.getOrderNo();
            TbMsg tbMsg1 = tbMsgMapper.selectByPrimaryKey(orderNo);
            if (tbMsg1 != null) {
                return i;//若用户已经留言就不让再次留言
            } else {
                //将留言的代办状态设置为1,表示为代办
                tbMsg.setStatus(1);
                //将留言信息插入数据库中
                i = tbMsgMapper.insertSelective(tbMsg);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return i;
    }

    /**
     * 查询
     *
     * @param utel
     * @return
     */
    @Override
    public ItemDTO<TbResp> queryContent(String utel) {

        ItemDTO<TbResp> result = new ItemDTO<TbResp>();
        //默认正常状态码为0
        result.setCode(0);
        result.setMsg("select success!!!");
        //用于存放订单号
        List<String> list_no = new ArrayList<>();
        try {
            //根据手机号查询订单号
            TbMsgExample tbMsgExample = new TbMsgExample();
            TbMsgExample.Criteria criteria = tbMsgExample.createCriteria();
            criteria.andUtelEqualTo(utel);
            List<TbMsg> list = tbMsgMapper.selectByExample(tbMsgExample);
            //遍历list
            if (list.size()!=0) {
                result.setCount(list.size());
                for (TbMsg s : list) {
                    //遍历同一个手机号下的所有留言信息
                    String orderNo = s.getOrderNo();
                    list_no.add(orderNo);
                }
                //通过订单号查询留言回复信息
                TbRespExample tbRespExample = new TbRespExample();
                TbRespExample.Criteria criteria1 = tbRespExample.createCriteria();
                criteria1.andOrderNoIn(list_no);
                List<TbResp> respList = tbRespMapper.selectByExample(tbRespExample);
                result.setData(respList);
            }else{
                //查询不到就直接返回
                result.setData(null);
                return result;
            }

        } catch (Exception e) {
            //异常设置为-1
            result.setCode(-1);
            result.setMsg("select failed!!!");
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return result;
    }

    /**
     *
     * 查询此手机号是否已经留言
     * @param utel
     * @return
     */
    @Override
    public int queryUtel(String utel) {
        List<TbMsg> list = new ArrayList<TbMsg>();
        try {
            //根据手机号查询订单号
            TbMsgExample tbMsgExample = new TbMsgExample();
            TbMsgExample.Criteria criteria = tbMsgExample.createCriteria();
            criteria.andUtelEqualTo(utel);
            list = tbMsgMapper.selectByExample(tbMsgExample);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        if(list.size()!=0){
            //存在此手机号对应的留言
            System.out.println("存在此手机号");
            return 1;
        }
        return 0;
    }
}
