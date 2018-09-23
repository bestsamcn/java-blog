package me.best.main.services;

import me.best.main.controllers.PosterController;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
     * 下载
     * @param req
     * @param resp
     * @return
     */
    public void getImage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;


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
