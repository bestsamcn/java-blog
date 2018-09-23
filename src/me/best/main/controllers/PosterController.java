package me.best.main.controllers;

import me.best.main.services.FactoryService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Sam
 * @Date: 2018/9/23 20:23
 */
@WebServlet(urlPatterns = {"/poster/*"})
public class PosterController extends BaseController {

    //新增
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        JSONObject ret = FactoryService.getPosterService().add(req);
        resp.getWriter().println(ret);
    }

    //查看
    public void getImage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
         FactoryService.getPosterService().getImage(req, resp);
    }
}
