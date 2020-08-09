package com.atkjs927.crud.controller;

import com.atkjs927.crud.dao.EmployeeDao;
import com.atkjs927.crud.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
public class AjaxTestController {

    @Autowired
    EmployeeDao employeeDao;


    //@ResponseBody
    @RequestMapping("/haha")
    public ResponseEntity<String> hahah() {
        HttpStatus statusCode = HttpStatus.OK;
        MultiValueMap<String, String> headers = new HttpHeaders();
        String body = "<h1>success</h1>";
        headers.add("Set-Cookie", "username=hahahaha");
        return new ResponseEntity<String>(body, headers, statusCode);
    }


    @RequestMapping("/test02")
    public String test02(HttpEntity<String> str) {
        System.out.println("請求體: " + str);
        return "success";
    }


    @RequestMapping("/test01")
    public String test01(@RequestBody String str) {
        System.out.println("請求體: " + str);
        return "success";
    }


    @RequestMapping("/testRequestBody")
    //public String testRequestBody(@RequestBody String body) {
    public String testRequestBody(@RequestBody Employee employee) {
        System.out.println("請求體: " + employee);
        return "success";
    }


    @ResponseBody
    @RequestMapping("/getallajax")
    public Collection<Employee> ajaxGetAll() {
        Collection<Employee> all = employeeDao.getAll();
        return all;
    }
}
