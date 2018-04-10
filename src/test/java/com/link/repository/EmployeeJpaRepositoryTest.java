package com.link.repository;

import com.link.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by IntelliJ IDEA.
 * User: link
 * Date: 2018/4/9
 * Time: 14:51
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeJpaRepositoryTest {

    private ApplicationContext context = null;
    private EmployeeJpaRepository employeeJpaRepository = null;

    @Before
    public void setContext() {
        context = new ClassPathXmlApplicationContext("bean-new.xml");
        employeeJpaRepository = context.getBean(EmployeeJpaRepository.class);
        System.out.println("setContext");
    }


    @After
    public void tearContext() {
        context = null;
        System.out.println("tearContext");
    }


    @Test
    public void testJpaFind() {
        Employee employee= employeeJpaRepository.findOne(6);

        System.out.println("employee:"+employee);
        System.out.println("employee(10):"+employeeJpaRepository.exists(10));
        System.out.println("employee(102):"+employeeJpaRepository.exists(102));




    }




}
