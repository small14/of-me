package com.sakura.ofm;

import com.sakura.ofm.entity.Author;
import com.sakura.ofm.entity.User;
import com.sakura.ofm.model.DefaultResponseModel;
import com.sakura.ofm.service.UserAuthorService;
import com.sakura.ofm.tools.TokenHelper;
import org.apache.catalina.filters.RemoteIpFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.rmi.Remote;
import java.util.List;

@Configuration
public class IpFilter {

    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new RequestIPFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        //filterRegistrationBean.addInitParameter("name","value");//初始化参数需要才设置
        filterRegistrationBean.setName("RequestIPFilter");
        filterRegistrationBean.setOrder(1);//设置过滤器执行顺序 从小到大执行
        return filterRegistrationBean;
    }

    public class RequestIPFilter implements Filter{


        private  final Logger logger = LoggerFactory.getLogger(RequestIPFilter.class);
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            String url = request.getRequestURI();

            if (!((url.contains("css"))||(url.contains("fonts"))||(url.contains("img"))||(url.contains("js")))){
                logger.info("用户访问,IP :"+request.getRemoteAddr()+";地址："+url);
            }

            DefaultResponseModel responseModel = new DefaultResponseModel();
            responseModel.setBaseUrl(request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/");
            servletRequest.setAttribute("responseModel",responseModel);
            filterChain.doFilter(servletRequest,servletResponse);
        }

        @Override
        public void destroy() {

        }
    }

}
