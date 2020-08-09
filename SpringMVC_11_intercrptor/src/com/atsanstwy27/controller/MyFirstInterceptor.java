package com.atkjs927.controller;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 *
 *  單個 攔截器運行流程：
 *   正常運行流程：
 *    攔截器的preHandle-->目標方法--->攔截器postHandle-->頁面--->攔截器的afterCompletion；
 *   其他流程：
 *     只要preHandler不放行，就沒有其他流程
 *     只要放行了 afterCompletion都會執行
 *  多個攔截器：
 *   異常流程：
 *    1、不放行 哪一塊不放行，從此以後都沒有
 *      要注意的是：MySecondInterceptor不放行，但是他前面已經放行了的攔截器的afterCompletion總會執行的
 */
public class MyFirstInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyFirstInterceptor...preHandle...");
        return true;
    }

    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyFirstInterceptor...postHandle...");
    }

    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyFirstInterceptor...afterCompletion...");
    }

}
