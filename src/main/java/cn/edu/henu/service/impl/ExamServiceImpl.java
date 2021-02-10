package cn.edu.henu.service.impl;

import cn.edu.henu.bean.PageBean;
import cn.edu.henu.bean.Exam;
import cn.edu.henu.dao.ExamMapper;
import cn.edu.henu.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("examSer")
public class ExamServiceImpl implements IExamService {

    @Autowired
    private ExamMapper examMapper;

    void initPageBean(PageBean<Exam> pageBean, Exam product, Integer row) {
        pageBean.setRows(row);
        int total = examMapper.findAllCount();
        pageBean.setTotalCount(total);
        int rows = pageBean.getRows();
        int a = total % rows;
        int b = total / rows;
        pageBean.setTotalPage(a == 0 ? b : b + 1);
    }

    @Override
    public Exam findByPrimaryKey(Integer id) {
        try {
            return examMapper.findByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PageBean<Exam> findByCondition(Exam exam, int row) {
        try {
            List<Exam> exams;
            if (exam != null) {
                exams = examMapper.findByCondition(exam);
            } else {
                exams = examMapper.findAll();
            }
            PageBean<Exam> pageBean = new PageBean<>();
            initPageBean(pageBean, exam, row);
            pageBean.setList(exams);
            return pageBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer add(Exam exam) {
        try {
            return examMapper.add(exam);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        try {
            int i = examMapper.deleteByPrimaryKey(id);
            return i >= 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Exam exam) {
        try {
            int i = examMapper.update(exam);
            return i >= 1;
        } catch (Exception e) {
            return false;
        }
    }
}