package com.zyd.blog.business.enums;


public enum ArticleStatusEnum {
    PUBLISHED(1, "发布"),
    UNPUBLISHED(0, "草稿");
    private int code;
    private String desc;

    ArticleStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ArticleStatusEnum get(Integer code) {
        if (code == null) {
            return UNPUBLISHED;
        }
        ArticleStatusEnum[] statusEnums = ArticleStatusEnum.values();
        for (ArticleStatusEnum statusEnum : statusEnums) {
            if (statusEnum.getCode() == code) {
                return statusEnum;
            }
        }
        return UNPUBLISHED;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
