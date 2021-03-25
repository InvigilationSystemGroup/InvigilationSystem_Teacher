package cn.edu.henu.service;

import cn.edu.henu.bean.Exam;
import cn.edu.henu.bean.PageBean;
import cn.edu.henu.bean.Teacher;
import cn.edu.henu.bean.Teacher_exam;

import java.util.List;

public interface ITeacherService {
//-------------------单表------------------------
    /**
     * 登录验证，返回登录教师的Teacher类
     * @param id
     * @param password
     * @return
     */
    Teacher login(String id, String password);

    /**
     * 查询全部教师
     * @return Teacher对象
     */
    List<Teacher> findAll() ;

    /**
     * 根据教师id查询教师
     * @param id
     * @return Teacher对象
     */
    Teacher findByPrimaryKey(Integer id);

    /**
     *根据条件查询教师
     * @param teacher
     * @return
     */
    List<Teacher> findByCondition(Teacher teacher);
    //PageBean<Teacher> findByCondition(Teacher teacher,int row);

    /**
     * 添加教师
     * @param teacher
     * @return
     */
    Integer add(Teacher teacher);

    /**
     * 根据教师id删除教师
     * @param id
     * @return
     */
    boolean deleteById(Integer id);

    /**
     * 修改教师信息
     * @param teacher
     * @return
     */
    boolean update(Teacher teacher);

    //-----------------------teacher和exam---------------------------
    /**
     * 查询所有有监考任务的监考教师及其监考的考试
     * @return
     */
    List<Teacher> findAllTeacherWithExam();

    /**
     * 根据考试id查询所有监考教师
     * @param id 考试id
     * @return
     */
    List<Teacher> findTeacherByExam(Integer id);

    /**
     * 根据教师id和考试id添加某场考试的监考教师
     * @param teacher_exam
     * @return
     */
    Integer addForExam(Teacher_exam teacher_exam);

    /**
     * 根据教师id和考试id删除某场考试的监考教师
     * @param teacher_id
     * @param exam_id
     * @return
     */
    boolean deleteForExam(Integer teacher_id,Integer exam_id);


}
