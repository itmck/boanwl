package com.boanwl.manager.web;

import com.boanwl.fdfs.FastDFSFile;
import com.boanwl.fdfs.FastDFSUtils;
import com.boanwl.manager.pojo.dto.NewsQueryDTO;
import com.boanwl.manager.pojo.po.TbNews;
import com.boanwl.manager.service.NewsService;
import com.boanwl.manager.service.boan.PhoneCodeService;
import com.dhc.util.JsonUtils;
import com.dhc.util.PropKit;
import com.dhc.util.StrKit;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Boan
 * Date: 2018/7/28
 * Time: 9:34
 * Version:V1.0
 */
@Controller
public class CodeTestAction {

    @Autowired
    private SolrServer solrServer;
    @Autowired
    NewsService service;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PhoneCodeService phoneCodeService;

    @ResponseBody
    @GetMapping("/test/{phoneNumber}")
    public Map<String, Object> testCode(@PathVariable String phoneNumber) {
        return phoneCodeService.sendRegisterCode(phoneNumber);
    }

    @GetMapping("/test/{phoneNumber}/{code}")
    @ResponseBody
    public String checkCode(@PathVariable String phoneNumber, @PathVariable String code) {
        if (phoneCodeService.checkRegisterCode(phoneNumber, code))
            return "0";
        return "1";
    }

    @ResponseBody
    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public String uploadImage(@RequestParam MultipartFile file) {
        Map<String, Object> map = new HashMap<String, Object>();
        String jsonString = "";
        try {
            //1 将文件上传到fdfs
            //a 初始化实体类
            FastDFSFile fastDFSFile = new FastDFSFile(file.getBytes(), file.getOriginalFilename(), file.getSize());
            //b 上传
            //path  /group1/M00/00/00/xxxx.jpg
            //模拟上传   /usr/bin/fdfs_upload_file /etc/fdfs/client.conf  /opt/soft/2.jpg
            ///group1/M00/00/00/xxxx.jpg
            // http://101.132.38.253/group1/M00/00/00/xxxx.jpg
            String filePath = FastDFSUtils.uploadFile(fastDFSFile);
            //2 回显到富文本编辑器中
            String basePath = PropKit.use("fdfs_client.conf").get("fdfs_server");
            //判断filePath是否为空，不为空上传成功
            Map<String, Object> dataMap = new HashMap<String, Object>();
            if (StrKit.notBlank(filePath)) {
                //不为空
                map.put("code", 0);
//                map.put("msg", "success");
                dataMap.put("src", basePath + "/" + filePath);
                map.put("data", dataMap);
            } else {
                map.put("code", 1);
                map.put("msg", "fail");
                dataMap.put("src", "");
                map.put("data", dataMap);
            }
            jsonString = JsonUtils.objectToJson(map);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return jsonString;
    }

    @ResponseBody
    @GetMapping("/boan")
    public Map<String,Object> slorDataImport() throws IOException, SolrServerException {

        NewsQueryDTO dto = new NewsQueryDTO();
        dto.setPage(1);
        dto.setLimit(1000);
        service.listNews(dto).getData().forEach((TbNews n) ->{

            SolrInputDocument document = new SolrInputDocument();

            /**
             * 	<field name="news_id" type="text_ik" indexed="false" stored="true"/>
             <field name="news_title" type="text_ik" indexed="true" stored="true"/>
             <field name="news_content" type="long" indexed="true" stored="true"/>
             <field name="news_time" type="date" indexed="false" stored="true"/>
             <field name="news_image" type="string" indexed="false" stored="true"/>
             */
            document.addField("id", n.getId());
            document.addField("news_id",n.getId());
            document.addField("news_title",n.getTitle());
            document.addField("news_content",n.getContent());
            document.addField("news_time",n.getTime());
            document.addField("news_image",n.getImage());

            try {
                solrServer.add(document);
            } catch (SolrServerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        solrServer.commit();
        Map<String,Object> map = new HashMap<>();
        map.put("msg","ok");
        return map;
    }



}
