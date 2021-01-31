package cn.edu.henu.dao;

import java.util.List;

/**
 * 公用的dao层方法
 *
 */
public interface CrudDao<T> {

    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据
     *
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    T selectByPrimaryKey(Integer id);

    /**
     * 根据条件查询
     *
     * @param entity
     * @return
     */
    List<T> selectByCondition(T entity);

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    int updateByPrimaryKey(T entity);
}
