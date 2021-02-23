package cn.edu.henu.bean;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.List;

public class Exam {
    //考试序号,自增,主键
    private int exam_id;
    //考试科目
    private String exam_name;
    //考试开始时间
    private String exam_starttime;
    //考试结束时间
    private String exam_endtime;
    //考场名称
    private String exam_room;
    //考场容量
    private int exam_capacity;

    private String exam_ipwhite;

    private String exam_ipblack;
    //与学生的关联属性：Student集合
    private List<Student> students;
    /*//与学生考试的关联属性：Student_exam集合；一对多
    private List<Student_exam> student_exams;*/
    //与教师的关联属性：Teacher集合
    private List<Teacher> teachers;

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public String getExam_name() {
        return exam_name;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public String getExam_starttime() {
        return exam_starttime;
    }

    public void setExam_starttime(String exam_starttime) {
        this.exam_starttime = exam_starttime;
    }

    public String getExam_endtime() {
        return exam_endtime;
    }

    public void setExam_endtime(String exam_endtime) {
        this.exam_endtime = exam_endtime;
    }

    public String getExam_room() {
        return exam_room;
    }

    public void setExam_room(String exam_room) {
        this.exam_room = exam_room;
    }

    public int getExam_capacity() {
        return exam_capacity;
    }

    public void setExam_capacity(int exam_capacity) {
        this.exam_capacity = exam_capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public String getExam_ipwhite() {
        return exam_ipwhite;
    }

    public void setExam_ipwhite(String exam_ipwhite) {
        this.exam_ipwhite = exam_ipwhite;
    }

    public String getExam_ipblack() {
        return exam_ipblack;
    }

    public void setExam_ipblack(String exam_ipblack) {
        this.exam_ipblack = exam_ipblack;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "exam_id=" + exam_id +
                ", exam_name='" + exam_name + '\'' +
                ", exam_starttime='" + exam_starttime + '\'' +
                ", exam_endtime='" + exam_endtime + '\'' +
                ", exam_room='" + exam_room + '\'' +
                ", exam_capacity=" + exam_capacity +
                ", exam_ipwhite=" + exam_ipwhite +
                ", exam_ipblack=" + exam_ipblack +
                ", students=" + students +
                ", teachers=" + teachers +
                '}';
    }
}
