package com.summer.cat.base;

import cn.hutool.setting.dialect.Props;

public class SystemConfig {
    public static String globalAuthor;
    public static String systemUploadDir;

    static {
        Props props = new Props(Constant.USER_DEFINED_SYSTEM_PATH);
        globalAuthor = props.getStr("global.author");
        systemUploadDir = props.getStr("system.upload.dir");
    }
}
