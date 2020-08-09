package com.atkjs927.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MyViewResolverController {

    @RequestMapping("/handleplus")
    public String handleplus(Model model){
        List<String> name=new ArrayList<String>();
        name.add("你好");
        name.add("hh");
        List<String> imgs=new ArrayList<String>();
        imgs.add("哈哈哈");
        model.addAttribute("video", name);
        model.addAttribute("imgs", imgs);
        return "mei:/login123";
    }

}