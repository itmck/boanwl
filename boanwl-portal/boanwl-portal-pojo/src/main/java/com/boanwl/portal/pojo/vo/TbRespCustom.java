package com.boanwl.portal.pojo.vo;

import com.boanwl.portal.pojo.po.TbResp;

/**
 * Create by it_mck 2018/8/6 20:35
 *
 * @Description:
 * @Version: 1.0
 */
public class TbRespCustom extends TbResp {


    private String name;
    private String theme;


    public TbRespCustom(String name, String theme) {
        this.name = name;
        this.theme = theme;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "TbRespCustom{" +
                "name='" + name + '\'' +
                ", theme='" + theme + '\'' +
                '}';
    }
}
