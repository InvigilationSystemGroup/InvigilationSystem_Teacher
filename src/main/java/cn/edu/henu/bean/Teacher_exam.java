package cn.edu.henu.bean;

public class Teacher_exam {
    //教师监考序号,自增,主键
    private int id;
    //教师监考的考试的考试序号
    private String teacher_id;
    //教工号
    private String exam_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getExam_id() {
        return exam_id;
    }

    public void setExam_id(String exam_id) {
        this.exam_id = exam_id;
    }

    @Override
    public String toString() {
        return "Teacher_exam{" +
                "id=" + id +
                ", teacher_id='" + teacher_id + '\'' +
                ", exam_id='" + exam_id + '\'' +
                '}';
    }
}
