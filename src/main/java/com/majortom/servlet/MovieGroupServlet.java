package com.majortom.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 李文海
 * @version 1.0
 * @desc 处理观影团的各项请求
 * @date 2020.01.06. \ 19:01
 * @copyright &copy; xuetang9
 * @address
 */
@WebServlet("/movieGroup/*")
public class MovieGroupServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String path = req.getRequestURI();
       String op = path.substring(path.lastIndexOf("/")+1);
        super.service(req, resp);
    }
    private void establish(HttpServletRequest request,HttpServletResponse response){

    }
}
