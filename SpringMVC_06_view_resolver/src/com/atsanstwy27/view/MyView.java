package com.atkjs927.view;

/*
 * 自定義視圖
 */

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class MyView implements View {

    @Override
    public String getContentType() {
        // TODO Auto-generated method stub
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request,
                       HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("之前保存的數據"+model);
        response.setContentType("text/html");
        response.setContentType("text/html; charset=UTF-8");
        List<String> vn=(List<String>) model.get("video");
        response.getWriter().write("哈哈哈哈<h1>即將展現精彩內容</h1>");
        for(String string:vn)
        {
            response.getWriter().write("<a>下載"+string+"</a>");
        }
    }

}
