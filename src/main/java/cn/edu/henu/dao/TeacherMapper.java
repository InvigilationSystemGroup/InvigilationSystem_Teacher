package cn.edu.henu.dao;

import cn.edu.henu.bean.Teacher;

import java.util.List;

public interface TeacherMapper extends CrudDao<Teacher> {
    /**
     * 查询单条数据
     *
     * @param id
     * @return
     */
    @Override
    Teacher findByPrimaryKey(Integer id);

    /**
     * 查询全部数据
     *
     * @return
     */
    @Override
    List<Teacher>  findAll();

    /**
     * 查询数据总数
     *
     * @return
     */
    @Override
    int findAllCount();

    /**
     * 根据条件查询数据
     *
     * @param entity
     * @return
     */
    @Override
    List<Teacher> findByCondition(Teacher entity);

    /**
     * 根据条件查询数据数量
     *
     * @param entity
     * @return
     */
    @Override
    int findCountByCondition(Teacher entity);

    /**
     * 添加数据
     *
     * @param entity
     * @return
     */
    @Override
    int add(Teacher entity);

    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    @Override
    int deleteByPrimaryKey(Integer id);

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    @Override
    int update(Teacher entity);
}
