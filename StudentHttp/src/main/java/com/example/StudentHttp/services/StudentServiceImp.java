package com.example.StudentHttp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentHttp.entity.Student;
import com.example.StudentHttp.repository.StudentRepository;



@Service
public class StudentServiceImp {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    
    public boolean isEmailExists(String email) {
        return studentRepository.existsByEmail(email);
    }

    public boolean isPhoneNumberExists(String phoneNumber) {
        return studentRepository.existsByPhoneNumber(phoneNumber);
    }

    public boolean isUsernameExists(String username) {
        return studentRepository.existsByUsername(username);
    }

    public boolean isPasswordExists(String password) {
        return studentRepository.existsByPassword(password);
    }
 }

