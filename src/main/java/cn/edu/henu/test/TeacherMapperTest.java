package cn.edu.henu.test;

import cn.edu.henu.bean.Exam;
import cn.edu.henu.bean.Teacher;
import cn.edu.henu.bean.Teacher_exam;
import cn.edu.henu.dao.TeacherMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TeacherMapperTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private TeacherMapper teacherMapper;

    @Before
    public void setUp() throws Exception { 
        // 读取配置文件，生成字节输入流
        inputStream = Resources.getResourceAsStream("test/SqlMapConfig.xml");
        // 获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession对象
        sqlSession = factory.openSession();
        // 获取dao的代理对象
        teacherMapper = sqlSession.getMapper(TeacherMapper.class);

    }

    @After
    public void tearDown() throws Exception {
        // 提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
        inputStream.close();
    }
    //-----------------------------------单表测试-----------------------------------------
    @Test
    public void findByPrimaryKey() {
        Teacher teacher = teacherMapper.findByPrimaryKey(10112001);
        System.out.println(teacher);
    }

    @Test
    public void findAll() {
        List<Teacher> teachers = teacherMapper.findAll();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    @Test
    public void findAllCount() {
        int i = teacherMapper.findAllCount();
        System.out.println(i);
    }

    @Test
    public void findByCondition() {
        Teacher teacher = new Teacher();
        teacher.setTeacher_major("计算机科学与技术");
        List<Teacher> teachers = teacherMapper.findByCondition(teacher);
        for (Teacher t : teachers) {
            System.out.println(t);
        }
    }

    @Test
    public void findCountByCondition() {
        Teacher teacher = new Teacher();
        teacher.setTeacher_major("计算机科学与技术");
        int total = teacherMapper.findCountByCondition(teacher);
            System.out.println(total);
    }

    @Test
    public void add() {
        Teacher teacher = new Teacher();
        teacher.setTeacher_id(10000003);
        teacher.setTeacher_password("123456");
        teacher.setTeacher_name("师三");
        teacher.setTeacher_faculty("计算机与信息工程学院");
        teacher.setTeacher_major("计算机科学与技术");
        int i=teacherMapper.add(teacher);
        System.out.println(i);
        System.out.println(teacher);
    }

    @Test
    public void deleteByPrimaryKey() {
        int i = teacherMapper.deleteByPrimaryKey(10121314);
        System.out.println(i);
    }
    @Test
    public void batchDelete(){
        Teacher t=new Teacher();
        List<Integer> ids=new ArrayList<Integer>();

        t.setTeacher_id(10131001);
        ids.add(t.getTeacher_id());
        t.setTeacher_id(10011001);
        ids.add(t.getTeacher_id());

        int i=teacherMapper.batchDelete(ids);
        System.out.println(i);
        System.out.println(ids);
    }
    @Test
    public void update() {
        Teacher teacher = new Teacher();
        teacher.setTeacher_id(10111001);
        teacher.setTeacher_password("123456");
        teacher.setTeacher_name("师新");
        teacher.setTeacher_faculty("计算机与信息工程学院");
        teacher.setTeacher_major("信息安全");
        int i = teacherMapper.update(teacher);
        System.out.println(i);

    }

    //------------------------------------联表测试---------------------------------------------
    @Test
    public void findAllTeacherWithExam() {
        List<Teacher> teachers=teacherMapper.findAllTeacherWithExam();
        //System.out.println(teachers);
        for (Teacher t :  teachers) {
            System.out.println(t);
        }
    }
    @Test
    public void findAllCountTeacherWithExam() {
        int i=teacherMapper.findAllCountTeacherWithExam();
        System.out.println(i);
    }
    @Test
    public void findTeacherWithExam() {
        Teacher teacher=new Teacher();
        Exam exam = new Exam();
        exam.setExam_id(1);
        List<Teacher> teachers=teacherMapper.findTeacherWithExam(exam.getExam_id());
        //System.out.println(teachers);
        for (Teacher t :  teachers) {
            System.out.println(t);
        }
    }
    @Test
    public void findTeacherCountWithExam() {
        Exam exam = new Exam();
        exam.setExam_id(1);
        int i=teacherMapper.findTeacherCountWithExam(exam.getExam_id());
        System.out.println(i);
    }
    @Test
    public void addForExam()
    {
        Teacher teacher=new Teacher();
        Exam exam = new Exam();
        Teacher_exam teacher_exam=new Teacher_exam();
        exam.setExam_id(2);
        teacher.setTeacher_id(10112001);
        teacher_exam.setTeacher_exam_exam_id(exam.getExam_id());
        teacher_exam.setTeacher_exam_teacher_id(teacher.getTeacher_id());
        int i=teacherMapper.addForExam(teacher_exam);
        System.out.println(i);
        System.out.println(teacher_exam);
    }

    @Test
    public void batchAddForExam()
    {
        Teacher t=new Teacher();
        Exam e = new Exam();
        Teacher_exam te1=new Teacher_exam();
        Teacher_exam te2=new Teacher_exam();
        List<Teacher_exam> tes=new ArrayList<Teacher_exam>();

        e.setExam_id(1);
        t.setTeacher_id(10000001);
        te1.setTeacher_exam_exam_id(e.getExam_id());
        te1.setTeacher_exam_teacher_id(t.getTeacher_id());

        e.setExam_id(2);
        t.setTeacher_id(10000002);
        te2.setTeacher_exam_exam_id(e.getExam_id());
        te2.setTeacher_exam_teacher_id(t.getTeacher_id());

        tes.add(te1);
        tes.add(te2);
        int i=teacherMapper.batchAddForExam(tes);
        System.out.println(i);
        System.out.println(tes);
    }
    @Test
    public void deleteForExam(){
        Teacher teacher=new Teacher();
        Exam exam = new Exam();
        Teacher_exam teacher_exam=new Teacher_exam();
        exam.setExam_id(1);
        teacher.setTeacher_id(10000001);
        int i=teacherMapper.deleteForExam(teacher.getTeacher_id(), exam.getExam_id());
        System.out.println(i);
    }

    @Test
    public void batchDeleteForExam(){
        Teacher t=new Teacher();
        Exam e = new Exam();
        List<Integer> ids=new ArrayList<Integer>();

        e.setExam_id(1);
        t.setTeacher_id(10000001);
        ids.add(t.getTeacher_id());

        t.setTeacher_id(10000002);
        ids.add(t.getTeacher_id());

        int i=teacherMapper.batchDeleteForExam(ids,e.getExam_id());
        System.out.println(i);
        System.out.println(ids);
    }

}