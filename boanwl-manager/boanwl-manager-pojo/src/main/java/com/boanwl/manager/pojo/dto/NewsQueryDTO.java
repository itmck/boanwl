package com.boanwl.manager.pojo.dto;

/**
 * User: Boan
 * Date: 2018/7/24
 * Time: 18:44
 * Version:V1.0
 */
public class NewsQueryDTO extends PageParam{
    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
