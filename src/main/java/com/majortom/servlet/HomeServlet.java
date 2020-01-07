package com.majortom.servlet;

import com.google.gson.Gson;
import com.majortom.entity.Activity;
import com.majortom.entity.Identification;
import com.majortom.entity.MovieGroupInfo;
import com.majortom.entity.User;
import com.majortom.service.ActivityService;
import com.majortom.service.IdentificationService;
import com.majortom.service.MovieGroupService;
import com.majortom.service.UserService;
import com.majortom.utils.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李文海
 * @version 1.0
 * @desc  主页请求处理
 * @date 2020.01.02. \ 20:14
 * @copyright &copy; xuetang9
 * @address
 */
@WebServlet("/home/*")
public class HomeServlet extends HttpServlet {
    private ActivityService activityServer = new ActivityService();
    private UserService userService = new UserService();
    private MovieGroupService moveGroupServer = new MovieGroupService();
    private IdentificationService service = new IdentificationService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        String op = path.substring(path.lastIndexOf("/")+1);
        if (Constant.HOME_SHOW.equals(op)){
            show(req, resp);
        }else if (Constant.SEEK.equals(op)){
            seek(req, resp);
        }
    }

    /**
     * 根据请求的页数取得对应页数的pageBean对象，设置在请求的Attribute中，然后进行页面的转发
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void show(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Map<String,Object> map = new HashMap<>();
        int currentPage = 1;
        int pageSize = 3;
        String strPage = request.getParameter("page");
        if (strPage!= null && strPage.matches(Constant.ENSURENUM)){
            currentPage = Integer.parseInt(strPage);
        }
        List<Activity> activities = activityServer.queryPage((currentPage-1)*pageSize,pageSize);
        System.out.println(activities);
        String[] paths = activityServer.queryImagePath(activities);
        List<MovieGroupInfo> movieGroupInfos = moveGroupServer.queryById(activities);
        map.put("activities",activities);
        map.put("path",paths);
        map.put("moveInfo",movieGroupInfos);
        PrintWriter writer = response.getWriter();
        Gson gson = new Gson();
        String maper = gson.toJson(map);
        writer.write(maper);
        writer.flush();
    }

    /**
     * 根据前端页面的搜索请求返回的用户,用户账号，观影团，活动的信息
     * @param request
     * @param response
     * @throws IOException
     */
    private void seek(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Map<String,Object> mapJson = new HashMap<>();
        String info = request.getParameter("seek");
        List<User> users = userService.queryByNickName(info);
        List<MovieGroupInfo> moveGroups = moveGroupServer.queryByNameDim(info);
        List<Activity> activities = activityServer.queryByNameDim(info);
        Gson gson = new Gson();
        PrintWriter writer = response.getWriter();
        mapJson.put("users",users);
        mapJson.put("moveGroups",moveGroups);
        mapJson.put("activities",activities);
        String to = gson.toJson(mapJson);
        writer.write(to);
        writer.flush();
    }
}
