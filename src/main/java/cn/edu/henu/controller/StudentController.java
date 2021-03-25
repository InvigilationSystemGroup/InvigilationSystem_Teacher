package cn.edu.henu.controller;

import cn.edu.henu.bean.Student;
import cn.edu.henu.bean.Student_exam;
import cn.edu.henu.service.IExamService;
import cn.edu.henu.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentSer;
    @Autowired
    private IExamService examSer;

    @ResponseBody
    @RequestMapping("/login")
    public String Login(String username,String password, HttpSession session) {
        Student loginStudent = studentSer.login(username, password);
        System.out.println("登录校验完成..." + loginStudent);
        if (loginStudent != null) {
            session.setAttribute("loginStudentInfo", loginStudent);
            System.out.println("查询成功..." + loginStudent);
            return "success";
        }
        System.out.println("查询失败..." );
        return "-1";
    }

    @ResponseBody
    @RequestMapping("/logout")
    public String Logout(HttpSession session) {
        session.removeAttribute("studentLoginInfo");
        session.invalidate();
        return "success";
    }

    @ResponseBody
    @RequestMapping("/findAll")
    public List<Student> findAll(){
        List<Student> students = studentSer.findAll();
        return students;
    }

    @ResponseBody
    @RequestMapping("/findByCondition")
    public List<Student> findByCondition(String id,String name,String faculty,String major){
        List<Student> students;
        Student t = new Student();
        if(id!=null && !id.equals("")){
            t.setStudent_id(Integer.parseInt(id));
        }
        else{
            t.setStudent_id(0);
        }
        if(name!=null && !name.equals("")){
            t.setStudent_name(name);
        }
        else{
            t.setStudent_name(null);
        }
        if(faculty!=null && !faculty.equals("")){
            t.setStudent_faculty(faculty);
        }
        else{
            t.setStudent_faculty(null);
        }
        if(major!=null && !major.equals("")){
            t.setStudent_major(major);
        }
        else{
            t.setStudent_major(null);
        }
        students=studentSer.findByCondition(t);
        System.out.println("查询成功..."+t);
        return students;
    }

    @ResponseBody
    @RequestMapping("/add")
    public String add(String id,String password,String name,String faculty,String major) {
        Student t = new Student();
        if(id!=null && !id.equals("") && password!=null && !password.equals("")&&name!=null && !name.equals("") && faculty!=null && !faculty.equals("") && major!=null && !major.equals("")){
            t.setStudent_id(Integer.parseInt(id));
            t.setStudent_password(password);
            t.setStudent_name(name);
            t.setStudent_faculty(faculty);
            t.setStudent_major(major);
        }
        else
            return "-1";

        int i=studentSer.add(t);
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
            boolean i = studentSer.deleteById(Integer.parseInt(id));
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
        Student t = new Student();
        if(id!=null && !id.equals("")){
            t.setStudent_id(Integer.parseInt(id));
        }
        else{
            return "-1";
        }
        if(password!=null && !password.equals("")){
            t.setStudent_password(password);
        }
        else{
            t.setStudent_password(null);
        }
        if(name!=null && !name.equals("")){
            t.setStudent_name(name);
        }
        else{
            t.setStudent_name(null);
        }
        if(faculty!=null && !faculty.equals("")){
            t.setStudent_faculty(faculty);
        }
        else{
            t.setStudent_faculty(null);
        }
        if(major!=null && !major.equals("")){
            t.setStudent_major(major);
        }
        else{
            t.setStudent_major(null);
        }
        boolean i=studentSer.update(t);
        if(i==true){
            System.out.println("更新成功..."+t);
            return "success";
        }
        else{
            return "-1";
        }
    }

    //------------------------联表：对某场考试的考生增删改查------------------------------------------------
    @ResponseBody
    @RequestMapping("/findAllStudentsWithExam")
    public List<Student> findAllStudentWithExam(){
        List<Student> students = studentSer.findAllStudentWithExam();
        return students;
    }

    @ResponseBody
    @RequestMapping("/findStudentsByExamId")
    public List<Student> findAllStudentByExam(String exam_id){
        List<Student> students;
        if(exam_id!=null && !exam_id.equals("")){
            students=studentSer.findStudentByExam(Integer.parseInt(exam_id));
        }
        else
        {
            students=studentSer.findAllStudentWithExam();
        }
        System.out.println("查询成功...");
        return students;
    }

    @ResponseBody
    @RequestMapping("/addForExam")
    public String addForExam(String student_id,String exam_id) {
        Student_exam te = new Student_exam();
        if(student_id!=null && !student_id.equals("") && exam_id!=null && !exam_id.equals("")){
            te.setStudent_exam_student_id(Integer.parseInt(student_id));
            te.setStudent_exam_exam_id(Integer.parseInt(exam_id));
        }
        else
            return "-1";

        int i=studentSer.addForExam(te);
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
    public String deleteOneForExam(String student_id,String exam_id) {
        if(student_id!=null && !student_id.equals("") && exam_id!=null && !exam_id.equals("")){
            boolean i = studentSer.deleteForExam(Integer.parseInt(student_id),Integer.parseInt(exam_id));
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
