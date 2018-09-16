package me.best.main.controllers;

import me.best.main.models.User;
import me.best.main.services.FactoryService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
@WebServlet(urlPatterns = {"/user/*"})
public class UserController extends BaseController {

    //新增用户
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        JSONObject ret = FactoryService.getUserService().add(account, password);
        resp.getWriter().println(ret);
    }

    //删除用户
    public void delete (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        JSONObject ret = FactoryService.getUserService().delete(id);
        resp.getWriter().println(ret);
    }

    //获取用户
    public void getById (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        JSONObject ret = (JSONObject) FactoryService.getUserService().getById(id, false);
        resp.getWriter().println(ret);
    }

    //编辑用户
    public void edit (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        JSONObject ret = FactoryService.getUserService().edit(id, email, mobile);
        resp.getWriter().println(ret);
    }
}
