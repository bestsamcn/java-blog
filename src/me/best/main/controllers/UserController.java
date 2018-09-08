package me.best.main.controllers;

import me.best.main.dao.FactoryDao;
import me.best.main.dao.UserDaoIml;
import me.best.main.models.User;
import me.best.main.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(urlPatterns = {"/user/*"})
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello java blog");
        Connection conn = JdbcUtils.getConnection();
        List<User> userList = FactoryDao.userDaoIml.getAll();
        for(User user: userList ){
            System.out.println(user.getAccount()+" :userid");
        }
        System.out.println(userList+": userid");
        System.out.println(conn+" :conn");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        String a = req.getRequestURI();
        String i = req.getPathInfo();
        String p = req.getParameter("a");
        System.out.println(a+" :getServletPath");
        System.out.println(path+" :getServletPath");
        System.out.println(i+" :getPathInfo");
        System.out.println(p+" :getParameter");
    }
}
