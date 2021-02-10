package cn.edu.henu.service.impl;

import cn.edu.henu.bean.*;
import cn.edu.henu.dao.AdminMapper;
import cn.edu.henu.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminSer")
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin login(String id, String password) {
        System.out.println("业务层登录校验...");
        try {
            Admin admin = adminMapper.findByPrimaryKey(Integer.parseInt(id));
            if (admin != null && password.equals(admin.getAdmin_password())) {
                return admin;
            }
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public boolean update(Admin admin) {
        try {
            int i = adminMapper.update(admin);
            return i >= 1;
        } catch (Exception e) {
            return false;
        }
    }
}
