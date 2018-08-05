package com.boanwl.portal.service.impl;

import com.boan.jedis.JedisClient;
import com.boanwl.portal.dao.TbImgMapper;
import com.boanwl.portal.pojo.po.TbImg;
import com.boanwl.portal.pojo.po.TbImgExample;
import com.boanwl.portal.service.ImgService;
import com.dhc.util.JsonUtils;
import com.dhc.util.StrKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date 2018/8/3 2:04
 * @since jiangjun
 */
@Service
public class ImgServiceImpl implements ImgService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JedisClient jedisClient;
    @Autowired
    private TbImgMapper tbImgMapper;


    public List<TbImg> getImgListById(Long imgid) {
        //1 去缓存中查询，在try中的内容不能影响本方法的主要功能，主要功能进行查询
        try {
            //调用JedisClientCluster
            String json = jedisClient.hget("CONTENTLIST", imgid +"");
            //判断json是否为空
            if (StrKit.notBlank(json)){
                //json不为空
                List<TbImg> list = JsonUtils.jsonToList(json, TbImg.class);
                return list;
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        //2 去mysql查
        //获取到查询模板
        TbImgExample example = new TbImgExample();
        TbImgExample.Criteria criteria = example.createCriteria();
        criteria.andImgidEqualTo(imgid);
        //执行查询
        List<TbImg> imgList = tbImgMapper.selectByExample(example);
        //3 存到缓存中
        try {
            //调用JedisClientCluster
            jedisClient.hset("CONTENTLIST",imgid+"", JsonUtils.objectToJson(imgList));
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return imgList;
    }


}
