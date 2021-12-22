package com.summer.cat.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("SystemConfig")
public class SystemConfig {
    public static String globalAuthor;
    public static String systemUploadDir;
    public static String userUploadDir;
    public static String userProfileDir;

    @Value("${mikko.global.author}")
    public void setGlobalAuthor(String globalAuthor) {
        SystemConfig.globalAuthor = globalAuthor;
    }

    @Value("${mikko.system.upload.dir}")
    public void setSystemUploadDir(String systemUploadDir) {
        SystemConfig.systemUploadDir = systemUploadDir;
    }

    @Value("${mikko.system.user.dir}")
    public void setUserUploadDir(String userUploadDir) {
        SystemConfig.userUploadDir = userUploadDir;
    }

    @Value("${mikko.system.user.profile}")
    public void setUserProfileDir(String userProfileDir) {
        SystemConfig.userProfileDir = userProfileDir;
    }
}
