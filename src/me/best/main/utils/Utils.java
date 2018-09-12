package me.best.main.utils;

import net.sf.json.JSONObject;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
public class Utils {

    /**
     * 获取id
     * @return
     */
    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replace("-", "");
        return id;
    }

    /**
     * 设置返回数据
     * @param retCode
     * @param msg
     * @param data
     * @return
     */
    public static JSONObject setResponse(int retCode, String msg, Object data){
        JSONObject json = new JSONObject();
        json.put("retCode", retCode);
        json.put("msg", msg);
        json.put("data", data);
        return json;
    }
}
