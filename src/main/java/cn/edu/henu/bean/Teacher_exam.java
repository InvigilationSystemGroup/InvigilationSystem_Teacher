package cn.edu.henu.bean;

public class Teacher_exam {
    //教师监考的考试的考试序号,联合主键1
    private int teacher_exam_exam_id;
    //教工号,联合主键2
    private int teacher_exam_teacher_id;

    public int getTeacher_exam_teacher_id() {
        return teacher_exam_teacher_id;
    }

    public void setTeacher_exam_teacher_id(int teacher_exam_teacher_id) {
        this.teacher_exam_teacher_id = teacher_exam_teacher_id;
    }

    public int getTeacher_exam_exam_id() {
        return teacher_exam_exam_id;
    }

    public void setTeacher_exam_exam_id(int teacher_exam_exam_id) {
        this.teacher_exam_exam_id = teacher_exam_exam_id;
    }

    @Override
    public String toString() {
        return "Teacher_exam{" +
                ", teacher_exam_teacher_id='" + teacher_exam_teacher_id + '\'' +
                ", teacher_exam_exam_id='" + teacher_exam_exam_id + '\'' +
                '}';
    }
}
