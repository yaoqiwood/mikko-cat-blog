package com.summer.cat.enums;

public enum EnumLoginStatus {
    ENABLE("enable", "1"), FORBIDDEN("forbidden", "2"), DELETE("delete", "3");

    EnumLoginStatus(String name, String code) {
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
