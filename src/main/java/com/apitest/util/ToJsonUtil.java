package com.apitest.util;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ToJsonUtil {

    public static String toString(Object o) {
        String msgSend = JSONObject.toJSONString(o);
        return msgSend;
    }
}
