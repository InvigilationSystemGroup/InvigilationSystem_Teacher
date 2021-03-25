package cn.edu.henu.service.impl;

import cn.edu.henu.bean.*;
import cn.edu.henu.dao.ExamMapper;
import cn.edu.henu.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("examSer")
public class ExamServiceImpl implements IExamService {

    @Autowired
    private ExamMapper examMapper;

    @Override
    public List<Exam> findAll() {
        try {
            return examMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
    public List<Exam> findByCondition(Exam exam) {
        try {
            List<Exam> exams;
            if (exam != null) {
                exams = examMapper.findByCondition(exam);
            } else {
                exams = examMapper.findAll();
            }
            return exams;
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

    //-------------------exam和teacher-----------------

    /**
     * 根据教师id查询教师监考的考试
     *
     * @param id 教师id，即教工号
     * @return
     */
    @Override
    public List<Exam> findExamByTeacher(Integer id) {
        try {
            List<Exam> exams;
            if (id != null) {
                exams = examMapper.findExamByTeacher(id);
            } else {
                return null;
            }
            return exams;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //-------------------exam和student-----------------
    /**
     * 根据学生id查询学生参加的考试的考试
     *
     * @param id 学生id，即学号
     * @return
     */
    @Override
    public List<Exam> findExamByStudent(Integer id) {
        try {
            List<Exam> exams;
            if (id != null) {
                exams = examMapper.findExamByStudent(id);
            } else {
                return null;
            }
            return exams;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}