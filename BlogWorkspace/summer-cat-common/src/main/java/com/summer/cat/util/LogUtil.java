package com.summer.cat.util;


import org.apache.log4j.Logger;

public class LogUtil {
    private static Logger log = Logger.getLogger(LogUtil.class);

    private static void info(String msg){
        log.info(msg + getStackTrace());
    }

    private static String getStackTrace(){
        int index=2;
        StackTraceElement[] ste = new Throwable().getStackTrace();
        for (StackTraceElement s:ste){
            LogUtil.info(s.toString());
        }
        StackTraceElement s = ste[index];
        String className = s.getClassName();
        String method_name = s.getMethodName();
        String lineNum = String.valueOf(s.getLineNumber());
        return "  \t\t@[" + className + "." + method_name + " => " + lineNum + "] ";
    }
}
