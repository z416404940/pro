package com.majortom.servlet;

import com.google.gson.Gson;
import com.majortom.entity.Citys;
import com.majortom.entity.Province;
import com.majortom.service.CitysServer;
import com.majortom.service.ProvinceServer;
import com.majortom.utils.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
    private ProvinceServer provinceServer = new ProvinceServer();
    private CitysServer citysServer = new CitysServer();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        String op = path.substring(path.lastIndexOf("/")+1);
        if (Constant.PRO.equals(op)){
            getProvince(req, resp);
        }else if (Constant.CITY.equals(op)){
            getCity(req, resp);
        }
    }

    /**
     * 通过AJAX 获取所有的省份信息
     * @param request
     * @param response
     */
    private void getProvince(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        int count = provinceServer.count();
        List<Province> provinces = provinceServer.getByLimit(0,count);
        String provinceJson = new Gson().toJson(provinces);
        writer.write(provinceJson);
        writer.flush();
    }

    /**
     * 通过前端的省份请求返回所有的城市列表
     * @param request
     * @param response
     * @throws IOException
     */
    private void getCity(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        String strId = request.getParameter("id");
        long id = 0L;
        if (strId != null && strId.matches("^\\d+%")){
            id = Long.parseLong(strId);
            List<Citys> citys = citysServer.getByColumn("p_id",id);
            String json = new Gson().toJson(citys);
            writer.write(json);
            writer.flush();
        }

    }
}
