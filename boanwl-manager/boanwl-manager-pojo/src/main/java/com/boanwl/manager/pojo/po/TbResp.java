package com.boanwl.manager.pojo.po;

public class TbResp {
    private String respId;

    private String orderNo;

    private String respMsg;

    public String getRespId() {
        return respId;
    }

    public void setRespId(String respId) {
        this.respId = respId == null ? null : respId.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg == null ? null : respMsg.trim();
    }
}