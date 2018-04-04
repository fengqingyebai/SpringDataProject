package com.link.dao;


import com.link.dao.impl.StudentDaoImpl;
import com.link.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * 测试studentDaoImpl
 *
 * @author link
 * @create 2018-04-04-0:12
 */
public class StudentDaoImplTest {



    @Test
    public void testQuery(){
        StudentDaoImpl studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.query();

        for(Student student:students){
            System.out.println("id:"+student.getId()+"name:"+student.getName()+"age:"+student.getAge());
        }
    }


    @Test
    public void testSave(){
        Student student = new Student();
        student.setName("zs");
        student.setAge(29);
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.save(student);
    }
}
