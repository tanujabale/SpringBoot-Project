package com.emp.EmployeeMgmt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.EmployeeMgmt.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Optional<Employee> findByEmail(String email);
    Optional<Employee> findByMobile(String mobile);
}