package com.majortom.servlet;

import com.majortom.entity.Activity;
import com.majortom.entity.Images;
import com.majortom.entity.Videos;
import com.majortom.service.ActivityService;
import com.majortom.service.ImagesService;
import com.majortom.service.VideosService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


@WebServlet("/activity/*")
public class ActivityServlet extends HttpServlet {
    private ActivityService activityService= new ActivityService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        String op = path.substring(path.lastIndexOf('/')+1);
        if("post".equals(op)){
            Activity activity = new Activity();
            boolean b = ServletFileUpload.isMultipartContent(req);
            if(b){
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                try {
                    List<FileItem> items = upload.parseRequest(new ServletRequestContext(req));
                    insertActivity(req,resp,activity,items);
                } catch (FileUploadException e) {
                    e.printStackTrace();
                }
            }
        }else if("get".equals(op)){
            int id = Integer.parseInt(req.getParameter("a_id"));
            resp.getWriter().write(jsonActivity(id));
        }
    }

    private String jsonActivity(int id) {
        return null;
    }

    private boolean insertActivity(HttpServletRequest req, HttpServletResponse resp, Activity activity,List<FileItem> items) {
        InputStream in = null;
        String movieName ="";
        String movieIntro="";
        boolean success = false;
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        try {
            for (FileItem item : items) {
                if (item.isFormField()) {
                    switch (item.getFieldName()){
                        case "title":
                            if(!"".equals(getItem(item)))activity.setTitle(getItem(item));
                            break;
                        case "m_id":
                            if(!"".equals(getItem(item)))activity.setMId(Long.parseLong(getItem(item)));
                            break;
                        case "strart_time":
                            if(!"".equals(getItem(item)))activity.setStrartTime(dataFormat.parse(getItem(item)));
                            break;
                        case "strart_apply_time":
                            if(!"".equals(getItem(item)))activity.setStrartApplyTime(dataFormat.parse(getItem(item)));
                            break;
                        case "end_apply_time":
                            if(!"".equals(getItem(item)))activity.setEndApplyTime(dataFormat.parse(getItem(item)));
                            break;
                        case "end_time":
                            if(!"".equals(getItem(item)))activity.setEndTime(dataFormat.parse(getItem(item)));
                            break;
                        case "movie_strart_time":
                            if(!"".equals(getItem(item)))activity.setMovieStrartTime(dataFormat.parse(getItem(item)));
                            break;
                        case "movie_end_time":
                            if(!"".equals(getItem(item)))activity.setMoveEndTime(dataFormat.parse(getItem(item)));
                            break;
                        case "date":
                            if(!"".equals(getItem(item)))activity.setMoiveLength(Long.parseLong(getItem(item)));
                            break;
                        case "quiz1":
                            if(!"".equals(getItem(item)))activity.setCity(getItem(item));
                            break;
                        case "quiz2":
                            if(!"".equals(getItem(item)))activity.setCity(activity.getCity()+getItem(item));
                            break;
                        case "address":
                            if(!"".equals(getItem(item)))activity.setCinemaAddress(getItem(item));
                            break;
                        case "phone":
                            if(!"".equals(getItem(item)))activity.setTel(getItem(item));
                            break;
                        case "content":
                            if(!"".equals(getItem(item)))activity.setContent(getItem(item));
                            break;
                        case "movie_name":
                            if(!"".equals(getItem(item)))movieName =getItem(item);
                            break;
                        case "intro":
                            if(!"".equals(getItem(item)))movieIntro =getItem(item);
                            break;
                        default:
                            break;
                    }
                }else{
                    try {
                        in = item.getInputStream();
                        System.out.println("jin:"+in.available());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        success = activityService.add(activity);
        if(null!=in)
            return success && insertImages(activity,in,movieName,movieIntro);
        else
            return false;
    }

    public String getItem(FileItem item){
        InputStream in = null;
        BufferedReader bf= null;
        StringBuffer buffer=new StringBuffer();
        String line="";
        try {
            in = item.getInputStream();
            bf = new BufferedReader(new InputStreamReader(in,"UTF-8"));
            while((line=bf.readLine())!=null){
                buffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
    public boolean insertImages(Activity activity,InputStream in,String movieName,String movieIntro){
        Images images = new Images();
        ImagesService imagesService = new ImagesService();
        VideosService videosService = new VideosService();
        images.setBindId(activity.getAId());
        images.setType(3);
        boolean success =imagesService.add(images);
        images.setImgUrl("/images/"+activity.getAId()+"/"+images.getCIId()+".jpg");
        success = success && imagesService.update(images);

        Videos video = new Videos(null, images.getCIId(), movieName, movieIntro);
        success = success && videosService.add(video);

        activity.setVId(video.getVId());
        success = success && activityService.update(activity);


        try {
            File file = new File(this.getServletContext().getRealPath("/images/") + "/" + activity.getMId() + "/" + images.getCIId()+".jpg");
            if(!file.exists()){
                //先得到文件的上级目录，并创建上级目录，在创建文件
                file.getParentFile().mkdir();
                try {
                    //创建文件
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            OutputStream out = new FileOutputStream(file);
            IOUtils.copy(in, out);
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return success;
    }
}
