package com.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.module.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
