package me.best.main.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 控制器基类
 */
public class BaseController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pathInfo = req.getPathInfo();
        String path = pathInfo.substring(1);
        try{
            Method method = this.getClass().getDeclaredMethod(path, HttpServletRequest.class, HttpServletResponse.class);
            System.out.println(method+" method");
            method.invoke(this, req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
