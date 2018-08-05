package com.boanwl.portal.pojo.po;

public class TbImg {
    private String id;

    private String href;

    private String imgDesc;

    private Long imgid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public String getImgDesc() {
        return imgDesc;
    }

    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc == null ? null : imgDesc.trim();
    }

    public Long getImgid() {
        return imgid;
    }

    public void setImgid(Long imgid) {
        this.imgid = imgid;
    }
}