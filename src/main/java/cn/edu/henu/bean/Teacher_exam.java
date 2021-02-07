package cn.edu.henu.bean;

public class Teacher_exam {
    //教师监考序号,自增,主键
    private int teacher_exam_id;
    //教师监考的考试的考试序号
    private String teacher_exam_teacher_id;
    //教工号
    private String teacher_exam_exam_id;

    public int getTeacher_exam_id() {
        return teacher_exam_id;
    }

    public void setTeacher_exam_id(int teacher_exam_id) {
        this.teacher_exam_id = teacher_exam_id;
    }

    public String getTeacher_exam_teacher_id() {
        return teacher_exam_teacher_id;
    }

    public void setTeacher_exam_teacher_id(String teacher_exam_teacher_id) {
        this.teacher_exam_teacher_id = teacher_exam_teacher_id;
    }

    public String getTeacher_exam_exam_id() {
        return teacher_exam_exam_id;
    }

    public void setTeacher_exam_exam_id(String teacher_exam_exam_id) {
        this.teacher_exam_exam_id = teacher_exam_exam_id;
    }

    @Override
    public String toString() {
        return "Teacher_exam{" +
                "teacher_exam_id=" + teacher_exam_id +
                ", teacher_exam_teacher_id='" + teacher_exam_teacher_id + '\'' +
                ", teacher_exam_exam_id='" + teacher_exam_exam_id + '\'' +
                '}';
    }
}
