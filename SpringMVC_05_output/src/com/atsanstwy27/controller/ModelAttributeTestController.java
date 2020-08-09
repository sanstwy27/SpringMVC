package com.atkjs927.controller;

import com.atkjs927.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 測試ModelAttribute註解；
 * 使用場景：書城的圖書修改為例；
 * 1）頁面端；
 *      顯示要修改的圖書的信息，圖書的所有字段都在
 * 2）servlet收到修改請求，調用dao；
 *      String sql="update bs_book set title=?,
 *                  author=?,price=?,
 *                  sales=?,stock=?,img_path=?
 *              where id=?";
 * 3）實際場景？
 *      並不是全字段修改；只會修改部分字段，以修改用戶信息為例；
 *      username  password  address;
 *      1）、不修改的字段可以在頁面進行展示但是不要提供修改輸入框；
 *      2）、為了簡單，Controller直接在參數位置來寫Book對像
 *      3）、SpringMVC為我們自動封裝book；（沒有帶的值是null）
 *      4）、如果接下來調用了一個全字段更新的dao操作；會將其他的字段可能變為null；
 *          sql = "update bs_book set"
 *          if(book.getBookName()){
 *              sql +="bookName=?,"
 *          }
 *          if(book.getPrice()){
 *              sql +="price=?"
 *          }
 *
 * 4）、如何能保證全字段更新的時候，只更新了頁面攜帶的數據；
 *      1）、修改dao；代價大？
 *      2）、Book對象是如何封裝的？
 *          1）、SpringMVC創建一個book對象，每個屬性都有默認值，bookName就是null；
 *              1、讓SpringMVC別創建book對象，直接從數據庫中先取出一個id=100的book對象的信息
 *              2、Book [id=100, bookName=西遊記, author=張三, stock=12, sales=32, price=98.98]
 *
 *          2）、將請求中所有與book對應的屬性一一設置過來；
 *              3、使用剛才從數據庫取出的book對象，給它 的裡面設置值；（請求參數帶了哪些值就覆蓋之前的值）
 *              4、帶了的字段就改為攜帶的值，沒帶的字段就保持之前的值
 *          3）、調用全字段更新就有問題；
 *              5、將之前從數據庫中查到的對象，並且封裝了請求參數的對象。進行保存；
 *
 * @author lfy
 */
@Controller
public class ModelAttributeTestController {

    private Object o1;
    private Object o2;

    private Object b1;
    private Object b2;

    //bookDao.update(book);
    //Book [id=100, bookName=null, author=張三, stock=12, sales=32, price=98.98]
    /**
     *      String sql="update bs_book set bookName=?,
     author=?,price=?,
     sales=?,stock=?,img_path=?
     where id=?";
     */
    /**
     * 可以告訴SpringMVC不要new這個book了我剛才保存了一個book；
     * 哪個就是從數據庫中查詢出來的；用我這個book?@ModelAttribute("haha")
     *
     *
     * 同都是BindingAwareModelMap
     * @param book
     * @return
     */
    @RequestMapping("/updateBook")
    public String updateBook(@ModelAttribute("haha") Book book, Map<String, Object> model) {
        o2 = model;
        b2 = book;
        Object haha = model.get("haha");
        //System.out.println("傳入的model："+model.getClass());
        System.out.println("o1==o2?" + (o1 == o2));
        System.out.println("b1==b2?" + (b1 == b2) + "-->" + (b2 == haha));

        System.out.println("頁面要提交過來的圖書信息：" + book);
        return "success";
    }

    /**
     * 1）、SpringMVC要封裝請求參數的Book對像不應該是自己new出來的。
     *      而應該是【從數據庫中】拿到的準備好的對象
     * 2）、再來使用這個對象封裝請求參數
     *
     * @ModelAttribute：
     *      參數：取出剛才保存的數據
     *      方法位置：這個方法就會提前於目標方法先運行；
     *          1)我們可以在這裡提前查出數據庫中圖書的信息
     *          2)將這個圖書信息保存起來（方便下一個方法還能使用）
     *
     * 參數的map：BindingAwareModelMap
     */
    @ModelAttribute
    public void hahaMyModelAttribute(Map<String, Object> map) {
        // From DB
        Book book = new Book(100, "西遊記", "吳承恩", 98, 10, 98.98);
        System.out.println("數據庫中查到的圖書信息是：" + book);
        map.put("haha", book);
        b1 = book;
        o1 = map;
        System.out.println("modelAttribute方法...查詢了圖書並給你保存起來了...他用的map的類型：" + map.getClass());
    }
}