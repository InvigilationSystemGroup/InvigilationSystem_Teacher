package cn.edu.henu.test;

import cn.edu.henu.bean.*;
import cn.edu.henu.dao.ExamMapper;
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

public class ExamMapperTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private ExamMapper examMapper;

    @Before
    public void setUp() throws Exception {
        // 读取配置文件，生成字节输入流
        inputStream = Resources.getResourceAsStream("test/SqlMapConfig.xml");
        // 获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession对象
        sqlSession = factory.openSession();
        // 获取dao的代理对象
        examMapper = sqlSession.getMapper(ExamMapper.class);

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
        Exam exam = examMapper.findByPrimaryKey(1);
        System.out.println(exam);
    }

    @Test
    public void findAll() {
        List<Exam> exams = examMapper.findAll();
        for (Exam exam : exams) {
            System.out.println(exam);
        }
    }

    @Test
    public void findAllCount() {
        int i = examMapper.findAllCount();
        System.out.println(i);
    }

    @Test
    public void findByCondition() {
        Exam exam = new Exam();
        exam.setExam_capacity(100);
        List<Exam> exams = examMapper.findByCondition(exam);
        for (Exam e : exams) {
            System.out.println(e);
        }
    }

    @Test
    public void findCountByCondition() {
        Exam exam = new Exam();
        exam.setExam_capacity(100);
        int total = examMapper.findCountByCondition(exam);
        System.out.println(total);
    }

    @Test
    public void add() {
        Exam exam = new Exam();
        exam.setExam_name("C#程序设计");
        exam.setExam_starttime("2021-03-26 14:30:00");
        exam.setExam_endtime("2021-03-26 17:30:00");
        exam.setExam_room("608");
        exam.setExam_capacity(100);
        exam.setExam_ipwhite("https://www.baidu.com/");
        int i=examMapper.add(exam);
        System.out.println(i);
        System.out.println(exam);
    }

    @Test
    public void deleteByPrimaryKey() {
        int i = examMapper.deleteByPrimaryKey(3);
        System.out.println(i);
    }

    @Test
    public void batchDelete(){
        Exam e=new Exam();
        List<Integer> ids=new ArrayList<Integer>();

        e.setExam_id(4);
        ids.add(e.getExam_id());
        e.setExam_id(5);
        ids.add(e.getExam_id());

        int i=examMapper.batchDelete(ids);
        System.out.println(i);
        System.out.println(ids);
    }
    @Test
    public void update() {
        Exam exam = new Exam();
        exam.setExam_id(4);
        exam.setExam_name("C#程序设计");
        exam.setExam_starttime("2021-03-26 14:30:00");
        exam.setExam_endtime("2021-03-26 17:30:00");
        exam.setExam_room("611");
        exam.setExam_capacity(100);
        exam.setExam_ipwhite("https://www.baidu.com/");
        int i = examMapper.update(exam);
        System.out.println(i);

    }

    //-----------------------------------联表测试-----------------------------------------
    //teacher和exam联表测试
    @Test
    public void findExamByTeacher() {
        Exam exam=new Exam();
        Teacher teacher = new Teacher();
        teacher.setTeacher_id(10000001);
        List<Exam> exams=examMapper.findExamByTeacher(teacher.getTeacher_id());
        //System.out.println(exams);
        for (Exam t :  exams) {
            System.out.println(t);
        }
    }
    @Test
    public void findExamCountByTeacher() {
        Teacher teacher = new Teacher();
        teacher.setTeacher_id(10000001);
        int i=examMapper.findExamCountByTeacher(teacher.getTeacher_id());
        System.out.println(i);
    }
    @Test
    public void addForTeacher()
    {
        Teacher teacher=new Teacher();
        Exam exam = new Exam();
        Teacher_exam teacher_exam=new Teacher_exam();
        exam.setExam_id(6);
        teacher.setTeacher_id(10000001);
        teacher_exam.setTeacher_exam_exam_id(exam.getExam_id());
        teacher_exam.setTeacher_exam_teacher_id(teacher.getTeacher_id());
        int i=examMapper.addForTeacher(teacher_exam);
        System.out.println(i);
        System.out.println(teacher_exam);
    }

    @Test
    public void batchAddForTeacher()
    {
        Teacher t=new Teacher();
        Exam e = new Exam();
        Teacher_exam te1=new Teacher_exam();
        Teacher_exam te2=new Teacher_exam();
        List<Teacher_exam> tes=new ArrayList<Teacher_exam>();

        e.setExam_id(6);
        t.setTeacher_id(10000002);
        te1.setTeacher_exam_exam_id(e.getExam_id());
        te1.setTeacher_exam_teacher_id(t.getTeacher_id());

        e.setExam_id(6);
        t.setTeacher_id(10111001);
        te2.setTeacher_exam_exam_id(e.getExam_id());
        te2.setTeacher_exam_teacher_id(t.getTeacher_id());

        tes.add(te1);
        tes.add(te2);
        int i=examMapper.batchAddForTeacher(tes);
        System.out.println(i);
        System.out.println(tes);
    }
    @Test
    public void deleteForTeacher(){
        Exam exam=new Exam();
        Teacher teacher = new Teacher();
        Teacher_exam teacher_exam=new Teacher_exam();
        exam.setExam_id(1);
        teacher.setTeacher_id(10000002);
        int i=examMapper.deleteForTeacher(teacher.getTeacher_id(), exam.getExam_id());
        System.out.println(i);
    }

    @Test
    public void batchDeleteForTeacher(){
        Teacher t = new Teacher();
        Exam e = new Exam();
        List<Integer> ids=new ArrayList<Integer>();

        t.setTeacher_id(10000001);

        e.setExam_id(1);
        ids.add(e.getExam_id());

        e.setExam_id(2);
        ids.add(e.getExam_id());

        int i=examMapper.batchDeleteForTeacher(ids,t.getTeacher_id());
        System.out.println(i);
        System.out.println(ids);
    }

    //student和exam联表测试
    @Test
    public void findExamByStudent() {
        Exam exam=new Exam();
        Student student = new Student();
        student.setStudent_id(1812030001);
        List<Exam> exams=examMapper.findExamByStudent(student.getStudent_id());
        //System.out.println(exams);
        for (Exam t :  exams) {
            System.out.println(t);
        }
    }
    @Test
    public void findExamCountByStudent() {
        Student student = new Student();
        student.setStudent_id(1812030001);
        int i=examMapper.findExamCountByStudent(student.getStudent_id());
        System.out.println(i);
    }
    @Test
    public void addForStudent()
    {
        Student student=new Student();
        Exam exam = new Exam();
        Student_exam student_exam=new Student_exam();
        exam.setExam_id(6);
        student.setStudent_id(1812030001);
        student_exam.setStudent_exam_exam_id(exam.getExam_id());
        student_exam.setStudent_exam_student_id(student.getStudent_id());
        int i=examMapper.addForStudent(student_exam);
        System.out.println(i);
        System.out.println(student_exam);
    }

    @Test
    public void batchAddForStudent()
    {
        Student t=new Student();
        Exam e = new Exam();
        Student_exam te1=new Student_exam();
        Student_exam te2=new Student_exam();
        List<Student_exam> tes=new ArrayList<Student_exam>();

        e.setExam_id(6);
        t.setStudent_id(1710151003);
        te1.setStudent_exam_exam_id(e.getExam_id());
        te1.setStudent_exam_student_id(t.getStudent_id());

        e.setExam_id(2);
        t.setStudent_id(1710151003);
        te2.setStudent_exam_exam_id(e.getExam_id());
        te2.setStudent_exam_student_id(t.getStudent_id());

        tes.add(te1);
        tes.add(te2);
        int i=examMapper.batchAddForStudent(tes);
        System.out.println(i);
        System.out.println(tes);
    }
    @Test
    public void deleteForStudent(){
        Exam exam=new Exam();
        Student student = new Student();
        Student_exam student_exam=new Student_exam();
        exam.setExam_id(1);
        student.setStudent_id(1710151003);
        int i=examMapper.deleteForStudent(student.getStudent_id(), exam.getExam_id());
        System.out.println(i);
    }

    @Test
    public void batchDeleteForStudent(){
        Student t = new Student();
        Exam e = new Exam();
        List<Integer> ids=new ArrayList<Integer>();

        t.setStudent_id(1710151003);

        e.setExam_id(2);
        ids.add(e.getExam_id());

        e.setExam_id(4);
        ids.add(e.getExam_id());

        int i=examMapper.batchDeleteForStudent(ids,t.getStudent_id());
        System.out.println(i);
        System.out.println(ids);
    }
}
