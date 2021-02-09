package cn.edu.henu.bean;

public class Student_exam {
    //考生考试序号,自增,主键
    private int id;
    //考生参加的考试的考试序号
    private String exam_id;
    //考生学号
    private String student_id;
    //考生考试座位号
    private String seat;
    //考生作弊简述及登录状态
    private String cheat_brief;
    //考生作弊详情
    private String cheat_detail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExam_id() {
        return exam_id;
    }

    public void setExam_id(String exam_id) {
        this.exam_id = exam_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getCheat_brief() {
        return cheat_brief;
    }

    public void setCheat_brief(String cheat_brief) {
        this.cheat_brief = cheat_brief;
    }

    public String getCheat_detail() {
        return cheat_detail;
    }

    public void setCheat_detail(String cheat_detail) {
        this.cheat_detail = cheat_detail;
    }

    @Override
    public String toString() {
        return "Student_exam{" +
                "id=" + id +
                ", exam_id='" + exam_id + '\'' +
                ", student_id='" + student_id + '\'' +
                ", seat='" + seat + '\'' +
                ", cheat_brief='" + cheat_brief + '\'' +
                ", cheat_detail='" + cheat_detail + '\'' +
                '}';
    }
}
