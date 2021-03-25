package cn.edu.henu.controller;

import cn.edu.henu.bean.Exam;
import cn.edu.henu.bean.Teacher_exam;
import cn.edu.henu.service.IExamService;
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

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private ITeacherService teacherSer;
    @Autowired
    private IExamService examSer;

    @ResponseBody
    @RequestMapping("/login")
    public String Login(String username,String password, HttpSession session) {
        Teacher loginTeacher = teacherSer.login(username, password);
        System.out.println("登录校验完成..." + loginTeacher);
        if (loginTeacher != null) {
            session.setAttribute("loginTeacherInfo", loginTeacher);
            System.out.println("查询成功..." + loginTeacher);
            return "success";
        }
        System.out.println("查询失败..." );
        return "-1";
    }

    @ResponseBody
    @RequestMapping("/logout")
    public String Logout(HttpSession session) {
        session.removeAttribute("teacherLoginInfo");
        session.invalidate();
        return "success";
    }

    @ResponseBody
    @RequestMapping("/findAll")
    public List<Teacher> findAll(){
        List<Teacher> teachers = teacherSer.findAll();
        return teachers;
    }

    @ResponseBody
    @RequestMapping("/findByCondition")
    public List<Teacher> findByCondition(String id,String name,String faculty,String major){
        List<Teacher> teachers;
        Teacher t = new Teacher();
        if(id!=null && !id.equals("")){
            t.setTeacher_id(Integer.parseInt(id));
        }
        else{
            t.setTeacher_id(0);
        }
        if(name!=null && !name.equals("")){
            t.setTeacher_name(name);
        }
        else{
            t.setTeacher_name(null);
        }
        if(faculty!=null && !faculty.equals("")){
            t.setTeacher_faculty(faculty);
        }
        else{
            t.setTeacher_faculty(null);
        }
        if(major!=null && !major.equals("")){
            t.setTeacher_major(major);
        }
        else{
            t.setTeacher_major(null);
        }
        teachers=teacherSer.findByCondition(t);
        System.out.println("查询成功..."+t);
        return teachers;
    }

    @ResponseBody
    @RequestMapping("/add")
    public String add(String id,String password,String name,String faculty,String major) {
        Teacher t = new Teacher();
        if(id!=null && !id.equals("") && password!=null && !password.equals("")&&name!=null && !name.equals("") && faculty!=null && !faculty.equals("") && major!=null && !major.equals("")){
            t.setTeacher_id(Integer.parseInt(id));
            t.setTeacher_password(password);
            t.setTeacher_name(name);
            t.setTeacher_faculty(faculty);
            t.setTeacher_major(major);
        }
        else
            return "-1";

        int i=teacherSer.add(t);
        if(i>=1){
            System.out.println(i+"添加成功..."+t);
            return "success";
        }
        else{
            return "-1";
        }
    }

    @ResponseBody
    @RequestMapping("/deleteOne")
    public String delete(String id) {
        if(id!=null && !id.equals("")) {
            boolean i = teacherSer.deleteById(Integer.parseInt(id));
            if(i){
                System.out.println(i+"删除成功...");
                return "success";
            }
            else
                return "-1";
        }
        else
            return "-1";
    }

    @ResponseBody
    @RequestMapping("/update")
    public String update(String id,String password,String name,String faculty,String major) {
        Teacher t = new Teacher();
        if(id!=null && !id.equals("")){
            t.setTeacher_id(Integer.parseInt(id));
        }
        else{
            return "-1";
        }
        if(password!=null && !password.equals("")){
            t.setTeacher_password(password);
        }
        else{
            t.setTeacher_password(null);
        }
        if(name!=null && !name.equals("")){
            t.setTeacher_name(name);
        }
        else{
            t.setTeacher_name(null);
        }
        if(faculty!=null && !faculty.equals("")){
            t.setTeacher_faculty(faculty);
        }
        else{
            t.setTeacher_faculty(null);
        }
        if(major!=null && !major.equals("")){
            t.setTeacher_major(major);
        }
        else{
            t.setTeacher_major(null);
        }
        boolean i=teacherSer.update(t);
        if(i==true){
            System.out.println("更新成功..."+t);
            return "success";
        }
        else{
            return "-1";
        }
    }

    //------------------------联表：对某场考试的教师增删改查------------------------------------------------
    @ResponseBody
    @RequestMapping("/findAllTeachersWithExam")
    public List<Teacher> findAllTeacherWithExam(){
        List<Teacher> teachers = teacherSer.findAllTeacherWithExam();
        return teachers;
    }

    @ResponseBody
    @RequestMapping("/findTeachersByExamId")
    public List<Teacher> findAllTeacherByExam(String exam_id){
        List<Teacher> teachers;
        if(exam_id!=null && !exam_id.equals("")){
            teachers=teacherSer.findTeacherByExam(Integer.parseInt(exam_id));
        }
        else
        {
            teachers=teacherSer.findAllTeacherWithExam();
        }
        System.out.println("查询成功...");
        return teachers;
    }

    @ResponseBody
    @RequestMapping("/addForExam")
    public String addForExam(String teacher_id,String exam_id) {
        Teacher_exam te = new Teacher_exam();
        if(teacher_id!=null && !teacher_id.equals("") && exam_id!=null && !exam_id.equals("")){
           te.setTeacher_exam_teacher_id(Integer.parseInt(teacher_id));
           te.setTeacher_exam_exam_id(Integer.parseInt(exam_id));
        }
        else
            return "-1";

        int i=teacherSer.addForExam(te);
        if(i>=1){
            System.out.println(i+"添加成功..."+te);
            return "success";
        }
        else{
            return "-1";
        }
    }

    @ResponseBody
    @RequestMapping("/deleteOneForExam")
    public String deleteOneForExam(String teacher_id,String exam_id) {
        if(teacher_id!=null && !teacher_id.equals("") && exam_id!=null && !exam_id.equals("")){
            boolean i = teacherSer.deleteForExam(Integer.parseInt(teacher_id),Integer.parseInt(exam_id));
            if(i){
                System.out.println(i+"删除成功...");
                return "success";
            }
            else
                return "-1";
        }
        else
            return "-1";
    }
}
