package cn.edu.henu.service;

import cn.edu.henu.bean.Teacher;

/**
 */
public interface ITeacherService {

    /**
     * 登录验证
     *
     * @param username
     * @param password
     * @return
     */
    Teacher login(String username, String password);

    /**
     * 根据教师id删除教师
     *
     * @param id
     * @return
     */
    boolean deleteById(Integer id);

    /**
     * 修改教师信息
     *
     * @param teacher
     * @return
     */
    boolean update(Teacher teacher);

    /**
     * 根据店铺username查询
     *
     * @param username 用户名
     * @return Teacher对象
     */
    Teacher getOneByKey(Integer username);

    /**
     * 添加教师
     *
     * @param teacher
     * @return
     */
    Integer save(Teacher teacher);
}
