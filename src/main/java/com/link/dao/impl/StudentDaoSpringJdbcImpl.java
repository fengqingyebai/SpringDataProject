package com.link.dao.impl;


import com.link.dao.StudentDao;
import com.link.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * studentDao 访问接口实现类 通过spring的JDBC的方式操作
 *
 * @author link
 * @create 2018-04-03-23:54
 */
public class StudentDaoSpringJdbcImpl implements StudentDao {

   private JdbcTemplate jdbcTemplate;
    /**
     * 实现查询
     * @return
     */
    @Override
    public List<Student> query() {

        String sql="select id,name,age from student";
        final List<Student> studentList= new ArrayList<Student>();
        jdbcTemplate.query(sql,new RowCallbackHandler(){
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Student student = new Student();

                student.setId(id);
                student.setAge(age);
                student.setName(name);
                studentList.add(student);
            }
        });

        return studentList;
    }



    @Override
    public void save(Student student) {
        String sql="insert into student(name, age) values(?,?)";
        jdbcTemplate.update(sql,new Object[]{student.getName(),student.getAge()});
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
