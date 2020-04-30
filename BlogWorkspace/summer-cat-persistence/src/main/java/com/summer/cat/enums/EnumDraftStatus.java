package com.summer.cat.enums;

public enum EnumDraftStatus {
    /**
     * released,draft
     */
    RELEASED("已发布", "released"), DRAFT("草稿", "draft");

    EnumDraftStatus(String name, String code) {
        this.name = name;
        this.code = code;
    }

    private String name;

    private String code;

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
