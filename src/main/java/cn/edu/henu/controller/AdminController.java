package cn.edu.henu.controller;

import cn.edu.henu.bean.Admin;
import cn.edu.henu.bean.Teacher;
import cn.edu.henu.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminSer;

    @ResponseBody
    @RequestMapping("/login")
    public String Login(String username, String password, HttpSession session) {
        Admin loginAdmin = adminSer.login(username, password);
        System.out.println("登录校验完成..." + loginAdmin);
        if (loginAdmin != null) {
            session.setAttribute("loginAdminInfo", loginAdmin);
            System.out.println("查询成功..." + loginAdmin);
            return "success";
        }
        System.out.println("查询失败...");
        return "-1";
    }

    @ResponseBody
    @RequestMapping("/logout")
    public String Logout(HttpSession session) {
        session.removeAttribute("adminLoginInfo");
        session.invalidate();
        return "success";
    }

    @ResponseBody
    @RequestMapping("/update")
    public String update(String id,String password,String name) {
        Admin t = new Admin();
        if(id!=null && !id.equals("")){
            t.setAdmin_id(Integer.parseInt(id));
        }
        else{
            return "-1";
        }
        if(password!=null && !password.equals("")){
            t.setAdmin_password(password);
        }
        else{
            t.setAdmin_password(null);
        }
        if(name!=null && !name.equals("")){
            t.setAdmin_name(name);
        }
        else{
            t.setAdmin_name(null);
        }
        boolean i=adminSer.update(t);
        if(i==true){
            System.out.println("更新成功..."+t);
            return "success";
        }
        else{
            return "-1";
        }
    }

}
