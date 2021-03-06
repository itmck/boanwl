package com.boanwl.manager.pojo.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbTrans {
    private String id;

    private String orderNum;

    private String name;

    private String city;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateCreated;

    private Date dateUpdated;

    private Integer status;

    private String msg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TbTrans{");
        sb.append("id='").append(id).append('\'');
        sb.append(", orderNum='").append(orderNum).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", dateCreated=").append(dateCreated);
        sb.append(", dateUpdated=").append(dateUpdated);
        sb.append(", status=").append(status);
        sb.append(", msg='").append(msg).append('\'');
        sb.append('}');
        return sb.toString();
    }
}