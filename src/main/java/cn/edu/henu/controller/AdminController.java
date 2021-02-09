package cn.edu.henu.controller;

import cn.edu.henu.bean.Admin;
import cn.edu.henu.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminSer;

    @ResponseBody
    @RequestMapping("/login")
    public Map<String, Object> login(@RequestBody String body, HttpSession session) {

        return null;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        Admin loginInfo = (Admin) session.getAttribute("adminLoginInfo");
        if (loginInfo == null) {
            return "redirect:/login/admin";
        }
        session.removeAttribute("adminLoginInfo");
        session.invalidate();
        return "redirect:/login/admin";
    }

}
