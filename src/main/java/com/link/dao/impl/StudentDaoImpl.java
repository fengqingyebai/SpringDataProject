package com.link.dao.impl;


import com.link.dao.StudentDao;
import com.link.domain.Student;
import com.link.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * studentDao 访问接口实现类 通过原始方式的JDBC的方式操作
 *
 * @author link
 * @create 2018-04-03-23:54
 */
public class StudentDaoImpl implements StudentDao {


    /**
     * 实现查询
     * @return
     */
    @Override
    public List<Student> query() {

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select id,name,age from student";
        List<Student> studentList= new ArrayList<Student>();
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Student student=null;
            while(resultSet.next()){

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                student = new Student();

                student.setId(id);
                student.setAge(age);
                student.setName(name);
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(resultSet,preparedStatement,connection);
        }




        return studentList;
    }



    @Override
    public void save(Student student) {

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="insert into student(name, age) values(?,?)";

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(resultSet,preparedStatement,connection);
        }
    }

}
