package com.majortom.servlet;

import com.google.gson.Gson;
import com.majortom.entity.*;
import com.majortom.service.*;
import com.majortom.utils.Constant;
import lombok.SneakyThrows;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李文海
 * @version 1.0
 * @desc 处理用户的设置请求
 * @date 2020.01.06. \ 19:17
 * @copyright &copy; xuetang9
 * @address
 */
@WebServlet("/sett/*")
public class UserPageSettServlet extends HttpServlet {
    private DiskFileItemFactory factory = new DiskFileItemFactory();
    private MovieGroupService movieGroupService = new MovieGroupService();
    private MovieGroupInfoService movieGroupInfoService = new MovieGroupInfoService();
    private ImagesService imagesService = new ImagesService();
    private IdentificationService service = new IdentificationService();
    private UserService userService = new UserService();
    @SneakyThrows
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String path = req.getRequestURI();
      String op = path.substring(path.lastIndexOf("/"+1));
      if (Constant.OWNPAGE.equals(op)){
          ownPage(req, resp);
      }else if (Constant.APPLY.equals(op)){
              apply(req, resp);
      }else if (Constant.SAFETY.equals(op)){
          safety(req, resp);
      }else if (Constant.OWNINFO.equals(op)){
            ownInfo(req, resp);
      }else if (Constant.AUTONYM.equals(op)){
            autonym(req, resp);
      }
    }

    /**
     * 个人首页信息
     * @param request
     * @param response
     */
    private void ownPage(HttpServletRequest request,HttpServletResponse response){

    }

    /**
     * 申请观影团
     * @param request
     * @param response
     */
    private void apply(HttpServletRequest request,HttpServletResponse response) throws Exception {
       ServletFileUpload uploader = new ServletFileUpload(factory);
        PrintWriter writer = response.getWriter();
        Images images = new Images();
        MovieGroup movieGroup = new MovieGroup();
        MovieGroupInfo movieGroupInfo = new MovieGroupInfo();
        long size = 0;
        String imgPath = "";
        String groupName = "";
        String autograph = "";
        String intro = "";
        //读取图片和数据，解析
        if (ServletFileUpload.isMultipartContent(request)){
            String rootPath = request.getSession().getServletContext().getRealPath("/images/movieGroup");
            List<FileItem> fileItems = uploader.parseRequest(request);
            for (FileItem fileItem : fileItems) {
                if (!fileItem.isFormField()){
                    String imgname = fileItem.getName();
                    size = fileItem.getSize();
                    String path = rootPath+imgname;
                    fileItem.write(new File(path));
                    imgPath = "images/movieGroup/"+imgname;
                }else {
                    String fileName = fileItem.getFieldName();
                    if ("teamName".equals(fileName)){
                        String name = fileItem.getString("utf-8");
                        //判断团名是否可用
                        if (movieGroupService.queryByName(name)){
                            writer.write("false");
                            writer.flush();
                        }else {
                            groupName = name;
                        }

                    }else if ("autograph".equals(fileName)){
                        autograph = fileItem.getString("utf-8");
                    }else if ("intro ".equals(fileName)){
                        intro = fileItem.getString("utf-8");
                    }
                }
            }
            //图片设定，传入就用他的，没有默认给一张
            if (size != 0 ){
                images.setImgUrl(imgPath);
                imagesService.add(images);
            }else {
                images = imagesService.getById(1L);

            }


            if (!"".equals(groupName) ){
                movieGroupInfo.setName(groupName);
                if(autograph.equals("")){

                movieGroupInfo.setAutograph("这家伙很懒，什么都没有说！！！");
                }else {
                    movieGroupInfo.setAutograph(autograph);
                }
                movieGroupInfo.setSynopsis(intro);
                movieGroupInfo.setCIId(images.getCIId());
                boolean succ = movieGroupInfoService.add(movieGroupInfo) ;
                if (!succ){
                    writer.write("false");
                    writer.flush();
                }else {
                    movieGroup.setMInfoId(movieGroupInfo.getMInfoId());
                    movieGroup.setLevel(1L);
                    movieGroup.setYMoney(0L);
                    movieGroupService.add(movieGroup);
                    writer.write("ture");
                    writer.flush();
                }
            }


        }
    }

    /**
     * 安全中心
     * @param request
     * @param response
     */
    private void safety(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("current");
        PrintWriter writer = response.getWriter();
        Map<String,Object> info = new HashMap<>();
        if (user == null){

        }else {
            info.put("user",user);
            Identification identification = service.getByColumn("user_id",user.getUserId()).get(0);
            info.put("identification",identification);
            Gson gson = new Gson();
            String maper = gson.toJson(info);
            writer.write(maper);
            writer.flush();
        }
    }

    /**
     * 个人信息设置
     * @param request
     * @param response
     */
    private void ownInfo(HttpServletRequest request,HttpServletResponse response) throws ParseException, IOException {
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("current");
        String nickName = request.getParameter("nickname");
        String birthday = request.getParameter("date");
        String sex = request.getParameter("sex");
        if (sex.equals("男")){
            user.setGender(0);
        }else if (sex.equals("女")){
            user.setGender(1);
        }else if (sex.equals("保密")){
            user.setGender(2);
        }
        String autograph = request.getParameter("autograph");
        user.setNickName(nickName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(simpleDateFormat.parse(birthday));
        userService.update(user);
        Identification identification = service.getByColumn("user_id", user.getUserId()).get(0);
        identification.setAutograph(autograph);
        service.update(identification);
        writer.write("false");
        writer.flush();
    }

    /**
     * 实名认证
     * @param request
     * @param response
     */
    private void autonym(HttpServletRequest request,HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("current");
        Images images = new Images();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        String name = "";
        String idNum = "";
        String[] path = new String[3];
        if (ServletFileUpload.isMultipartContent(request)) {
            String rootPath = request.getSession().getServletContext().getRealPath("/images/movieGroup");
            List<FileItem> fileItems = uploader.parseRequest(request);
            for (int i = 0;i<fileItems.size();i++) {
                if (!fileItems.get(i).isFormField()) {
                    String imgname = fileItems.get(i).getName();
                    String relPath = rootPath + imgname;
                    fileItems.get(i).write(new File(relPath));
                    path[i] = "images/movieGroup" + imgname;
                }else{
                    String fileName = fileItems.get(i).getFieldName();
                    if (fileName.equals("trueName")){
                        name = fileItems.get(i).getString("utf-8");
                    }else if (fileName.equals("trueNum")){
                        idNum = fileItems.get(i).getString("utf-8");}
//                    }else if (fileName.equals("telVerification")){
//
//                    }
                }
            }
        }
        String pathJson = new Gson().toJson(path);
        user.setUserName(name);
        user.setIdNum(idNum);
        userService.update(user);
        images.setImgUrl(pathJson);
        images.setBindId(user.getUserId());
        images.setType(1);
        imagesService.add(images);


    }

    private String gettelVerify(){
        return null;
    }

    /**
     * 电话短信验证
     * @param request
     * @param response
     */
    private void telVerify(HttpServletRequest request,HttpServletResponse response){

    }
}
