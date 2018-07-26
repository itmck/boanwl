package com.boanwl.manager.service.impl;

import com.boan.comcom.utils.UUIDutil;
import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.dao.TbMsgCustomMapper;
import com.boanwl.manager.dao.TbRespMapper;
import com.boanwl.manager.pojo.dto.PageParam;
import com.boanwl.manager.pojo.dto.TbQueryDTO;
import com.boanwl.manager.pojo.po.TbMsg;
import com.boanwl.manager.pojo.po.TbResp;
import com.boanwl.manager.pojo.vo.TbMsgCustom;
import com.boanwl.manager.service.TbMsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author it_mck 2018/7/24 20:44
 * @ version 1.0
 */
@Service
public class TbMsgServiceImpl implements TbMsgService {


    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbMsgCustomMapper tbMsgCustomDao;
    @Autowired
    private TbRespMapper tbRespDao;


    @Override
    public ItemDTO<TbMsgCustom> getRequestList(PageParam pageParam, TbQueryDTO tbQueryDTO) {

        ItemDTO<TbMsgCustom> result = new ItemDTO<TbMsgCustom>();
        //默认正常状态码为0
        result.setCode(0);
        result.setMsg("select success!!!");
        try {

            Map<String,Object> map =new HashMap<>();
            map.put("pageParam",pageParam);
            map.put("tbQueryDTO",tbQueryDTO);
            //查询留言总个数count
            long count = tbMsgCustomDao.getCounts(map);
          // long count = tbMsgCustomDao.countByExample(null);
            result.setCount(count);
            //查询留言总数据data
           List<TbMsgCustom> data= tbMsgCustomDao.getTbMsg(map);
            result.setData(data);
        } catch (Exception e) {
            //若出现异常
            result.setCode(-1);
            result.setMsg("select failed!!!");
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }


    /**
     *
     * 回复客户留言
     *
     * @param tbResp
     * @return
     */
    @Override
    public int respMsg(TbResp tbResp) {


        //将回复信息添加到表中
        String respId = UUIDutil.getUUID();
        tbResp.setRespId(respId);
        int i = tbRespDao.insertSelective(tbResp);
        //更新留言表的代办状态值,将其置为0
        String orderNo = tbResp.getOrderNo();
        //获取对象
        TbMsg tbMsg = tbMsgCustomDao.selectByPrimaryKey(orderNo);
        tbMsg.setStatus(0);
        //更新状态值
        int i1 = tbMsgCustomDao.updateByPrimaryKeySelective(tbMsg);
        if(i>0&&i1>0){
            return 1;
        }else{
            return 0;
        }

    }
}
