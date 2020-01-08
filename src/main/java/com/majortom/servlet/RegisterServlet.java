package com.majortom.servlet;


import com.google.gson.Gson;
import com.majortom.entity.Identification;
import com.majortom.entity.Images;
import com.majortom.entity.MovieGroup;
import com.majortom.entity.User;
import com.majortom.service.IdentificationService;
import com.majortom.service.ImagesService;
import com.majortom.service.UserService;
import com.majortom.utils.Constant;
import com.majortom.utils.MD5Utils;


import javax.persistence.Id;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李文海
 * @version 1.0
 * @desc 登录与注册,注销处理
 * @date 2020.01.01.
 * @copyright &copy; xuetang9
 * @address
 */
@WebServlet("/state/*")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserService();
    private IdentificationService service = new IdentificationService();
    private ImagesService imagesService = new ImagesService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        String op = path.substring(path.lastIndexOf("/")+1);
        if (Constant.ENTER.equals(op)){
            enter(req,resp);
        }else if (Constant.REGISTER.equals(op)){
            register(req, resp);
        }else if (Constant.LOGOUT.equals(op)){
            logout(req, resp);
        }else if (Constant.LOG.equals(op)){
            log(req,resp);
        }else if (Constant.JUDGE.equals(op)){
            judgeUserName(req, resp);
        }

    }

    /**
     * 登录
     * @param request
     * @param response
     */
    private void enter(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String account = request.getParameter("loadName");
        String password = request.getParameter("loadPass");
        PrintWriter writer = response.getWriter();
        String md5password = MD5Utils.MD5Encode(password,"utf-8");
        if (account == null){
            account = "";
        }
        User user = userService.queryUserByEmailOrTel(account);
        if (user== null){
            response.sendRedirect("/html/register.html");
        }
        if (user!=null && md5password.equals(user.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("current",user);
            session.setMaxInactiveInterval(3600);
            Map<String,Object> mapJSon = new HashMap<>();
            int id = Math.toIntExact(user.getUserId());
            MovieGroup movieGroup = userService.queryMovieGroupByUserId(id);
            int type = userService.queryMovieGroupTypeByUserId(Math.toIntExact(user.getUserId()));
            mapJSon.put("user",user);
            mapJSon.put("movieGroup",movieGroup);
            mapJSon.put("type",type);
            String userJosn = new Gson().toJson(mapJSon);
            writer.write(userJosn);
            response.sendRedirect("/html/homePage.html");
        }
    }

    /**
     * 处理前端用户登录信息显示的请求，前端通过AJAX请求，此处返回会话对象中的用户信息
     * @param request
     * @param response
     * @throws IOException
     */
    private void log(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        Gson gson = new Gson();
        Map<String,Object> mapJson = new  HashMap<>();
        Identification identification = null;
        User user = (User) session.getAttribute("current");
        if (user == null){
            String userJosn = new Gson().toJson(user);
            System.out.println(userJosn);
            writer.write(userJosn);
            writer.flush();
        }else {
            identification = service.getByColumn("user_id",user.getUserId()).get(0);
            Images images = imagesService.getById(identification.getCIId());

            mapJson.put("user",user);
            mapJson.put("identification",identification);
            mapJson.put("image",images);
            String userJosn = new Gson().toJson(mapJson);
            System.out.println("log中的json:"+userJosn);
            writer.write(userJosn);
            writer.flush();
        }


    }

    /**
     * 实时验证注册用户名的可用性
     * @param request
     * @param response
     * @throws IOException
     */
    private void judgeUserName(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String account = request.getParameter("registerName");
        User user = userService.queryUserByEmailOrTel(account);
        PrintWriter writer = response.getWriter();
        if (user != null){
            writer.write("false");
            writer.flush();
        }else {
            writer.write("true");
            writer.flush();
        }
    }

    /**
     * 注册
     * @param request
     * @param response
     */
    private void register(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String account = request.getParameter("registerName");
        String password = request.getParameter("registerPass");
//        boolean nothing = "".equals(password);
        String md5password = MD5Utils.MD5Encode(password,"utf-8");
        User user = userService.queryUserByEmailOrTel(account);

        int type = -1;
        if (user==null && account.contains(Constant.AT)){
            type = 1;
            toRegister(response, account, md5password, type);
        }else if (user==null){
            type = 2;
            toRegister(response, account, md5password, type);
        }


    }

    /**
     * 注销
     * @param request
     * @param response
     */
    private void logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("current");
//        跳转至主页
        String Josn = new Gson().toJson(null);
        response.getWriter().write(Josn);
        response.sendRedirect("/html/homePage.html");
    }

    /**
     * 创建用户对象，根据注册信息保存至数据库，并根据存入状态跳转或返回信息
     * @param response
     * @param account
     * @param md5password
     * @param type
     * @throws IOException
     */
    private void toRegister(HttpServletResponse response, String account, String md5password, int type) throws IOException {
        User newUser = new User();
        newUser.setNickName(account);
        if (type ==1) {
            newUser.setEmail(account);
        }else if (type ==2){
            newUser.setTel(account);
        }
        newUser.setPassword(md5password);
        System.out.println(newUser);
        boolean add = userService.add(newUser);
        if (add){
//                    重定向至的登录界面
            response.getWriter().write(account);
            response.sendRedirect("/html/register.html");
        }else {
            response.getWriter().write("false");
        }
    }
}
