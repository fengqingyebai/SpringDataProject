package com.link.dao;

import com.link.domain.Student;

import java.util.List;

/**
 * studentDao访问接口
 *
 * @author link
 * @create 2018-04-03-23:49
 */
public interface StudentDao {

    public List<Student> query();

    public void save(Student student);

}
