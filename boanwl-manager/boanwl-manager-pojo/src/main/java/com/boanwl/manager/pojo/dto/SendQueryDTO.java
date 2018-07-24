package com.boanwl.manager.pojo.dto;

/**
 * User: Boan
 * Date: 2018/7/23
 * Time: 20:14
 * Version:V1.0
 */
public class SendQueryDTO {
    private Integer page;
    private Integer limit;
    private String sid;
    private String senderName;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
    public int getOffset() {
        return (page - 1) * limit;
    }


}
