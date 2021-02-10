package cn.edu.henu.bean;

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

    @Override
    public String toString() {
        return "Exam{" +
                "exam_id=" + exam_id +
                ", exam_name='" + exam_name + '\'' +
                ", exam_starttime='" + exam_starttime + '\'' +
                ", exam_endtime='" + exam_endtime + '\'' +
                ", exam_room='" + exam_room + '\'' +
                '}';
    }
}
