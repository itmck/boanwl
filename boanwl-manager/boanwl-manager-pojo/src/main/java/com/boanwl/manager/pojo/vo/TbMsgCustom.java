package com.boanwl.manager.pojo.vo;

import com.boanwl.manager.pojo.po.TbMsg;

/**
 * 用于查询的时候显示状态名
 *
 * @author it_mck 2018/7/24 20:38
 * @ version 1.0
 */
public class TbMsgCustom extends TbMsg {


    private String statusName;

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
