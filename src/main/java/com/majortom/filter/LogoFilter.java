package com.majortom.filter;



import com.majortom.entity.*;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author 李文海
 * @version 1.0
 * @desc 对登录状态进行过滤，取得会话中的用户（如果有的话），对其进行权限赋予
 * @date 2020.01.02. \ 12:00
 * @copyright &copy; xuetang9
 * @address
 */
//@WebFilter("/*")
public class LogoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String[] passPath = {"/sett","/","/html","/home","/logo.jsp","/logo","/css","/js","/index.jsp","/lib","/jsp","/state"};
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String uri = req.getRequestURI();
//        取得会话中的用户
        User current = (User) session.getAttribute("currentUser");
        boolean pass = false;
//        判断请求路径是否通过
        for (String s : passPath) {
            if (s.equals(uri) || uri.startsWith(s)){
                System.out.println(s);
                System.out.println(uri);
                pass = true;
                break;
            }

        }
        //会话当中有用户并且请求路径不被通过
        if (current != null && !pass){
//            List<Privilege> privileges = current.getPrivileges();
//            List<Menu> menus = current.getMenus();
//            List<Folder> folders = current.getFolders();
//            List<PageElements> pageElements = current.getPageElements();
        }
        if (pass){
           chain.doFilter(request,response);
        }else {

            resp.sendRedirect(req.getContextPath() +"/home/show");
        }
    }

    @Override
    public void destroy() {

    }
}
