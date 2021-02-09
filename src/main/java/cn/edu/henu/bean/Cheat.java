package cn.edu.henu.bean;

public class Cheat {
    //作弊信息记录序号,自增,主键
    private int id;
    //作弊考生学号
    private String student_id;
    //作弊简述
    private String brief;
    //作弊详情
    private String detail;
    //作弊考试序号
    private String exam_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getExam_id() {
        return exam_id;
    }

    public void setExam_id(String exam_id) {
        this.exam_id = exam_id;
    }

    @Override
    public String toString() {
        return "Cheat{" +
                "id=" + id +
                ", student_id='" + student_id + '\'' +
                ", brief='" + brief + '\'' +
                ", detail='" + detail + '\'' +
                ", exam_id='" + exam_id + '\'' +
                '}';
    }
}
