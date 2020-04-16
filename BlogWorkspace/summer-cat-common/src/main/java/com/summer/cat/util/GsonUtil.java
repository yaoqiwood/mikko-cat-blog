package com.summer.cat.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class GsonUtil {
    private static Gson gson = new Gson();

    /**
     * 转字符串
     *
     * @param object
     * @return
     */
    public static String gson2String(Object object) {
        String gsonString = null;
        if (gson != null) {
            gsonString = gson.toJson(object);
        }
        return gsonString;
    }

    /**
     * 转实体类
     * @param gsonString
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T gson2Bean(String gsonString, Class<T> cls) {
        T t = null;
        if (null != gson) {
            t = gson.fromJson(gsonString, cls);
        }
        return t;
    }

    /**
     * 转List
     * @param geonString
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> List<T> gson2List(String geonString, Class<T> cls) {
        List<T> list = new ArrayList<>();
        if (null != gson) {
            JsonArray array = new JsonParser().parse(geonString).getAsJsonArray();
            for (final JsonElement jsonElement : array) {
                list.add(gson.fromJson(jsonElement, cls));
            }
        }
        return list;
    }

    /**
     * gson转ListMaps
     * @param gsonString
     * @param <T>
     * @return
     */
    public static <T> List<Map<String, T>> gson2ListMaps(String gsonString) {
        List<Map<String, T>> list = new ArrayList<>();
        if (null != gson) {
            list = gson.fromJson(gsonString, new TypeToken<List<Map<String, T>>>() {
            }.getType());
        }
        return list;
    }

    /**
     * 转map
     * @param gsonString
     * @param <T>
     * @return
     */
    public static <T> Map<String, T> gson2Map(String gsonString) {
        Map<String, T> map = null;
        if (null != gson) {
            gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }
}
