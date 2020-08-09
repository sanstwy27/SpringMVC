package com.atkjs927.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    @Autowired
    private ServletContext servletContext;


    @RequestMapping("/upload")
    public String upload(@RequestParam(value = "username", required = false) String username,
                         @RequestParam("headerimg")MultipartFile[] file,
                         Model model) {

        for(MultipartFile multipartFile : file) {
            if(!multipartFile.isEmpty()) {
                System.out.println("上傳文件的訊息");
                System.out.println("文件的名字" + multipartFile.getName());
                System.out.println("文件的名字" + multipartFile.getOriginalFilename());

                File target = new File(servletContext.getRealPath("/upload/") + multipartFile.getOriginalFilename());
                target.getParentFile().mkdirs();
                try {
                    multipartFile.transferTo(target);
                    model.addAttribute("msg", "文件上傳成功了! ");
                } catch (IOException e) {
                    model.addAttribute("msg", "文件上傳失敗了! ");
                }
            }
        }

        return "forward:/index.jsp";
    }

    /*
    @RequestMapping("/upload")
    public String upload(@RequestParam(value = "username", required = false) String username,
                         @RequestParam("headerimg")MultipartFile file,
                         Model model) {

        System.out.println("上傳文件的訊息");
        System.out.println("文件的名字" + file.getName());
        System.out.println("文件的名字" + file.getOriginalFilename());


        try {
            File target = new File(servletContext.getRealPath("/upload/") + file.getOriginalFilename());
            target.getParentFile().mkdirs();
            file.transferTo(target);
            model.addAttribute("msg", "文件上傳成功了! ");
        } catch (IOException e) {
            model.addAttribute("msg", "文件上傳失敗了! ");
        }

        return "forward:/index.jsp";
    }
     */


}
