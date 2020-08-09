package com.atkjs927.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionTestController {

    @RequestMapping("/handle01")
    public String handle01(Integer i) {
        System.out.println("handle01...");
        System.out.println(10 / i);
        return "success";
    }

    //@ResponseStatus(reason = "反正我錯誤了", value = HttpStatus.NOT_EXTENDED)
    @ExceptionHandler(value = {ArithmeticException.class})
    public ModelAndView handleException01(Exception exception) {
        System.out.println("本類handleException01..." + exception);

        ModelAndView view = new ModelAndView("myerror");
        view.addObject("ex", exception);

        return view;
    }

    @RequestMapping("/handle02")
    public String handle02(@RequestParam("username") String name) {
        if(!"admin".equals(name)) {
            System.out.println("登入失敗...");
            throw new UserNameNotFoundExceptinon();
        }
        System.out.println("登入成功!...");
        return "success";
    }

    @RequestMapping(value = "/handle03", method = RequestMethod.POST)
    public String handle03(Integer i) {
        System.out.println("handle03...");
        return "success";
    }

    @RequestMapping(value = "/handle04")
    public String handle04() {
        System.out.println("handle04...");
        String str = null;
        str.equals("test");
        return "success";
    }

}
