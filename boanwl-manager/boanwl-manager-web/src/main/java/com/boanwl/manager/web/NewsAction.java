package com.boanwl.manager.web;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.pojo.dto.NewsQueryDTO;
import com.boanwl.manager.pojo.po.TbNews;
import com.boanwl.manager.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Boan
 * Date: 2018/7/24
 * Time: 18:46
 * Version:V1.0
 */
@Controller
@RequestMapping("/news")
public class NewsAction {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Resource
    private Destination topicDestination;
    @Autowired
    private NewsService newsService;

    /**
     * 增加一条新闻 图片也是输入地址
     * @param tbNews
     * @return
     */
    @PostMapping("/save")
    @ResponseBody()
    public Object saveNews(TbNews tbNews) {
        Map<String,Object> map = new HashMap<>();
        try {
           String id =  newsService.saveNews (tbNews);
            map.put("save_code","0");
//            jmsTemplate.send(topicDestination, new MessageCreator() {
//                @Override
//                public Message createMessage(Session session) throws JMSException {
//                    TextMessage textMessage = session.createTextMessage(id);
//                    return textMessage;
//                }
//            });
        }catch (Exception e) {
            e.printStackTrace();;
            map.put("save_code","1");
        }
        return map;
    }

    /**
     * 根据删除(改状态)
     * @param nid
     * @return
     */
    @PutMapping("/update/{nid}")
    @ResponseBody()
    public Object updateNewsByNid(@PathVariable String  nid) {
        Map<String,Object> map = new HashMap<>();
        try {
            newsService.updateNewsByNid(nid);
            map.put("update_code","0");
        }catch (Exception e) {
            e.printStackTrace();;
            map.put("update_code","1");
        }
        return map;
    }

    /**
     * 批量
     * @param nids
     * @return
     */
   @PutMapping("/updateNids")
    @ResponseBody()
    public Object updateNewsByNids(@RequestParam("nids[]")List<String> nids) {
        Map<String,Object> map = new HashMap<>();
        try {
            newsService.updateNewsByNids(nids);
            map.put("update_code","0");
        }catch (Exception e) {
            e.printStackTrace();;
            map.put("update_code","1");
        }
        return map;
    }

    /**
     * 修改商品 图片为地址
     * @param tbNews
     * @return
     */
    @PutMapping("/update")
    @ResponseBody()
    public Object updateNews(TbNews tbNews) {
        Map<String,Object> map = new HashMap<>();
        try {
            newsService.updateNews(tbNews);
            map.put("update_code","0");
        }catch (Exception e) {
            e.printStackTrace();;
            map.put("update_code","1");
        }
        return map;
    }

    @GetMapping("/list")
    @ResponseBody
    public Object listNews(NewsQueryDTO newsQueryDTO) {
        ItemDTO<TbNews> tbNewsItemDTO = null;

        try{
            tbNewsItemDTO = newsService.listNews(newsQueryDTO);
         // System.out.print(tbNewsItemDTO.getData());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return tbNewsItemDTO;
    }
    @GetMapping("/{nid}")
    @ResponseBody
    public TbNews getNews(@PathVariable String nid) {
        try {
            return newsService.getNews(nid);
        }catch (Exception e) {
            e.printStackTrace();;
            return null;
        }
    }

}
