package com.atkjs927.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * SpringMVC除過在方法上傳入原生的request和session外還能怎麼樣把數據帶給頁面
 *
 * 1）、可以在方法處傳入Map、或者Model或者ModelMap。
 *      給這些參數里面保存的所有數據都會放在請求域中。可以在頁面獲取
 *   關係：
 *      Map，Model，ModelMap：最終都是BindingAwareModelMap在工作；
 *      相當於給BindingAwareModelMap中保存的東西都會被放在請求域中；
 *
 *      Map(interface(jdk))      Model(interface(spring))
 *          ||                          //
 *          ||                         //
 *          \/                        //
 *      ModelMap(clas)               //
 *                  \\              //
 *                   \\            //
 *                  ExtendedModelMap
 *                          ||
 *                          \/
 *                  BindingAwareModelMap
 *
 * 2）、方法的返回值可以變為ModelAndView類型；
 *          既包含視圖信息（頁面地址）也包含模型數據（給頁面帶的數據）；
 *          而且數據是放在請求域中；
 *          request、session、application；
 * 3)、@SessionAttributes(value = "msg"): 不推薦用
 *      指定保存數據
 *
 * @author lfy
 *
 */
@SessionAttributes(value = {"msg"}, types={String.class})
@Controller
public class OutputController {

    @RequestMapping("/handle01")
    public String handle01(Map<String, Object> map){
        map.put("msg", "你好");
        map.put("haha", "哈哈");
        System.out.println("map的類型："+map.getClass());
        return "success";
    }

    /**
     * Model：一個接口
     * @param model
     * @return
     */
    @RequestMapping("/handle02")
    public String handle02(Model model){
        model.addAttribute("msg", "你好壞！");
        model.addAttribute("haha", 18);
        System.out.println("model的類型："+model.getClass());
        return "success";
    }

    @RequestMapping("/handle03")
    public String handle03(ModelMap modelMap){
        modelMap.addAttribute("msg", "你好棒！");
        System.out.println("modelmap的類型："+modelMap.getClass());
        return "success";
    }

    /**
     * 返回值是ModelAndView;可以為頁面攜帶數據
     * @return
     */
    @RequestMapping("/handle04")
    public ModelAndView handle04(){
        //之前的返回值我們就叫視圖名；視圖名視圖解析器是會幫我們最終拼串得到頁面的真實地址；
        //ModelAndView mv = new ModelAndView("success");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        mv.addObject("msg", "你好哦！");
        return mv;

    }
}