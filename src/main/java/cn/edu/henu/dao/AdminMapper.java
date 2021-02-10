package cn.edu.henu.dao;

import cn.edu.henu.bean.Admin;

import java.util.List;

public interface AdminMapper  extends CrudDao<Admin> {
    /**
     * 根据主键查询一条数据
     *
     * @param id
     * @return
     */
    @Override
    Admin findByPrimaryKey(Integer id);

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    @Override
    int update(Admin entity);
}
