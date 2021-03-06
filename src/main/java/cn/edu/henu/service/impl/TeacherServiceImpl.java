package cn.edu.henu.service.impl;

import cn.edu.henu.bean.Exam;
import cn.edu.henu.bean.PageBean;
import cn.edu.henu.bean.Teacher_exam;
import cn.edu.henu.dao.TeacherMapper;
import cn.edu.henu.dao.ExamMapper;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.henu.bean.Teacher;
import cn.edu.henu.service.ITeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherSer")
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private ExamMapper examMapper;

   /* void initPageBean(PageBean<Teacher> pageBean, Teacher product, Integer row) {
        pageBean.setRows(row);
        int total = teacherMapper.findAllCount();
        pageBean.setTotalCount(total);
        int rows = pageBean.getRows();
        int a = total % rows;
        int b = total / rows;
        pageBean.setTotalPage(a == 0 ? b : b + 1);
    }*/

    @Override
    public Teacher login(String id, String password) {
        System.out.println("业务层登录校验...");
        try {
            Teacher teacher = teacherMapper.findByPrimaryKey(Integer.parseInt(id));
            if (teacher != null && password.equals(teacher.getTeacher_password())) {
                return teacher;
            }
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public List<Teacher> findAll() {
        try {
            return teacherMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Teacher findByPrimaryKey(Integer id) {
        try {
            return teacherMapper.findByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Teacher> findByCondition(Teacher teacher) {
        try {
            List<Teacher> teachers ;
            if (teacher != null) {
                teachers = teacherMapper.findByCondition(teacher);
            } else {
                teachers = teacherMapper.findAll();
            }
            return teachers;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


   /* @Override
    public PageBean<Teacher> findByCondition(Teacher teacher,int row) {
        try {
            List<Teacher> teachers;
            if (teacher != null) {
                teachers = teacherMapper.findByCondition(teacher);
            } else {
                teachers = teacherMapper.findAll();
            }
            PageBean<Teacher> pageBean = new PageBean<>();
            initPageBean(pageBean, teacher, row);
            pageBean.setList(teachers);
            return pageBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
*/
    @Override
    public Integer add(Teacher teacher) {
        try {
            return teacherMapper.add(teacher);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        try {
            int i = teacherMapper.deleteByPrimaryKey(id);
            return i >= 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Teacher teacher) {
        try {
            int i = teacherMapper.update(teacher);
            return i >= 1;
        } catch (Exception e) {
            return false;
        }
    }
    //-----------------------teacher和exam-----------------------------------
    /**
     * 查询所有有监考任务的监考教师及其监考的考试
     *
     * @return
     */
    @Override
    public List<Teacher> findAllTeacherWithExam() {
        try {
            return teacherMapper.findAllTeacherWithExam();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据考试id查询所有监考教师及其监考的考试
     *
     * @param id 考试id
     * @return
     */
    @Override
    public List<Teacher> findTeacherByExam(Integer id) {
        try {
            List<Teacher> teachers;
            if (id != null) {
                teachers = teacherMapper.findTeacherByExam(id);
            } else {
                teachers = teacherMapper.findAllTeacherWithExam();
            }
            return teachers;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据教师id和考试id添加某场考试的监考教师
     *
     * @param teacher_exam
     * @return
     */
    @Override
    public Integer addForExam(Teacher_exam teacher_exam){
        try {
            return teacherMapper.addForExam(teacher_exam);//添加的个数
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 根据教师id和考试id删除某场考试的监考教师
     *
     * @param teacher_id
     * @param exam_id
     * @return
     */
    @Override
    public boolean deleteForExam(Integer teacher_id, Integer exam_id) {
        try {
            int i = teacherMapper.deleteForExam(teacher_id,exam_id);
            return i >= 1;
        } catch (Exception e) {
            return false;
        }
    }
}
