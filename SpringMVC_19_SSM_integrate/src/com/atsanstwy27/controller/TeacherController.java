package com.atkjs927.controller;

import com.atkjs927.bean.Teacher;
import com.atkjs927.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
