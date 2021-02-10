package cn.edu.henu.service;

import cn.edu.henu.bean.PageBean;
import cn.edu.henu.bean.Teacher;

import java.util.List;

public interface ITeacherService {

    /**
     * 登录验证
     * @param id
     * @param password
     * @return
     */
    Teacher login(String id, String password);

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
    PageBean<Teacher> findByCondition(Teacher teacher,int row);

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

}
