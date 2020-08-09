package com.atkjs927.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class FileDownloadController {

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {

        ServletContext context = request.getServletContext();
        String realPath = context.getRealPath("/download/test123");
        FileInputStream is = new FileInputStream(realPath);

        byte[] tmp = new byte[is.available()];
        is.read(tmp);
        is.close();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Disposition", "attachment;filename=" + "test.txt");
        return new ResponseEntity<byte[]>(tmp, httpHeaders, HttpStatus.OK);
    }

}
