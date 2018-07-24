package com.boanwl.manager.pojo.enums;

/**
 * @date 2018/7/24 22:08
 * @since jiangjun
 */
public enum TransEnum {
    LANSHOU("0", "已揽收"),
    TRANS("1", "在途运输"),
    SEND("2", "派送中"),
    RECIVER("3", "已揽收");

    private String value;
    private String desc;

    TransEnum(final String value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }
}
