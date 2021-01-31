package cn.edu.henu.service.impl;

import cn.edu.henu.bean.*;
import cn.edu.henu.dao.AdminMapper;
import cn.edu.henu.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**

 */
@Service("adminSer")
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public Boolean login(Admin admin) {
        return null;
    }
}
