package com.boanwl.manager.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @date 2018/7/24 12:48
 * @since jiangjun
 */
public class TransRespDto {
    private String orderNum;
    private String city;
    private String name;
    private Integer status;
    private String statusName;
    private String msg;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateCreated;


    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TransRespDto{");
        sb.append("orderNum='").append(orderNum).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", status=").append(status);
        sb.append(", statusName='").append(statusName).append('\'');
        sb.append(", msg='").append(msg).append('\'');
        sb.append(", dateCreated=").append(dateCreated);
        sb.append('}');
        return sb.toString();
    }
}
