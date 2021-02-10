package cn.edu.henu.bean;

public class Cheat {
    //作弊信息记录序号,自增,主键
    private int cheat_id;
    //作弊考生学号
    private String cheat_student_id;
    //作弊简述
    private String cheat_brief;
    //作弊详情
    private String cheat_detail;
    //作弊考试序号
    private String cheat_exam_id;

    public int getCheat_id() {
        return cheat_id;
    }

    public void setCheat_id(int cheat_id) {
        this.cheat_id = cheat_id;
    }

    public String getCheat_student_id() {
        return cheat_student_id;
    }

    public void setCheat_student_id(String cheat_student_id) {
        this.cheat_student_id = cheat_student_id;
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

    public String getCheat_exam_id() {
        return cheat_exam_id;
    }

    public void setCheat_exam_id(String cheat_exam_id) {
        this.cheat_exam_id = cheat_exam_id;
    }

    @Override
    public String toString() {
        return "Cheat{" +
                "cheat_id=" + cheat_id +
                ", cheat_student_id='" + cheat_student_id + '\'' +
                ", cheat_brief='" + cheat_brief + '\'' +
                ", cheat_detail='" + cheat_detail + '\'' +
                ", cheat_exam_id='" + cheat_exam_id + '\'' +
                '}';
    }
}
