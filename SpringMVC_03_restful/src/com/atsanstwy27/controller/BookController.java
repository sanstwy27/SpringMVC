package com.atkjs927.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    @RequestMapping(value = "/book/{bid}", method = RequestMethod.GET)
    public String getBook(@PathVariable("bid") Integer id) {
        System.out.println("查詢到了" + id + "號圖書");
        return "success";
    }

    @RequestMapping(value = "/book/{bid}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("bid") Integer id) {
        System.out.println("刪除了" + id + "號圖書");
        return "success";
    }

    @RequestMapping(value = "/book/{bid}", method = RequestMethod.PUT)
    public String updateBook(@PathVariable("bid") Integer id) {
        System.out.println("更新了" + id + "號圖書");
        return "success";
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String addBook() {
        System.out.println("增加了圖書");
        return "success";
    }

}
