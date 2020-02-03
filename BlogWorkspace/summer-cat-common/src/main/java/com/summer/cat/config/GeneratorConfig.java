package com.summer.cat.config;

import cn.hutool.setting.dialect.Props;

public class GeneratorConfig {
    public static final Boolean fileOverride;
    public static final Boolean activeRecord;
    public static final Boolean enableCache;
    public static final Boolean baseResultMap;
    public static final Boolean baseColumnList;
    public static final String globalAuthor;
    public static final String dbType;
    public static final String dbDriver;
    public static final String dbName;
    public static final String dbHost;
    public static final String dbPort;
    public static final String dbUsername;
    public static final String dbPassword;
    public static final String dbCharacterEncoding;
    public static final String dbUrl;
    public static final String dbJDBC = "jdbc:";

    static {
        Props props = new Props("generatorConfig.properties");
        fileOverride = props.getBool("fileOverride");
        activeRecord = props.getBool("activeRecord");
        enableCache = props.getBool("enableCache");
        baseResultMap = props.getBool("baseResultMap");
        baseColumnList = props.getBool("baseColumnList");
        globalAuthor = props.getStr("global.author");
        dbType = props.getStr("db.type");
        dbDriver = props.getStr("db.driver");
        dbName = props.getStr("db.name");
        dbHost = props.getStr("db.host");
        dbPort = props.getStr("db.port");
        dbUsername = props.getStr("db.username");
        dbPassword = props.getStr("db.password");
        dbCharacterEncoding = props.getStr("db.characterEncoding");
        dbUrl = dbJDBC + dbType + "://" + dbHost + ":" + dbPort + "/" + dbName + "?characterEncoding=" + dbCharacterEncoding;
    }
}
