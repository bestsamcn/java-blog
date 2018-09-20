package me.best.main.utils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * 会话类
 */
public class SessionUtils {
    private static HashMap sessionMap = new HashMap();

    /**
     * 新增
     * @param session
     */
    public synchronized static void addSession (HttpSession session){
        sessionMap.put(session.getId(), session);
    }

    /**
     * 删除
     * @param id
     */
    public synchronized  static  void delSession(String id){
        sessionMap.remove(id);
    }

    /**
     * 获取
     * @param id
     * @return
     */
    public synchronized  static HttpSession getSession(String id){
        return (HttpSession) sessionMap.get(id);
    }
}
