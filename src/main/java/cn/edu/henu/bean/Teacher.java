package cn.edu.henu.bean;

public class Teacher {
    //教师工号,主键
    private int teacher_id;
    //教师密码
    private String teacher_password;
    //教师姓名
    private String teacher_name;
    //教师学院
    private String teacher_faculty;
    //教师专业
    private String teacher_major;

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_password() {
        return teacher_password;
    }

    public void setTeacher_password(String teacher_password) {
        this.teacher_password = teacher_password;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_faculty() {
        return teacher_faculty;
    }

    public void setTeacher_faculty(String teacher_faculty) {
        this.teacher_faculty = teacher_faculty;
    }

    public String getTeacher_major() {
        return teacher_major;
    }

    public void setTeacher_major(String teacher_major) {
        this.teacher_major = teacher_major;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacher_id=" + teacher_id +
                ", teacher_password='" + teacher_password + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                ", teacher_faculty='" + teacher_faculty + '\'' +
                ", teacher_major='" + teacher_major + '\'' +
                '}';
    }
}
