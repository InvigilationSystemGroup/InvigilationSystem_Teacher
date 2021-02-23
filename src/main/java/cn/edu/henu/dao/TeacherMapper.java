package cn.edu.henu.dao;

import cn.edu.henu.bean.Teacher;
import cn.edu.henu.bean.Teacher_exam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper extends CrudDao<Teacher> {
    //-------------------------------------联表操作---------------------------------------------------
    /**
     *查询所有监考教师及其监考任务
     * @return
     */
    List<Teacher> findAllTeacherWithExam();

    /**
     *查询所有监考教师及其监考任务数量
     * @return
     */
    int findAllCountTeacherWithExam();

    /**
     *查询某场考试的监考教师
     * @param id
     * @return
     */
    List<Teacher> findTeacherWithExam(int id);

    /**
     * 查询某场考试的监考教师数量
     * @param id
     * @return
     */
    int findTeacherCountWithExam(int id);

    /**
     *为某场考试添加监考教师
     * @param teacher_exam
     * @return
     */
    int addForExam(Teacher_exam teacher_exam);

    /**
     *为某场考试批量添加监考教师
     * @param teacher_exams
     * @return
     */
    int batchAddForExam(List<Teacher_exam> teacher_exams);

    /**
     * 为某场考试删除监考教师
     * @param id
     * @param exam_id
     * @return
     */
    int deleteForExam(@Param("teacher_exam_teacher_id")int id, @Param("teacher_exam_exam_id")int exam_id);

    /**
     *为某场考试批量删除监考教师
     * @param teacher_ids
     * @param exam_id
     * @return
     */
    int batchDeleteForExam(@Param("list")List<Integer> teacher_ids, @Param("teacher_exam_exam_id")int exam_id);

    //--------------------------------------单表操作---------------------------------------------------
    /**
     * 根据主键查询一条数据
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
     * @param teacher
     * @return
     */
    @Override
    List<Teacher> findByCondition(Teacher teacher);

    /**
     * 根据条件查询数据数量
     *
     * @param teacher
     * @return
     */
    @Override
    int findCountByCondition(Teacher teacher);

    /**
     * 添加数据,返回主键
     *
     * @param teacher
     * @return
     */
    @Override
    int add(Teacher teacher);

    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    @Override
    int deleteByPrimaryKey(Integer id);

    /**
     *批量删除教师
     * @param ids
     * @return
     */
    int batchDelete(List<Integer> ids);

    /**
     * 更新数据
     *
     * @param teacher
     * @return
     */
    @Override
    int update(Teacher teacher);
}
