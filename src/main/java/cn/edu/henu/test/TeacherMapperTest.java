package cn.edu.henu.test;

import cn.edu.henu.bean.Teacher;
import cn.edu.henu.dao.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
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
        teacher.setTeacher_id(10011001);
        teacher.setTeacher_password("123456");
        teacher.setTeacher_name("师四");
        teacher.setTeacher_faculty("计算机与信息工程学院");
        teacher.setTeacher_major("计算机科学与技术");
        teacherMapper.add(teacher);
        System.out.println(teacher);
    }

    @Test
    public void deleteByPrimaryKey() {
        int i = teacherMapper.deleteByPrimaryKey(10121314);
        System.out.println(i);
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
}