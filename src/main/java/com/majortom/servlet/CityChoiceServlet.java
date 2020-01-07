package com.majortom.servlet;

import com.google.gson.Gson;
import com.majortom.utils.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 李文海
 * @version 1.0
 * @desc 处理城市选择的拉取请求，接收前端的AJAX请求，返回对应的省份及省份下属城市/区
 * @date 2020.01.05. \ 11:13
 * @copyright &copy; xuetang9
 * @address
 */
@WebServlet("/cityChoice/*")
public class CityChoiceServlet extends HttpServlet {
//    private ProvinceServer provinceServer = new ProvinceServer();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        String op = path.substring(path.lastIndexOf("/")+1);
        if (Constant.PRO.equals(op)){

        }else if (Constant.CITY.equals(op)){

        }
    }

    /**
     * 通过AJAX 获取所有的省份信息
     * @param request
     * @param response
     */
    private void getProvince(HttpServletRequest request,HttpServletResponse response){
//        List<Province> provinces = provinceServer.getAll();
//        String provinceJson = new Gson().toJson(Constant);
//        response.getWriter().write(provinceJson);
    }

    private void getCity(HttpServletRequest request,HttpServletResponse response){
        String strId = request.getParameter("id");

    }
}
