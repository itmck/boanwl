package com.boanwl.manager.pojo.dto;

/**
 * User: volker
 * Date: 2018/7/23
 * Time: 23:01
 * Version:V1.0
 */
public class PageParam {
    private int page;
    private int limit;


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    //只要使用给page和limit赋值，那么offset自动计算出来
    public int getOffset() {
        return (page-1)*limit;
    }
}
