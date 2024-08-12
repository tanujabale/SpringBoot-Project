package com.demo.StudentMgtSys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.StudentMgtSys.dao.Studentdao;
import com.demo.StudentMgtSys.entity.Student;

@RestController
public class StudentController {
	private Studentdao studentDao;
    @Autowired
	public StudentController(Studentdao studentDao) {
		super();
		this.studentDao = studentDao;
	}
	@GetMapping("/")
    public List<Student> getAllStudent(){
    	return studentDao.getAllStudent();    }
	@GetMapping("/get/{id}")
	public Student getStudent(@PathVariable int id) {
		return studentDao.findById(id);
	}
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student st) {
		Student dbstudent= studentDao.save(st);
		return dbstudent;
	}
@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentDao.delete(id);
		
	}
@PutMapping("/update"+ "")
public Student updateStudent(@RequestBody Student st) {
	Student dbstudent= studentDao.save(st);
	return dbstudent;

	
}
}
