package me.best.filters;

import me.best.main.utils.SessionUtils;
import me.best.main.utils.Utils;
import net.sf.json.JSONObject;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/tag/*"})
public class CLoginFilter extends BaseFilter{
    @Override
    protected void doFilter (HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        Cookie[] cookies = req.getCookies();
        String jsessionid = null;
        Cookie cookieObj = null;
        if(cookies != null && cookies.length > 0){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("JSESSIONID")){
                    jsessionid = cookie.getValue();
                    cookieObj = cookie;
                }
            }
        }
        if(jsessionid != null && !jsessionid.isEmpty()){
            HttpSession session = SessionUtils.getSession(jsessionid);
            String userId = (String) session.getAttribute("userId");
            if(userId != null && userId.length() == 32){
                filterChain.doFilter(req, resp);
                return;
            }
        }
        req.getSession(false).removeAttribute("userId");
        req.getSession(false).invalidate();
        if(null != cookieObj){
            cookieObj.setMaxAge(0);
            resp.addCookie(cookieObj);
        }
        JSONObject ret = Utils.setResponse(-1, "请登陆", "null");
        resp.getWriter().println(ret);
    }
}
