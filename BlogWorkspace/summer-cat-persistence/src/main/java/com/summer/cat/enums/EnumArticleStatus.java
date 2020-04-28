package com.summer.cat.enums;

public enum EnumArticleStatus {
    /**
     * forbidden,able_view,draft,deleted
     */
    FORBIDDEN_VIEW("不可查看", "0"), ABLE_VIEW("可查看", "1"), DRAFT("草稿", "2"), DELETED("已删除", "9");

    EnumArticleStatus(String name, String code) {
        this.name = name;
        this.code = code;
    };

    private String name;

    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
