package cn.edu.henu.service;

import cn.edu.henu.bean.PageBean;
import cn.edu.henu.bean.Student;

public interface IStudentService {

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
    PageBean<Student> findByCondition(Student student,int row);

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

}
