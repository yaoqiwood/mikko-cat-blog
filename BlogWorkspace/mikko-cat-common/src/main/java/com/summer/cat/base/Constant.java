package com.summer.cat.base;

import java.util.HashSet;
import java.util.Set;

/**
 * @author summer
 * @since 2018-05-03
 */
public class Constant {

    public static final int BYTE_BUFFER = 1024;

    public static Set<String> METHOD_URL_SET = new HashSet<>();

    /**
     * 用户登录时存放KeyName
     */
    public static final String CURRENT_USER_REQUEST_NAME = "currentUser";

    public static final String TOKEN = "token";

    /**
     * 用户注册默认角色
     */
    public static final int DEFAULT_REGISTER_ROLE = 5;

    public static final int BUFFER_MULTIPLE = 10;

    // 验证码过期时间
    public static final Long PASS_TIME = 50000 * 60 * 1000L;

    // 根菜单节点
    public static final String ROOT_MENU = "0";

    // 菜单类型，1：菜单 2：按钮操作
    public static final int TYPE_MENU = 1;

    // 菜单类型，1：菜单 2：按钮操作
    public static final int TYPE_BUTTON = 2;

    public static Boolean isPass = false;

    // 用户名登录
    public static final int LOGIN_USERNAME = 0;

    // 手机登录
    public static final int LOGIN_MOBILE = 1;

    // 邮箱登录
    public static final int LOGIN_EMAIL = 2;

    // 启用
    public static final int ENABLE = 1;

    // 禁用
    public static final int DISABLE = 0;

    public static class FilePostFix {
        public static final String ZIP_FILE = ".zip";

        public static final String[] IMAGES = { "jpg", "jpeg", "JPG", "JPEG", "gif", "GIF", "bmp", "BMP", "png" };

        public static final String[] ZIP = { "ZIP", "zip", "rar", "RAR" };

        public static final String[] VIDEO = { "mp4", "MP4", "mpg", "mpe", "mpa", "m15", "m1v", "mp2", "rmvb" };

        public static final String[] APK = { "apk", "exe" };

        public static final String[] OFFICE = { "xls", "xlsx", "docx", "doc", "ppt", "pptx" };

    }

    public class FileType {
        public static final int FILE_IMG = 1;

        public static final int FILE_ZIP = 2;

        public static final int FILE_VEDIO = 3;

        public static final int FILE_APK = 4;

        public static final int FIVE_OFFICE = 5;

        public static final String FILE_IMG_DIR = "/img/";

        public static final String FILE_ZIP_DIR = "/zip/";

        public static final String FILE_VEDIO_DIR = "/video/";

        public static final String FILE_APK_DIR = "/apk/";

        public static final String FIVE_OFFICE_DIR = "/office/";
    }

    public class ErrorMessage {
        public static final String PARAMS_ERROR = "paramsError";
    }

    public class RoleType {
        // 超级管理员
        public static final String SYS_ASMIN_ROLE = "sysadmin";

        // 管理员
        public static final String ADMIN = "admin";

        // 普通用户
        public static final String USER = "user";
    }

    /**
     * 返回信息名
     */
    public static class ReturnsMessage {
        public static final String TOTAL = "total";

        public static final String MESSAGE = "message";

        public static final String DATA = "data";

        public static final String SUCCESS = "success";

        public static final String ERROR_VALIDATION = "errorValidation";

        public static final String SUCCESS_MSG = "查询成功";

        public static final String ERROR_MSG = "失败：";
    }

    // 项目位置
    public static final String SYSTEM_DIR = System.getProperty("user.dir");

    // 自定义配置加载文件名
    public static final String USER_DEFINED_SYSTEM_PATH = "classpath:/config/system.properties";

    // 验证码session
    public static final String VERIFICATION_CODE = "verificationCode";

    // 验证值
    public static final String AUTHORIZATION = "Authorization";

    public static final String ADMIN_NAME = "sysadmin";

}
