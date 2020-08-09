package com.atkjs927.controller;

import com.atkjs927.bean.Teacher;
import com.atkjs927.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping("/getTea")
    public String getTeacher(@RequestParam(value = "id", defaultValue = "1") Integer id, Model model) {
        Teacher t = teacherService.getTeacher(id);
        model.addAttribute("teacher", t);
        return "success";
    }

    @RequestMapping("/getall")
    public String getAll(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 5);
        List<Teacher> list = teacherService.getAll();

        // PageInfo<>(結果, 要連續的數組)
        PageInfo<Teacher> info = new PageInfo<>(list, 7);
        System.out.println("當前頁碼: " + info.getPageNum());
        System.out.println("總頁碼: " + info.getPages());
        System.out.println("總記錄數: " + info.getTotal());
        System.out.println("當前頁有幾條紀錄: " + info.getSize());
        System.out.println("當前頁的pagesize: " + info.getPageSize());
        System.out.println("前一頁: " + info.getPrePage());

        model.addAttribute("info", info);
        return "success";
    }

}
