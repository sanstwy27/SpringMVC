package com.atkjs927.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyException {

    /*
    @ExceptionHandler(value = {ArithmeticException.class})
    public ModelAndView handleException01(Exception exception) {
        System.out.println("全局handleException01..." + exception);

        ModelAndView view = new ModelAndView("myerror");
        view.addObject("ex", exception);

        return view;
    }

    @ExceptionHandler(value = {Exception.class})
    public ModelAndView handleException02(Exception exception) {
        System.out.println("全局handleException02..." + exception);

        ModelAndView view = new ModelAndView("myerror");
        view.addObject("ex", exception);

        return view;
    }
    */

}
