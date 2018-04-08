package com.link.repository;


import com.link.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * springdata测试
 *
 * @author link
 * @create 2018-04-08-23:17
 */
public class EmployeeRepositoryTest {

    private ApplicationContext context = null;
    private EmployeeRepository employeeRepository = null;

    @Before
    public void setContext() {
        context = new ClassPathXmlApplicationContext("bean-new.xml");
        employeeRepository = context.getBean(EmployeeRepository.class);
        System.out.println("setContext");
    }

    /**
     * 测试EntityManagerFactory
     */
    @Test
    public void testEmployeeRepository() {
        Employee employee = employeeRepository.findByName("zhangsan");

        System.out.println("id: " + employee.getId() + " ,name: " + employee.getName() + " ,age: " + employee.getAge());
    }

    @After
    public void tearContext() {
        context = null;
        System.out.println("tearContext");
    }

}
