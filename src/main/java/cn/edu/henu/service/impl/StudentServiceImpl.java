package cn.edu.henu.service.impl;

import cn.edu.henu.bean.PageBean;
import cn.edu.henu.bean.Student;
import cn.edu.henu.bean.Student;
import cn.edu.henu.bean.Student_exam;
import cn.edu.henu.dao.ExamMapper;
import cn.edu.henu.dao.StudentMapper;
import cn.edu.henu.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentSer")
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ExamMapper examMapper;
    
   @Override
   public Student login(String id, String password) {
       System.out.println("业务层登录校验...");
       try {
           Student student = studentMapper.findByPrimaryKey(Integer.parseInt(id));
           if (student != null && password.equals(student.getStudent_password())) {
               return student;
           }
           return null;
       } catch (NumberFormatException e) {
           return null;
       }
   }

    @Override
    public List<Student> findAll() {
        try {
            return studentMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public Student findByPrimaryKey(Integer id) {
        try {
            return studentMapper.findByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Student> findByCondition(Student student) {
        try {
            List<Student> students ;
            if (student != null) {
                students = studentMapper.findByCondition(student);
            } else {
                students = studentMapper.findAll();
            }
            return students;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer add(Student student) {
        try {
            return studentMapper.add(student);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        try {
            int i = studentMapper.deleteByPrimaryKey(id);
            return i >= 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Student student) {
        try {
            int i = studentMapper.update(student);
            return i >= 1;
        } catch (Exception e) {
            return false;
        }
    }
    //--------------------------------------------------
    /**
     * 查询所有考生及其报名的考试
     *
     * @return
     */
    @Override
    public List<Student> findAllStudentWithExam() {
        try {
            return studentMapper.findAllStudentWithExam();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据考试id查询所有所有考生
     *
     * @param id 考试id
     * @return
     */
    @Override
    public List<Student> findStudentByExam(Integer id) {
        try {
            List<Student> students;
            if (id != null) {
                students = studentMapper.findStudentByExam(id);
            } else {
                students = studentMapper.findAllStudentWithExam();
            }
            return students;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据学生id和考试id添加某场考试的考生
     *
     * @param student_exam
     * @return
     */
    @Override
    public Integer addForExam(Student_exam student_exam){
        try {
            return studentMapper.addForExam(student_exam);//添加的个数
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 根据学生id和考试id删除某场考试的考生
     *
     * @param student_id
     * @param exam_id
     * @return
     */
    @Override
    public boolean deleteForExam(Integer student_id, Integer exam_id) {
        try {
            int i = studentMapper.deleteForExam(student_id,exam_id);
            return i >= 1;
        } catch (Exception e) {
            return false;
        }
    }
}
