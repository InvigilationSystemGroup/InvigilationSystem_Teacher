package cn.edu.henu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于页面跳转的Controller
 *
 */
@Controller
public class ActionController {

    @RequestMapping("/first")
    public String toFirstPage() {
        return "login&register/first";
    }

}
