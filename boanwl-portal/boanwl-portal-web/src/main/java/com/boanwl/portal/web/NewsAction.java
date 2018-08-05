package com.boanwl.portal.web;

import com.boanwl.common.dto.NewsSlorDTO;
import com.boanwl.portal.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: Boan
 * Date: 2018/8/5
 * Time: 16:18
 * Version:V1.0
 */
@Controller
public class NewsAction {

    @Autowired
    NewsService newsService;

    @ResponseBody
    @GetMapping("/news")
    public NewsSlorDTO listNews(String keyword, @RequestParam(defaultValue = "1") int page,
                                @RequestParam(defaultValue = "5") int rows) throws Exception {


        if(keyword == null)
            keyword = "*:*";
        return newsService.search(keyword,page,rows);

    }

}
