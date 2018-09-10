package me.best.main.controllers;

import me.best.main.dao.FactoryDao;
import me.best.main.models.Tag;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;


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
        Tag tag = FactoryDao.getTagDao().getById(req.getParameter("id"));
        System.out.println("hahahha");
        System.out.println(tag.getId()+" :tagId");
        try{
            JSONObject json = JSONObject.fromObject(tag);
            reps.getWriter().println(json);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}