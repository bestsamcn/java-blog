package me.best.main.utils;

import jdk.nashorn.internal.runtime.regexp.RegExp;
import net.sf.json.JSONObject;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

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

    /**
     * 检验字符串是否是数字
     * @param num
     * @return
     */
    public static boolean isNumber(String num){
        if(num == null) return false;
        num = num.trim();
        Pattern pattern = Pattern.compile("^[0-9]*$");
        return pattern.matcher(num).matches();
    }
}
