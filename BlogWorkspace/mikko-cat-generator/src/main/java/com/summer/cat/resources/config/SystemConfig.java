package com.summer.cat.resources.config;

import cn.hutool.setting.dialect.Props;

public class SystemConfig {
    public static String generatorProjectPath = "";

    public static String generatorOutputParent = "";

    public static String generatorOutputMapper = "";

    public static String generatorAuthor = "";

    public static String generatorDataBaseUrl = "";

    public static String generatorDatabaseDriverName = "";

    public static String generatorDatabaseUserName = "";

    public static String generatorDatabaseUserPassword = "";

    public static String generatorOutputParentPath = "";

    public static String generatorWholeOutputPath = "";

    static {
        Props props = new Props("system.properties");
        generatorProjectPath = props.getStr("generator.project.path");
        generatorOutputParent = props.getStr("generator.output.parent");
        generatorOutputMapper = props.getStr("generator.output.mapper");
        generatorAuthor = props.getStr("generator.author");
        generatorDataBaseUrl = props.getStr("generator.database.url");
        generatorDatabaseDriverName = props.getStr("generator.database.driver.name");
        generatorDatabaseUserName = props.getStr("generator.database.user.name");
        generatorDatabaseUserPassword = props.getStr("generator.database.user.password");
        generatorOutputParentPath = props.getStr("generator.output.parent.path");
        generatorWholeOutputPath = generatorProjectPath + generatorOutputParentPath;
    }
}
