package me.best.main.services;

import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Sam
 * @Date: 2018/9/23 18:48
 */
public interface PosterService {

    /**
     * 新增
     * @param req
     * @return
     */
    public JSONObject add(HttpServletRequest req);

    /**
     * 删除
     * @param id
     * @return
     */
    public JSONObject delete(String id);

    /**
     * 分页
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public JSONObject getList(String pageIndex, String pageSize);
}
