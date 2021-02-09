package cn.edu.henu.bean;

public class Admin {
    //管理员账号,主键
    private int id;
    //管理员名字
    private int name;
    //管理员密码
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name=" + name +
                ", password='" + password + '\'' +
                '}';
    }
}
