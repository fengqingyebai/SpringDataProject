package com.link.repository;


import com.link.domain.Employee;
import org.springframework.data.repository.Repository;

/**
 * 员工的数据访问组件接口
 *
 * @author link
 * @create 2018-04-08-23:04
 */
public interface EmployeeRepository  extends Repository<Employee,Integer> {


  public Employee findByName(String name);


}
