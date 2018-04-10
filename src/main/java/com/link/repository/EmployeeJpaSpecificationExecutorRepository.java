package com.link.repository;

import com.link.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by IntelliJ IDEA.
 * User: link
 * Date: 2018/4/9
 * Time: 14:48
 * To change this template use File | Settings | File Templates.
 */
public interface EmployeeJpaSpecificationExecutorRepository extends JpaRepository<Employee,Integer>,JpaSpecificationExecutor<Employee> {

}
