package cn.edu.henu.service.impl;

import cn.edu.henu.dao.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.henu.bean.Teacher;
import cn.edu.henu.service.ITeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherSer")
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher login(String id, String password) {
        System.out.println("业务层登录校验...");
        try {
            Teacher teacher = teacherMapper.findByPrimaryKey(Integer.parseInt(id));
            if (teacher != null && password.equals(teacher.getTeacher_password())) {
                return teacher;
            }
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public Teacher findSimpleByPrimaryKey(Integer id) {
        try {
            return teacherMapper.findByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer add(Teacher teacher) {
        try {
            return teacherMapper.add(teacher);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        try {
            int i = teacherMapper.deleteByPrimaryKey(id);
            return i >= 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Teacher teacher) {
        try {
            int i = teacherMapper.update(teacher);
            return i >= 1;
        } catch (Exception e) {
            return false;
        }
    }
}
