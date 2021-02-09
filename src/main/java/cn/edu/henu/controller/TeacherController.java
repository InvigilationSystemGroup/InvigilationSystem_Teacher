package cn.edu.henu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.henu.bean.Teacher;
import cn.edu.henu.service.ITeacherService;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private ITeacherService teacherSer;

    @RequestMapping("/update")
    public String updateTeacher(Teacher teacher, HttpSession session) {

        return "redirect:/teacher/home";
    }


    @RequestMapping("/logout")
    public String teacherLogout(HttpSession session) {
        session.removeAttribute("teacherLoginInfo");
        session.invalidate();
        return "redirect:/login/teacher";
    }
}
