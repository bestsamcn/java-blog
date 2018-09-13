package me.best.main.controllers;

import me.best.main.models.Tag;
import me.best.main.services.FactoryService;
import me.best.main.utils.Utils;
import net.sf.json.JSONObject;
import org.postgresql.util.PSQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
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
    private void getById(HttpServletRequest req, HttpServletResponse reps) throws ServletException, IOException{
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

    //新增
    private void add(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String name = req.getParameter("name");
        JSONObject ret = FactoryService.getTagService().add(name);
        resp.getWriter().println(ret);

    }

    //修改
    private void edit(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        int clickNum = Integer.parseInt(req.getParameter("clickNum"));

        Tag tag = new Tag(id, name, clickNum, null);


        JSONObject ret = Utils.setResponse(-1, "异常", "null");

        try{
            int row =  FactoryService.getTagService().edit(tag);
            if(row == 1){
                ret = Utils.setResponse(0, "编辑成功", tag.getId());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        resp.getWriter().println(ret);
    }

    //删除
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String id = req.getParameter("id");
        JSONObject ret = Utils.setResponse(-1, "异常", "null");
        if(id.isEmpty() || id.length() != 32){
            ret = Utils.setResponse(-1, "无此数据", "null");
            resp.getWriter().println(ret);
        }
        try{
            int row =  FactoryService.getTagService().delete(id);
            if(row == 1){
                ret = Utils.setResponse(0, "编辑成功", id);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        resp.getWriter().println(ret);
    }
}