package cn.edu.henu.controller;

import cn.edu.henu.bean.Exam;
import cn.edu.henu.bean.Student;
import cn.edu.henu.service.IExamService;
import cn.edu.henu.service.IStudentService;
import cn.edu.henu.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private IExamService examSer;
    @Autowired
    private ITeacherService teacherSer;
    @Autowired
    private IStudentService studentSer;

    @ResponseBody
    @RequestMapping("/findExamsByStudentId")
    public List<Exam> findAllExamByStudent(String student_id){
        List<Exam> exams;
        if(student_id!=null && !student_id.equals("")){
            exams=examSer.findExamByStudent(Integer.parseInt(student_id));
        }
        else
        {
            return null;
        }
        System.out.println("查询成功...");
        return exams;
    }

    @ResponseBody
    @RequestMapping("/findExamsByTeacherId")
    public List<Exam> findAllExamByTeacher(String teacher_id){
        List<Exam> exams;
        if(teacher_id!=null && !teacher_id.equals("")){
            exams=examSer.findExamByTeacher(Integer.parseInt(teacher_id));
        }
        else
        {
            return null;
        }
        System.out.println("查询成功...");
        return exams;
    }
}
