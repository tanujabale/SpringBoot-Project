//package com.employee.services;
//
//import java.util.List;
//import java.util.Optional;
//
//import com.employee.dao.EmployeeRepo;
//import com.employee.module.Employee;
//
//public class EmployeeServicesImp implements EmployeeServices {
//	
//	private EmployeeRepo empRepo;
//
//	@Override
//	public Employee saveEmployee(Employee employee) {
//
//		return empRepo.save(employee);
//	}
//
//	@Override
//	public List<Employee> getAllEmployees() {
//
//		return empRepo.findAll();
//	}
//
//	@Override
//	public Employee getEmployeeById(int empId) {
//		Optional<Employee> employee = empRepo.findById(empId);
//		return employee.orElse(null);
//	}
//
//	@Override
//	public void deleteemployee(int empId) {
//		
//		empRepo.deleteById(empId);
//		
//	}
//
//	@Override
//	public Employee updateEmployee(Employee employee) {
//		
//		return empRepo.save(employee);
//	}
//
//}
