package cn.edu.henu.dao;

import java.util.List;

/**
 * 公用的dao层方法
 */
public interface CrudDao<T> {

    /**
     * 根据主键查询一条数据
     * @param id
     * @return
     */
    T findByPrimaryKey(Integer id);

    /**
     * 查询全部数据
     * @return
     */
    List<T>  findAll();

    /**
     * 查询数据总数
     * @return
     */
    int findAllCount();

    /**
     * 根据条件查询数据
     * @param entity
     * @return
     */
    List<T> findByCondition(T entity);

    /**
     * 根据条件查询数据数量
     * @param entity
     * @return
     */
    int findCountByCondition(T entity);

    /**
     * 添加数据,返回主键
     * @param entity
     * @return
     */
    int add(T entity);

    /**
     * 删除数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 更新数据
     * @param entity
     * @return
     */
    int update(T entity);
}
