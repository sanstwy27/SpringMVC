package com.atkjs927.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * URL Fuzzy Match: ?, *, **
 *
 */
@Controller
public class RequestMappingTest {

    @RequestMapping("/antTest01")
    public String anTest01() {
        System.out.println("anTest01");
        return "success";
    }

    @RequestMapping("/antTest0?")
    public String anTest02() {
        System.out.println("anTest02");
        return "success";
    }

    @RequestMapping("/antTest0*")
    public String anTest03() {
        System.out.println("anTest03");
        return "success";
    }

    @RequestMapping("/a/*/antTest01")
    public String anTest04() {
        System.out.println("anTest04");
        return "success";
    }

    @RequestMapping("/a/**/antTest01")
    public String anTest05() {
        System.out.println("anTest05");
        return "success";
    }

    @RequestMapping("/user/{id}")
    public String anTest06(@PathVariable("id") String id) {
        System.out.println("anTest06: " + id);
        return "success";
    }



}
