package me.best.main.controllers;

import me.best.main.dao.FactoryDao;
import me.best.main.models.Tag;
import me.best.main.services.FactoryService;
import me.best.main.utils.Utils;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;


@SuppressWarnings("unused")
@WebServlet(urlPatterns = {"/tag/*"})
public class TagController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type", "application/json");
        String pathInfo = req.getPathInfo();
        String path = pathInfo.substring(1);
        System.out.println(path);
        try{
            Method method = this.getClass().getDeclaredMethod(path, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取单条数据
     * @param req
     * @param reps
     */
    private void getById(HttpServletRequest req, HttpServletResponse reps){
        Tag tag = FactoryService.getTagService().getById(req.getParameter("id"));
        long time = tag.getCreateTime().getTime();
        try{
            JSONObject json = JSONObject.fromObject(tag);
            json.remove("createTime");
            json.put("createTime", time);
            JSONObject ret = new JSONObject();
            ret.put("retCode", 0);
            ret.put("msg", "success");
            ret.put("data", json);
            reps.getWriter().println(ret);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp){
        String name = req.getParameter("name");
        JSONObject ret;
        if(name.isEmpty() || name == null || name.length() == 0){
                ret = Utils.setResponse(-1, "标签名不能为空","null");
        }
        Timestamp createTime = new Timestamp(new Date().getTime());
        Tag tag = new Tag(Utils.getUUID(), name, 0, createTime);
        String id = FactoryService.getTagService().add(tag);
        ret = Utils.setResponse(0, "添加成功", id);
        try{
            resp.getWriter().println(ret);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}