package cn.edu.henu.service;

import cn.edu.henu.bean.*;

import java.util.List;

public interface IAdminService {
    /**
     * 登录验证
     * @param id
     * @param password
     * @return
     */
    Admin login(String id, String password);

    /**
     * 根据教师id查询教师
     * @param id
     * @return Teacher对象
     */
    Admin findByPrimaryKey(Integer id);


    /**
     * 修改管理员信息
     * @param admin
     * @return
     */
    boolean update(Admin admin);


}
