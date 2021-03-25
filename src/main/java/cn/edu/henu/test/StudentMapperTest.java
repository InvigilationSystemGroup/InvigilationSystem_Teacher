package cn.edu.henu.test;

import cn.edu.henu.bean.Exam;
import cn.edu.henu.bean.Student;
import cn.edu.henu.bean.Student_exam;
import cn.edu.henu.bean.Teacher;
import cn.edu.henu.dao.StudentMapper;
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

public class StudentMapperTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private StudentMapper studentMapper;

    @Before
    public void setUp() throws Exception {
        // 读取配置文件，生成字节输入流
        inputStream = Resources.getResourceAsStream("test/SqlMapConfig.xml");
        // 获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession对象
        sqlSession = factory.openSession();
        // 获取dao的代理对象
        studentMapper = sqlSession.getMapper(StudentMapper.class);

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
        Student student = studentMapper.findByPrimaryKey(1812030001);
        System.out.println(student);
    }

    @Test
    public void findAll() {
        List<Student> students = studentMapper.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void findAllCount() {
        int i = studentMapper.findAllCount();
        System.out.println(i);
    }

    @Test
    public void findByCondition() {
        Student student = new Student();
        student.setStudent_major("计算机科学与技术");
        List<Student> students = studentMapper.findByCondition(student);
        for (Student t : students) {
            System.out.println(t);
        }
    }

    @Test
    public void findCountByCondition() {
        Student student = new Student();
        student.setStudent_major("计算机科学与技术");
        int total = studentMapper.findCountByCondition(student);
        System.out.println(total);
    }

    @Test
    public void add() {
        Student student = new Student();
        student.setStudent_id(18150002);
        student.setStudent_password("123456");
        student.setStudent_name("学二");
        student.setStudent_faculty("计算机与信息工程学院");
        student.setStudent_major("信息安全");
        int i=studentMapper.add(student);
        System.out.println(i);
        System.out.println(student);
    }

    @Test
    public void deleteByPrimaryKey() {
        int i = studentMapper.deleteByPrimaryKey(18150002);
        System.out.println(i);
    }
    @Test
    public void batchDelete(){
        Student t=new Student();
        List<Integer> ids=new ArrayList<Integer>();

        t.setStudent_id(1812030003);
        ids.add(t.getStudent_id());
        t.setStudent_id(1812030002);
        ids.add(t.getStudent_id());

        int i=studentMapper.batchDelete(ids);
        System.out.println(i);
        System.out.println(ids);
    }
    @Test
    public void update() {
        Student student = new Student();
        student.setStudent_id(1812030003);
        student.setStudent_password("123456");
        student.setStudent_name("学新");
        student.setStudent_faculty("计算机与信息工程学院");
        student.setStudent_major("大数据科学与技术");
        int i = studentMapper.update(student);
        System.out.println(i);

    }

    //-----------------------------------联表测试-----------------------------------------
    @Test
    public void findAllStudentWithExam() {
        List<Student> students=studentMapper.findAllStudentWithExam();
        //System.out.println(students);
        for (Student t :  students) {
            System.out.println(t);
        }
    }
    @Test
    public void findAllCountStudentWithExam() {
        int i=studentMapper.findAllCountStudentWithExam();
        System.out.println(i);
    }
    @Test
    public void findStudentByExam() {
        Student student=new Student();
        Exam exam = new Exam();
        exam.setExam_id(1);
        List<Student> students=studentMapper.findStudentByExam(exam.getExam_id());
        //System.out.println(students);
        for (Student t :  students) {
            System.out.println(t);
        }
    }
    @Test
    public void findStudentCountByExam() {
        Exam exam = new Exam();
        exam.setExam_id(1);
        int i=studentMapper.findStudentCountByExam(exam.getExam_id());
        System.out.println(i);
    }
    @Test
    public void addForExam()
    {
        Student student=new Student();
        Exam exam = new Exam();
        Student_exam student_exam=new Student_exam();

        exam.setExam_id(6);
        student.setStudent_id(1812030004);

        student_exam.setStudent_exam_exam_id(exam.getExam_id());
        student_exam.setStudent_exam_student_id(student.getStudent_id());
        student_exam.setStudent_exam_seat(66);

        int i=studentMapper.addForExam(student_exam);
        System.out.println(i);
        System.out.println(student_exam);
    }

    @Test
    public void batchAddForExam()
    {
        Student t=new Student();
        Exam e = new Exam();
        Student_exam te1=new Student_exam();
        Student_exam te2=new Student_exam();
        List<Student_exam> tes=new ArrayList<Student_exam>();

        e.setExam_id(1);
        t.setStudent_id(1812030004);
        te1.setStudent_exam_exam_id(e.getExam_id());
        te1.setStudent_exam_student_id(t.getStudent_id());

        e.setExam_id(2);
        t.setStudent_id(1812030001);
        te2.setStudent_exam_exam_id(e.getExam_id());
        te2.setStudent_exam_student_id(t.getStudent_id());

        tes.add(te1);
        tes.add(te2);
        int i=studentMapper.batchAddForExam(tes);
        System.out.println(i);
        System.out.println(tes);
    }
    @Test
    public void deleteForExam(){
        Student student=new Student();
        Exam exam = new Exam();
        Student_exam student_exam=new Student_exam();
        exam.setExam_id(1);
        student.setStudent_id(1812030003);
        int i=studentMapper.deleteForExam(student.getStudent_id(), exam.getExam_id());
        System.out.println(i);
    }

    @Test
    public void batchDeleteForExam(){
        Student t=new Student();
        Exam e = new Exam();
        List<Integer> ids=new ArrayList<Integer>();

        e.setExam_id(1);
        t.setStudent_id(1812030004);
        ids.add(t.getStudent_id());

        t.setStudent_id(10000002);
        ids.add(t.getStudent_id());

        int i=studentMapper.batchDeleteForExam(ids,e.getExam_id());
        System.out.println(i);
        System.out.println(ids);
    }
    @Test
    public void updateForExam() {
        Student_exam se = new Student_exam();
        se.setStudent_exam_student_id(1812030001);
        se.setStudent_exam_exam_id(1);
        se.setStudent_exam_seat(88);
        se.setStudent_exam_unlock("2288");
        int i = studentMapper.updateForExam(se);
        System.out.println(i);
    }
}
