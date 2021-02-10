package cn.edu.henu.bean;

public class Student_exam {
    //考生考试序号,自增,主键
    private int student_exam_id;
    //考生参加的考试的考试序号
    private String student_exam_exam_id;
    //考生学号
    private String student_exam_student_id;
    //考生考试座位号
    private String student_exam_seat;
    //考生作弊简述及登录状态
    private String student_exam_cheat_brief;
    //考生作弊详情
    private String student_exam_cheat_detail;

    public int getStudent_exam_id() {
        return student_exam_id;
    }

    public void setStudent_exam_id(int student_exam_id) {
        this.student_exam_id = student_exam_id;
    }

    public String getStudent_exam_exam_id() {
        return student_exam_exam_id;
    }

    public void setStudent_exam_exam_id(String student_exam_exam_id) {
        this.student_exam_exam_id = student_exam_exam_id;
    }

    public String getStudent_exam_student_id() {
        return student_exam_student_id;
    }

    public void setStudent_exam_student_id(String student_exam_student_id) {
        this.student_exam_student_id = student_exam_student_id;
    }

    public String getStudent_exam_seat() {
        return student_exam_seat;
    }

    public void setStudent_exam_seat(String student_exam_seat) {
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

    @Override
    public String toString() {
        return "Student_exam{" +
                "student_exam_id=" + student_exam_id +
                ", student_exam_exam_id='" + student_exam_exam_id + '\'' +
                ", student_exam_student_id='" + student_exam_student_id + '\'' +
                ", student_exam_seat='" + student_exam_seat + '\'' +
                ", student_exam_cheat_brief='" + student_exam_cheat_brief + '\'' +
                ", student_exam_cheat_detail='" + student_exam_cheat_detail + '\'' +
                '}';
    }
}
