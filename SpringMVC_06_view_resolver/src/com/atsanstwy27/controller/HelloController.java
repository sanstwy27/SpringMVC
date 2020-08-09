package com.atkjs927.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {

        return "../../hello";
    }

    @RequestMapping("/handle01")
    public String handle01() {
        System.out.println("handle01");
        return "forward:/hello.jsp";
    }

    @RequestMapping("/handle02")
    public String handle02() {
        System.out.println("handle02");
        return "forward:/handle01";
    }

    /*
     * 重定向hello.jsp頁面
     * 重定向  redirect:/重定向路徑
     *     原生的Servlet重定向需要加上項目名才能成功
     *     redirect:/hello.jsp:就是從當前項目下開始，SpringMVC會為路逕自動的拼接上項目
     */

    @RequestMapping("/handle03")
    public String handle03(){
        System.out.println("重定向操作");
        return "redirect:/hello.jsp";
    }

    @RequestMapping("/handle04")
    public String handle04(){
        return "redirect:/handle03";
    }

    /*
    @RequestMapping("/toLoginPage")
    public String toLogin() {
        return "login";
    }
     */

}
