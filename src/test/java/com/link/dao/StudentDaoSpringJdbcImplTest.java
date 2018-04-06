package com.link.dao;


import com.link.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 测试 Datasource
 *
 * @author link
 * @create 2018-04-04-7:31
 */
public class StudentDaoSpringJdbcImplTest {

    private ApplicationContext context=null;
    private StudentDao studentDao;

    @Before
    public void setContext(){
        context = new ClassPathXmlApplicationContext("bean-new.xml");
        studentDao = (StudentDao)context.getBean("studentDao");
        System.out.println("setContext");
    }

    /**
     * 测试datasource
     */
    @Test
    public void testQuery(){
        System.out.println("dataSourceTest");
       List<Student> studentList= studentDao.query();
        for(Student student:studentList){
            System.out.println("id:"+student.getId()+"name:"+student.getName()+"age:"+student.getAge());
        }
    }

    @After
    public void tearContext(){
        context=null;
        System.out.println("tearContext");
    }

    @Test
   public  void  jdbcSaveTest(){
        Student student = new Student();
        student.setName("link");
        student.setAge(29);

        studentDao.save(student);
    }


}
