package com.atkjs927.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public String nihao() {
        return "success";
    }

    @RequestMapping("/hello01")
    public String hanle01() {
        System.out.println("handle01....");
        return "error";
    }

    @RequestMapping("/hello02")
    public String hanle02() {
        System.out.println("handle02....");
        return "success";
    }
}
