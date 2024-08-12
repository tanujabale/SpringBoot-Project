package com.emp.EmployeeMgmt.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @NotBlank(message = "Employee name is mandatory")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String employeeName;

    @NotNull(message = "Date of joining is mandatory")
    private LocalDate dateOfJoining;

    @NotBlank(message = "Mobile number is mandatory")
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Mobile number must be 10 digits and start with 6, 7, 8, or 9")
    private String mobile;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Positive(message = "Salary must be positive")
    private Double salary;

    @NotBlank(message = "Designation is mandatory")
    private String designation;

    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Alternative mobile must be 10 digits and start with 6, 7, 8, or 9")
    private String alternativeMobile;
    
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getAlternativeMobile() {
		return alternativeMobile;
	}
	public void setAlternativeMobile(String alternativeMobile) {
		this.alternativeMobile = alternativeMobile;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", dateOfJoining="
				+ dateOfJoining + ", mobile=" + mobile + ", email=" + email + ", salary=" + salary + ", designation="
				+ designation + ", alternativeMobile=" + alternativeMobile + "]";
	}
	public Employee(Long employeeId, String employeeName, LocalDate dateOfJoining, String mobile, String email,
			Double salary, String designation, String alternativeMobile) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.dateOfJoining = dateOfJoining;
		this.mobile = mobile;
		this.email = email;
		this.salary = salary;
		this.designation = designation;
		this.alternativeMobile = alternativeMobile;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

    

}
