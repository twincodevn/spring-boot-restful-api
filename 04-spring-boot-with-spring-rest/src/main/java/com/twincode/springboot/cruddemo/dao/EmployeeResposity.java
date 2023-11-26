package com.twincode.springboot.cruddemo.dao;

import com.twincode.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeResposity extends JpaRepository<Employee, Integer> {


}
