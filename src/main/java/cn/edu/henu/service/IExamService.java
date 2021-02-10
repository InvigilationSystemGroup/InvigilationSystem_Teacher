package cn.edu.henu.service;

import cn.edu.henu.bean.PageBean;
import cn.edu.henu.bean.Exam;

public interface IExamService {
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
    PageBean<Exam> findByCondition(Exam exam, int row);

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
}
