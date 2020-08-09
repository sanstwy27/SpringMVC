package com.atkjs927.crud.controller;

import com.atkjs927.crud.dao.DepartmentDao;
import com.atkjs927.crud.dao.EmployeeDao;
import com.atkjs927.crud.bean.Department;
import com.atkjs927.crud.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;

@Controller
public class EmployeeController {

    //自動注入
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    /*
     * 查詢所有員工
     */
    @RequestMapping("/emps")
    public String getEmps(Model model) {
        Collection<Employee> empAll = employeeDao.getAll();
        model.addAttribute("emps", empAll);  //數據默認放在請求域中
        return "list";

    }

    /*
     * 去員工添加頁面，去頁面之前需要查詢所有部門信息，進行展示
     */
    @RequestMapping("/toaddpage")
    public String toAddPage(Model model) {
        //1.先查詢所有部門
        //Collection<Department> departsments = departmentDao.getDepartments();
        //2.放在請求域中
        //model.addAttribute("depts", departsments);
        if(model.getAttribute("employee") == null) {
            model.addAttribute("employee", new Employee());
        }
        return "add";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String addEmp(@Valid Employee employee, BindingResult result, Model model) {
        System.out.println(employee);
        System.out.println(result);
        boolean hasErrors=result.hasErrors();
        if(hasErrors)
        {
            System.out.println("有校驗錯誤");
            List<FieldError> errors = result.getFieldErrors();
            Map<String, Object> errorsMap = new HashMap<String, Object>();
            for(FieldError fieldError : errors) {
                System.out.println("錯誤訊息顯示: " + fieldError.getDefaultMessage());
                System.out.println("錯誤字段? " + fieldError.getField());
                System.out.println("==============");
                errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            model.addAttribute("errorInfo", errorsMap);
            return "add";
        }else{
            employeeDao.save(employee);
            //重定向查詢全部員工
            return "redirect:/emps";
        }
    }

    /*
     * 查詢員工，來到修改頁面
     */
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String getEmp(@PathVariable("id") Integer id, Model model) {
        //1.查出員工信息
        Employee em = employeeDao.get(id);
        //2.放在請求域中
        model.addAttribute("employee", em);
        //3.查出部門信息放到隱含模型中
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "edit";
    }

    /*
     * 修改員工
     */
    @RequestMapping(value="/emp/{id}",method=RequestMethod.PUT)
    public String updateEmp(Employee employee/*,@PathVariable("id")Integer id*/){
        System.out.println("要修改的員工"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /*
     *
     * 提前查詢員工
     * 不能使用@PathVariable("id")Integer id，因為這個方法在所有方法之前都會執行，有些請求沒有帶id，會拋出異常
     */
    @ModelAttribute
    public void myModelAttribute(@RequestParam(value="id",required=false)Integer id, Model model){
        if(id!=null){
            Employee employee=employeeDao.get(id);
            model.addAttribute("employee", employee);
        }

        Collection<Department> departsments = departmentDao.getDepartments();
        model.addAttribute("depts", departsments);
    }

    /**
     * DELETE
     * @param id
     * @return
     */
    @RequestMapping(value="emp/{id}",method=RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";


    }

    /*
     * 發送請求帶的數據讓其工作
     * quick?empInfo=empAdmin-admin@qq.com-1-101
     * 可以通過寫一個自定義類型的轉換器
     */
    @RequestMapping("/quickadd")
    public String quickAdd(@RequestParam("empInfo")Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

}
