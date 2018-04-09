package com.link.service;


import com.link.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * service层
 *
 * @author link
 * @create 2018-04-09-7:53
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional
    public void updateEmployee(Integer id,Integer age){
        employeeRepository.updateEmployee(id,age);
    }


    @Transactional
    public void deleteEmployee(Integer id){
        employeeRepository.deleteEmployee(id);
    }

}
