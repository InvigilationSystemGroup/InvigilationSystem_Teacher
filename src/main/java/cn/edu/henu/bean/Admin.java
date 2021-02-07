package cn.edu.henu.bean;

public class Admin {
    //管理员账号,主键
    private int admin_id;
    //管理员密码
    private String admin_password;

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", admin_password='" + admin_password + '\'' +
                '}';
    }
}
