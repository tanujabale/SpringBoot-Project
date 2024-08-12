package com.demo.StudentMgtSys.dao;

import java.util.List;

import com.demo.StudentMgtSys.entity.Student;

public interface Studentdao {
	
	public List<Student> getAllStudent();

	public Student findById(int id);
	
	public Student save(Student st);
	
	public String delete(int id);
}
