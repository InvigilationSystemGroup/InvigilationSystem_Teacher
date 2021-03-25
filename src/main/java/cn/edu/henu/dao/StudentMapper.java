package cn.edu.henu.dao;

import cn.edu.henu.bean.Student;
import cn.edu.henu.bean.Student_exam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper extends CrudDao<Student>{
    //-------------------------------------联表操作---------------------------------------------------
    /**
     *查询所有考生及其报名的考试
     * @return
     */
    List<Student> findAllStudentWithExam();

    /**
     *查询所有考生及其报名的考试数量
     * @return
     */
    int findAllCountStudentWithExam();

    /**
     *查询某场考试的考生
     * @param id
     * @return
     */
    List<Student> findStudentByExam(int id);

    /**
     * 查询某场考试的考生数量
     * @param id
     * @return
     */
    int findStudentCountByExam(int id);

    /**
     *为某场考试添加考生
     * @param student_exam
     * @return
     */
    int addForExam(Student_exam student_exam);

    /**
     *为某场考试批量添加考生
     * @param student_exams
     * @return
     */
    int batchAddForExam(List<Student_exam> student_exams);

    /**
     * 为某场考试删除考生
     * @param id
     * @param exam_id
     * @return
     */
    int deleteForExam(@Param("student_exam_student_id")int id, @Param("student_exam_exam_id")int exam_id);

    /**
     *为某场考试批量删除考生
     * @param student_ids
     * @param exam_id
     * @return
     */
    int batchDeleteForExam(@Param("list")List<Integer> student_ids, @Param("student_exam_exam_id")int exam_id);

    /**
     *
     * @param student_exam
     * @return
     */
    int updateForExam(Student_exam student_exam);

    //--------------------------------------单表操作---------------------------------------------------
    /**
     * 根据主键查询一条数据
     *
     * @param id
     * @return
     */
    @Override
    Student findByPrimaryKey(Integer id);

    /**
     * 查询全部数据
     *
     * @return
     */
    @Override
    List<Student>  findAll();

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
     * @param student
     * @return
     */
    @Override
    List<Student> findByCondition(Student student);

    /**
     * 根据条件查询数据数量
     *
     * @param student
     * @return
     */
    @Override
    int findCountByCondition(Student student);

    /**
     * 添加数据,返回主键
     *
     * @param student
     * @return
     */
    @Override
    int add(Student student);

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
     * @param student
     * @return
     */
    @Override
    int update(Student student);
}
