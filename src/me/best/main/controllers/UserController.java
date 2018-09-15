package me.best.main.controllers;

import me.best.main.services.FactoryService;
import net.sf.json.JSONObject;

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
}
