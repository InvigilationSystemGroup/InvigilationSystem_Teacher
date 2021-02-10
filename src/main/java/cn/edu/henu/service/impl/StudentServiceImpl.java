package cn.edu.henu.service.impl;

import cn.edu.henu.bean.PageBean;
import cn.edu.henu.bean.Student;
import cn.edu.henu.dao.StudentMapper;
import cn.edu.henu.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentSer")
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    void initPageBean(PageBean<Student> pageBean, Student product, Integer row) {
        pageBean.setRows(row);
        int total = studentMapper.findAllCount();
        pageBean.setTotalCount(total);
        int rows = pageBean.getRows();
        int a = total % rows;
        int b = total / rows;
        pageBean.setTotalPage(a == 0 ? b : b + 1);
    }

    @Override
    public Student findByPrimaryKey(Integer id) {
        try {
            return studentMapper.findByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PageBean<Student> findByCondition(Student student, int row) {
        try {
            List<Student> students;
            if (student != null) {
                students = studentMapper.findByCondition(student);
            } else {
                students = studentMapper.findAll();
            }
            PageBean<Student> pageBean = new PageBean<>();
            initPageBean(pageBean, student, row);
            pageBean.setList(students);
            return pageBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer add(Student student) {
        try {
            return studentMapper.add(student);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        try {
            int i = studentMapper.deleteByPrimaryKey(id);
            return i >= 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Student student) {
        try {
            int i = studentMapper.update(student);
            return i >= 1;
        } catch (Exception e) {
            return false;
        }
    }
}
