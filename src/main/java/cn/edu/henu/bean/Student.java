package cn.edu.henu.bean;

public class Student {
    //学生学号,主键
    private int id;
    //学生密码
    private String password;
    //学生姓名
    private String name;
    //学生学院
    private String faculty;
    //学生专业
    private String major;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
