package com.link.crudRepository;

import com.link.domain.Employee;
import com.link.repository.EmployeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: link
 * Date: 2018/4/9
 * Time: 14:51
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeCrudRepositoryTest {

    private ApplicationContext context = null;
    private EmployeeCrudRepository employeeCrudRepository = null;

    @Before
    public void setContext() {
        context = new ClassPathXmlApplicationContext("bean-new.xml");
        employeeCrudRepository = context.getBean(EmployeeCrudRepository.class);
        System.out.println("setContext");
    }


    @After
    public void tearContext() {
        context = null;
        System.out.println("tearContext");
    }


    @Test
    public void testCrudSave() {

        List<Employee> employees = new ArrayList<Employee>();

        for (int i = 100; i >= 0; i--) {
            Employee employee = new Employee();
            employee.setAge(i);
            employee.setName("test" + i);
            employees.add(employee);
        }


        employeeCrudRepository.save(employees);

    }


}
