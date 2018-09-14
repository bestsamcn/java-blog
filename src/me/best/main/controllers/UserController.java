package me.best.main.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
@WebServlet(urlPatterns = {"/user/*"})
public class UserController extends BaseController {

    //新增用户
    public void add(HttpServletRequest req, HttpServletResponse resp){

    }
}
