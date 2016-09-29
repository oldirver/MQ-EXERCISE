package com.junxian.mq.exercise.common.utils;

/**
 * Created by KeJunXian on 2016/9/18.
 *
 */
public class JsonUtil {

    public static String toJson(Object obj) {
        return "";
    }

    public static <T> T toObj(String json, Class<T> obj) {
        try {
            return obj.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
