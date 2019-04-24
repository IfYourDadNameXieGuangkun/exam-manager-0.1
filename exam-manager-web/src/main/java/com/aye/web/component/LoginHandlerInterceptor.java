package com.aye.web.component;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Aye
 * @version $Id: LoginHandlerInterceptor, v 0.1 2019/3/26 21:37 Aye Exp$
 * 自定义拦截器接口 供addInterceptors 使用
 */

public class LoginHandlerInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory
            .getLogger(LoginHandlerInterceptor.class);
    //目标方法执行之前

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        logger.debug("请求到达后台方法之前调用(controller之前)");
        Object user = request.getSession().getAttribute("loginUser");
        if (null!=user){
            return true;
        }else {
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
