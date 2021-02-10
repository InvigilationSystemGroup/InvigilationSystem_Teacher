package cn.edu.henu.bean;

public class Student {
    //学生学号,主键
    private int student_id;
    //学生密码
    private String student_password;
    //学生姓名
    private String student_name;
    //学生学院
    private String student_faculty;
    //学生专业
    private String student_major;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_password() {
        return student_password;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_faculty() {
        return student_faculty;
    }

    public void setStudent_faculty(String student_faculty) {
        this.student_faculty = student_faculty;
    }

    public String getStudent_major() {
        return student_major;
    }

    public void setStudent_major(String student_major) {
        this.student_major = student_major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", student_password='" + student_password + '\'' +
                ", student_name='" + student_name + '\'' +
                ", student_faculty='" + student_faculty + '\'' +
                ", student_major='" + student_major + '\'' +
                '}';
    }
}
