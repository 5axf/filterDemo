package com.demo.filterDemo.filter;


import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * pom.xml文件中导入依赖
 *
 *      <dependency>
 * 			<groupId>javax.servlet</groupId>
 * 			<artifactId>javax.servlet-api</artifactId>
 * 		</dependency>
 *
 */
//使用注解的形式在启动类上加上 @ServletComponentScan 扫描自定义的过滤器bean
//@WebFilter(filterName = "myFilter2",urlPatterns = "/*")
//@Order(2)
//    使用注解的方式如果有多个过滤器将无法进行设置启动顺序

//    采用注册bean的方式可以设置启动顺序 -- FilterConfig
public class myFilter2 implements Filter {

    //过滤初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    //过滤
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("Filter1 processing----------->222222222222");

        //设置编码格式
        response.setCharacterEncoding("UTF-8");
        //这句话是解决乱码的
        response.setContentType("text/html;charset=UTF-8");


        chain.doFilter(request, response);

        System.out.println("URL---->"+request.getProtocol());
        System.out.println("SERVERPort--->"+request.getServerPort());
        System.out.println("ContentType---->"+request.getContentType());
        System.out.println("ENCODING---->"+request.getCharacterEncoding());
        System.out.println("IP---->"+request.getRemoteAddr());
        System.out.println("HOST---->"+request.getRemoteHost());
        System.out.println("REMO PORT---->"+request.getRemotePort());
    }

    //销毁
    @Override
    public void destroy() {

    }
}
