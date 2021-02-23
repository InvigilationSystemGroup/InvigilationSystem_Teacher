package cn.edu.henu.dao;

import cn.edu.henu.bean.Exam;
import cn.edu.henu.bean.Teacher;
import cn.edu.henu.bean.Teacher_exam;
import cn.edu.henu.bean.Student_exam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamMapper  extends CrudDao<Exam> {
    //-------------------------------------联表操作---------------------------------------------------
    //teacher和exam联表
    /**
     *查询某位教师的监考任务（即监考的考试）
     * @param id
     * @return
     */
    List<Exam> findExamWithTeacher(int id);

    /**
     * 查询某位教师的监考任务数量
     * @param id
     * @return
     */
    int findExamCountWithTeacher(int id);

    /**
     *为某位教师添加监考任务
     * @param teacher_exam
     * @return
     */
    int addForTeacher(Teacher_exam teacher_exam);

    /**
     *为某位教师批量添加监考任务
     * @param teacher_exams
     * @return
     */
    int batchAddForTeacher(List<Teacher_exam> teacher_exams);

    /**
     * 为某位教师删除监考任务
     * @param id
     * @param exam_id
     * @return
     */
    int deleteForTeacher(@Param("teacher_exam_teacher_id")int id, @Param("teacher_exam_exam_id")int exam_id);

    /**
     *为某位教师批量删除监考任务
     * @param ids
     * @param teacher_id
     * @return
     */
    int batchDeleteForTeacher(@Param("list")List<Integer> ids, @Param("teacher_exam_teacher_id")int teacher_id);

    //student和exam联表
    /**
     * 查询某位学生参加的考试
     * @param id
     * @return
     */
    List<Exam> findExamWithStudent(int id);

    /**
     * 查询某位学生参加的考试数量
     * @param id
     * @return
     */
    int findExamCountWithStudent(int id);

    /**
     * 为某位学生添加考试
     * @param student_exam
     * @return
     */
    int addForStudent(Student_exam student_exam);

    /**
     * 为某位学生批量添加考试
     * @param student_exams
     * @return
     */
    int batchAddForStudent(List<Student_exam> student_exams);

    /**
     * 为某位学生删除考试
     * @param id
     * @param exam_id
     * @return
     */
    int deleteForStudent(@Param("student_exam_student_id")int id, @Param("student_exam_exam_id")int exam_id);

    /**
     * 为某位学生批量删除考试
     * @param ids
     * @param student_id
     * @return
     */
    int batchDeleteForStudent(@Param("list")List<Integer> ids, @Param("student_exam_student_id")int student_id);

    //--------------------------------------单表操作---------------------------------------------------
    /**
     * 根据主键查询一条数据
     *
     * @param id
     * @return
     */
    @Override
    Exam findByPrimaryKey(Integer id);

    /**
     * 查询全部数据
     *
     * @return
     */
    @Override
    List<Exam>  findAll();

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
     * @param exam
     * @return
     */
    @Override
    List<Exam> findByCondition(Exam exam);

    /**
     * 根据条件查询数据数量
     *
     * @param exam
     * @return
     */
    @Override
    int findCountByCondition(Exam exam);

    /**
     * 添加数据,返回主键
     *
     * @param exam
     * @return
     */
    @Override
    int add(Exam exam);

    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    @Override
    int deleteByPrimaryKey(Integer id);

    /**
     *批量删除考试
     * @param ids
     * @return
     */
    int batchDelete(List<Integer> ids);

    /**
     * 更新数据
     *
     * @param exam
     * @return
     */
    @Override
    int update(Exam exam);
}
