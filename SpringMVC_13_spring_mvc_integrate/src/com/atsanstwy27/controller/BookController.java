package com.atkjs927.controller;

import com.atkjs927.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    public BookController() {
        System.out.println("BookController...");
    }

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello...");
        return "hello";
    }

}
