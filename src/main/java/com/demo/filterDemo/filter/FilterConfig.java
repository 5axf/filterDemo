package com.demo.filterDemo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * 注册自定义过滤器ben
 */
@Configuration
public class FilterConfig {

    @Bean
    public Filter myFilter(){
        return new myFilter();
    }

    @Bean
    public Filter myFilter2(){
        return new myFilter2();
    }

    @Bean
    public FilterRegistrationBean setmyFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(myFilter());
        filterRegistrationBean.addUrlPatterns("/*");//过滤请求路径
        filterRegistrationBean.setOrder(1);   //order的数值越小，在所有的filter中优先级越高
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean setmyFilter2(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(myFilter2());
        filterRegistrationBean.addUrlPatterns("/*");//过滤请求路径
        filterRegistrationBean.setOrder(2);   //order的数值越小，在所有的filter中优先级越高
        return filterRegistrationBean;
    }

}
