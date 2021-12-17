package com.summer.cat.util;

import java.util.HashMap;
import java.util.Map;

import com.summer.cat.base.Constant;

public class Returns {
    public static Map<String, Object> mapOk(Object list, long total, String msg) {
        Map<String, Object> returnsMap = new HashMap<>(3);
        returnsMap.put(Constant.ReturnsMessage.TOTAL, total);
        returnsMap.put(Constant.ReturnsMessage.MESSAGE, msg);
        returnsMap.put(Constant.ReturnsMessage.DATA, list);
        returnsMap.put(Constant.ReturnsMessage.SUCCESS, true);
        returnsMap.put(Constant.ReturnsMessage.ERROR_VALIDATION, false);
        return returnsMap;
    }

    public static Map<String, Object> mapOk(Object list, String msg) {
        Map<String, Object> returnsMap = new HashMap<>(3);
        returnsMap.put(Constant.ReturnsMessage.DATA, list);
        returnsMap.put(Constant.ReturnsMessage.MESSAGE, msg);
        returnsMap.put(Constant.ReturnsMessage.SUCCESS, true);
        returnsMap.put(Constant.ReturnsMessage.ERROR_VALIDATION, false);
        return returnsMap;
    }

    public static Map<String, Object> mapOk(String msg) {
        Map<String, Object> returnsMap = new HashMap<>(2);
        returnsMap.put(Constant.ReturnsMessage.MESSAGE, msg);
        returnsMap.put(Constant.ReturnsMessage.SUCCESS, true);
        returnsMap.put(Constant.ReturnsMessage.ERROR_VALIDATION, false);
        return returnsMap;
    }

    public static Map<String, Object> mapError(String msg) {
        Map<String, Object> returnsMap = new HashMap<>(2);
        returnsMap.put(Constant.ReturnsMessage.MESSAGE, msg);
        returnsMap.put(Constant.ReturnsMessage.SUCCESS, false);
        returnsMap.put(Constant.ReturnsMessage.ERROR_VALIDATION, false);
        return returnsMap;
    }

}
