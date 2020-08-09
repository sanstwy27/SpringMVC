package com.atkjs927.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/haha")
public class RequestMappingTestController {

    @RequestMapping("/handle01")
    public String handle01() {
        System.out.println("RequestMappingTestController...handle01");
        return "success";
    }

    @RequestMapping(value = "/handle02", method = RequestMethod.POST)
    public String handle02() {
        System.out.println("RequestMappingTestController...handle02");
        return "success";
    }

    @RequestMapping(value = "/handle03", params = {"username"})
    public String handle03() {
        System.out.println("RequestMappingTestController...handle03");
        return "success";
    }

    @RequestMapping(value = "/handle04", headers = {"User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:73.0) Gecko/20100101 Firefox/73.0"})
    public String handle04() {
        System.out.println("RequestMappingTestController...handle03");
        return "success";
    }

}
