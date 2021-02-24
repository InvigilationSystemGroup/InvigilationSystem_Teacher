package cn.edu.henu.bean;

public class Student_exam {
    //考生参加的考试的考试序号,联合主键1
    private int student_exam_exam_id;
    //考生学号,联合主键2
    private int student_exam_student_id;
    //考生考试座位号
    private int student_exam_seat;
    //考生作弊简述及登录状态
    private String student_exam_cheat_brief;
    //考生作弊详情
    private String student_exam_cheat_detail;
    //锁屏解锁码
    private String student_exam_unlock;
    /*//与学生的关联属性：一个学生；一对一
    private Student oneStudent;
    //与考试的关联属性：一个考试；一对一
    private Exam oneExam;*/

    public int getStudent_exam_exam_id() {
        return student_exam_exam_id;
    }

    public void setStudent_exam_exam_id(int student_exam_exam_id) {
        this.student_exam_exam_id = student_exam_exam_id;
    }

    public int getStudent_exam_student_id() {
        return student_exam_student_id;
    }

    public void setStudent_exam_student_id(int student_exam_student_id) {
        this.student_exam_student_id = student_exam_student_id;
    }

    public int getStudent_exam_seat() {
        return student_exam_seat;
    }

    public void setStudent_exam_seat(int student_exam_seat) {
        this.student_exam_seat = student_exam_seat;
    }

    public String getStudent_exam_cheat_brief() {
        return student_exam_cheat_brief;
    }

    public void setStudent_exam_cheat_brief(String student_exam_cheat_brief) {
        this.student_exam_cheat_brief = student_exam_cheat_brief;
    }

    public String getStudent_exam_cheat_detail() {
        return student_exam_cheat_detail;
    }

    public void setStudent_exam_cheat_detail(String student_exam_cheat_detail) {
        this.student_exam_cheat_detail = student_exam_cheat_detail;
    }

    public String getStudent_exam_unlock() {
        return student_exam_unlock;
    }

    public void setStudent_exam_unlock(String student_exam_unlock) {
        this.student_exam_unlock = student_exam_unlock;
    }

    @Override
    public String toString() {
        return "Student_exam{" +
                ", student_exam_exam_id='" + student_exam_exam_id + '\'' +
                ", student_exam_student_id='" + student_exam_student_id + '\'' +
                ", student_exam_seat='" + student_exam_seat + '\'' +
                ", student_exam_cheat_brief='" + student_exam_cheat_brief + '\'' +
                ", student_exam_cheat_detail='" + student_exam_cheat_detail + '\'' +
                ", student_exam_unlock='" + student_exam_unlock + '\'' +
                '}';
    }
}
