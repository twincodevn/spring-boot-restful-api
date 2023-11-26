package com.twincode.springboot.cruddemo.service;

import com.twincode.springboot.cruddemo.dao.EmployeeResposity;
import com.twincode.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeResposity employeeResposity;

    @Autowired
    public EmployeeServiceImpl(EmployeeResposity employeeResposity) {
        this.employeeResposity = employeeResposity;
    }

    @Override
    public List<Employee> findAll() {
        return employeeResposity.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeResposity.findById(theId);
        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee= result.get();
        }else{
            throw new RuntimeException("The id not found " + theId);
        }
        return theEmployee;
    }


    @Override
    public Employee save(Employee theEmployee) {
        return employeeResposity.save(theEmployee);
    }


    @Override
    public void deleteById(int theId) {
        employeeResposity.deleteById(theId);
    }
}
