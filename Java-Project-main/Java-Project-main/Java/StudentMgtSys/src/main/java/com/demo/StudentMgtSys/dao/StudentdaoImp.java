package com.demo.StudentMgtSys.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.StudentMgtSys.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
public class StudentdaoImp implements Studentdao{

	private EntityManager entitymanager;


    @Autowired
	public StudentdaoImp(EntityManager entitymanager) {
		super();
		this.entitymanager = entitymanager;
	}


	public List<Student> getAllStudent() {
		TypedQuery<Student> student = entitymanager.createQuery("From Student", Student.class);
		List<Student> resultList = student.getResultList();
		return resultList;
	
	}


	@Override
	public Student findById(int id) {
		return entitymanager.find(Student.class, id);
	}


	@Override
	@Transactional
	public Student save(Student st) {
		Student dbstudent= entitymanager.merge(st);
		return dbstudent;
	}


	@Override
	@Transactional
	public String delete(int id ) {
		Student dbstudent= entitymanager.find(Student.class, id);
		entitymanager.remove(dbstudent);
		return "Deleted Id:"+id;
	}


}
