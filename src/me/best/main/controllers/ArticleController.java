package me.best.main.controllers;

import me.best.main.services.FactoryService;
import me.best.main.utils.SessionUtils;
import me.best.main.utils.Utils;
import net.sf.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/article/*"})
public class ArticleController extends BaseController {

    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        HttpSession session = SessionUtils.getSession(Utils.getCookie(req, "JSESSIONID").getValue());
        String creator = (String) session.getAttribute("userId");

        String title = req.getParameter("title");
        String previewText = req.getParameter("previewText");
        String codeContent = req.getParameter("codeContent");
        String content = req.getParameter("content");
        String tag = req.getParameter("tag");
        String tagName = req.getParameter("tagName");
        String category = req.getParameter("category");
        String categoryName = req.getParameter("categoryName");
        String poster = req.getParameter("poster");

        JSONObject ret = FactoryService.getArticleService().add(creator, tag, tagName, category, categoryName, title, previewText, content, codeContent, poster);
        resp.getWriter().println(ret);
    }
    public void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        HttpSession session = SessionUtils.getSession(Utils.getCookie(req, "JSESSIONID").getValue());
        String creator = (String) session.getAttribute("userId");

        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String previewText = req.getParameter("previewText");
        String codeContent = req.getParameter("codeContent");
        String content = req.getParameter("content");
        String tag = req.getParameter("tag");
        String tagName = req.getParameter("tagName");
        String category = req.getParameter("category");
        String categoryName = req.getParameter("categoryName");
        String poster = req.getParameter("poster");

        JSONObject ret = FactoryService.getArticleService().edit(id, creator, tag, tagName, category, categoryName, title, previewText, content, codeContent,
                poster);
        resp.getWriter().println(ret);
    }

    public void getDetail(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String id = req.getParameter("id");
        JSONObject ret = FactoryService.getArticleService().getDetail(id);
        resp.getWriter().println(ret);
    }

    public void getList(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String pageIndex = req.getParameter("pageIndex");
        String pageSize = req.getParameter("pageSize");
        JSONObject ret= FactoryService.getArticleService().getList(pageIndex, pageSize);
        resp.getWriter().println(ret);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String id = req.getParameter("id");
        JSONObject ret = FactoryService.getArticleService().delete(id);
        resp.getWriter().println(ret);
    }

    public void addPoster(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        JSONObject ret = FactoryService.getArticleService().addPoster(req);
        resp.getWriter().println(ret);
    }
}
