package com.atkjs927.view;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class MyMeiViewResolyer implements ViewResolver, Ordered {

    private Integer order=0;

    @Override
    public View resolveViewName(String viewName, Locale locale)
            throws Exception {
        // TODO Auto-generated method stub
        //根據視圖名返回視圖對像
        //這個視圖名有很多
        if(viewName.startsWith("mei")){
            return new MyView();
        }
        else
        {
            //如果不能處理，返回null
            return null;
        }

    }

    @Override
    public int getOrder() {
        // TODO Auto-generated method stub
        return order;
    }

    /*
     * 改變視圖解析器的優先級
     */
    public void setOrder(Integer order){
        this.order=order;
    }

}