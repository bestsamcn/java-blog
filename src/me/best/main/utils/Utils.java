package me.best.main.utils;

import java.util.UUID;

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
}
