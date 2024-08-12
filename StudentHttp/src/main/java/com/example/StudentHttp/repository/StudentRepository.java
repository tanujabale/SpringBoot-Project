package com.example.StudentHttp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentHttp.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	 boolean existsByEmail(String email);

	    boolean existsByPhoneNumber(String phoneNumber);
	    
	    boolean existsByUsername(String username);

	    boolean existsByPassword(String password);
	    

}
