package cn.edu.henu.service;

import cn.edu.henu.bean.PageBean;
import cn.edu.henu.bean.Exam;
import cn.edu.henu.bean.Teacher;
import cn.edu.henu.bean.Teacher_exam;

import java.util.List;

public interface IExamService {
    //-------------------单表------------------------
    /**
     * 查询全部考试
     * @return Exam对象
     */
    List<Exam> findAll() ;

    /**
     * 根据考试id查询考试
     * @param id
     * @return Exam对象
     */
    Exam findByPrimaryKey(Integer id);

    /**
     *根据条件查询考试
     * @param exam
     * @return
     */
    List<Exam> findByCondition(Exam exam);

    /**
     * 添加考试
     * @param exam
     * @return
     */
    Integer add(Exam exam);

    /**
     * 根据考试id删除考试
     * @param id
     * @return
     */
    boolean deleteById(Integer id);

    /**
     * 修改考试信息
     * @param exam
     * @return
     */
    boolean update(Exam exam);

    //-------------------exam和teacher-----------------
    /**
     * 根据教师id查询教师监考的考试
     * @param id 教师id，即教工号
     * @return
     */
    List<Exam> findExamByTeacher(Integer id);

    //-------------------exam和student-----------------

    /**
     * 根据学生id查询教师监考的考试
     * @param id 学生id，即学号
     * @return
     */
    List<Exam> findExamByStudent(Integer id);
}
