package cn.edu.henu.service;

import cn.edu.henu.bean.PageBean;
import cn.edu.henu.bean.Student;
import cn.edu.henu.bean.Student;
import cn.edu.henu.bean.Student_exam;

import java.util.List;

public interface IStudentService {
//-------------------单表------------------------
    /**
     * 登录验证，返回登录学生的Student类
     * @param id
     * @param password
     * @return
     */
    Student login(String id, String password);

    /**
     * 查询全部学生
     * @return Student对象
     */
    List<Student> findAll() ;
    
    /**
     * 根据学生id查询学生
     * @param id
     * @return Student对象
     */
    Student findByPrimaryKey(Integer id);

    /**
     *根据条件查询学生
     * @param student
     * @return
     */
    List<Student> findByCondition(Student student);

    /**
     * 添加学生
     * @param student
     * @return
     */
    Integer add(Student student);

    /**
     * 根据学生id删除学生
     * @param id
     * @return
     */
    boolean deleteById(Integer id);

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    boolean update(Student student);

    //-----------------------student和exam---------------------------
    /**
     * 查询所有考生及其报名的考试
     * @return
     */
    List<Student> findAllStudentWithExam();

    /**
     * 根据考试id查询所有所有考生
     * @param id 考试id
     * @return
     */
    List<Student> findStudentByExam(Integer id);

    /**
     * 根据学生id和考试id添加某场考试的考生
     * @param student_exam
     * @return
     */
    Integer addForExam(Student_exam student_exam);

    /**
     * 根据学生id和考试id删除某场考试的考生
     * @param student_id
     * @param exam_id
     * @return
     */
    boolean deleteForExam(Integer student_id,Integer exam_id);


}
