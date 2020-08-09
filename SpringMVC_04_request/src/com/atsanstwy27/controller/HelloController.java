package com.atkjs927.controller;

import com.atkjs927.book.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String handle01() {
        System.out.println("handle01...");
        return "success";
    }

    /**
     * SpringMVC如何獲取請求帶來的各種信息 默認方式獲取請求參數： 直接給方法入參上寫一個和請求參數名相同的變量。這個變量就來接收請求參數的值；
     * 帶：有值，沒帶：null；
     *
     * @RequestParam：獲取請求參數的；參數默認是必須帶的；
     * @RequestParam("user")String username username =
     *                             request.getParameter("user")
     *
     *
     * @RequestParam("user")
     * @PathVariable("user")
     *                       /book/【{user}pathvariable】?【user=admin(requestparam)
     *                       】
     *
     *                       value:指定要獲取的參數的key required:這個參數是否必須的
     *                       defaultValue:默認值。沒帶默認是null；
     *
     *
     * @RequestHeader：獲取請求頭中某個key的值； request.getHeader("User-Agent")；
     * @RequestHeader("User-Agent")String userAgent userAgent =
     *                                    request.getHeader("User-Agent")
     *                                    如果請求頭中沒有這個值就會報錯； value() required()
     *                                    defaultValue()
     *
     * @CookieValue：獲取某個cookie的值； 以前的操作獲取某個cookie； Cookie[] cookies =
     *                            request.getCookies(); for(Cookie c:cookies){
     *                            if(c.getName().equals("JSESSIONID")){ String
     *                            cv = c.getValue(); } }
     * value()
     * required()
     * defaultValue()
     */
    @RequestMapping("/handle01")
    public String handle02(
            @RequestParam(value = "user", required = false, defaultValue = "你沒帶") String username,
            @RequestHeader(value = "AHAHA", required = false, defaultValue = "她也沒帶") String userAgent,
            @CookieValue(value = "JSESSIONID", required = false) String jid) {
        System.out.println("這個變量的值：" + username);
        System.out.println("請求頭中瀏覽器的信息：" + userAgent);
        System.out.println("cookie中的jid的值" + jid);
        return "success";
    }

    /**
     * 如果我們的請求參數是一個POJO；
     * SpringMVC會自動的為這個POJO進行賦值？
     * 1）、將POJO中的每一個屬性，從request參數中嘗試獲取出來，並封裝即可；
     * 2）、還可以級聯封裝；屬性的屬性
     * 3）、請求參數的參數名和對像中的屬性名一一對應就行
     *
     *
     * 提交的數據可能有亂碼：
     * 請求亂碼：
     *         GET請求：改server.xml；在8080端口處URIEncoding="UTF-8"
     *         POST請求：
     *             在第一次獲取請求參數之前設置
     *             request.setCharacterEncoding("UTF-8");
     *             自己寫一個filter；SpringMVC有這個filter
     *
     * 響應亂碼：
     *         response.setContentType("text/html;charset=utf-8")
     * @param book
     * @return
     */
    @RequestMapping("/book")
    public String addBook(Book book) {
        System.out.println("我要保存的圖書：" + book);
        return "success";
    }

    /**
     * SpringMVC可以直接在參數上寫原生API;
     *
     * HttpServletRequest
     * HttpServletResponse
     * HttpSession
     *
     *
     * java.security.Principal
     * Locale：國際化有關的區域信息對像
     * InputStream：
     *         ServletInputStream inputStream = request.getInputStream();
     * OutputStream：
     *         ServletOutputStream outputStream = response.getOutputStream();
     * Reader：
     *         BufferedReader reader = request.getReader();
     * Writer：
     *         PrintWriter writer = response.getWriter();
     *
     * @throws IOException
     *
     *
     */
    @RequestMapping("/handle03")
    public String handle03(HttpSession session,
                           HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setAttribute("reqParam", "我是請求域中的");
        session.setAttribute("sessionParam", "額我是Session域中的");

        return "success";
    }

}
