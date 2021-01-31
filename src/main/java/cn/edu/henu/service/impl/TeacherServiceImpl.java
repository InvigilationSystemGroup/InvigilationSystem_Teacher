package cn.edu.henu.service.impl;

import cn.edu.henu.dao.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.henu.bean.Teacher;
import cn.edu.henu.service.ITeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service("teacherSer")
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher login(String username, String password) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public boolean update(Teacher teacher) {
        return false;
    }

    @Override
    public Teacher getOneByKey(Integer username) {
        return null;
    }

    @Override
    public Integer save(Teacher teacher) {
        return null;
    }
}
