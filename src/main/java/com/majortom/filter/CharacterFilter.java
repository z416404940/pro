package com.majortom.filter;
import	java.net.URLDecoder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author 李文海
 * @version 1.0
 * @desc 对字符编码进行过滤处理,所有请求与响应都要经过这个过滤器
 * @date 2020.01.02. \ 11:15
 * @copyright &copy; xuetang9
 * @address
 */
@WebFilter("/*")
public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String path = HttpServletRequest.class.cast(request).getRequestURI();
        path = URLDecoder.decode(path,"UTF-8");
        if(path.endsWith(".jpg") || path.endsWith(".BMP") || path.endsWith(".JPEG") || path.endsWith(".PNG") || path.endsWith(".GIF")){

        }
//        System.out.println(path);

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
