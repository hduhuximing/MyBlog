package com.zyd.blog.business.enums;


public enum LinkStatusEnum {
    ENABLE("可用"),
    DISABLE("禁用");
    private String desc;

    LinkStatusEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
