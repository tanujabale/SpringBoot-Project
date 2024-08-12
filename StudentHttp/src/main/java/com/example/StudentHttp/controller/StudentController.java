package com.example.StudentHttp.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.StudentHttp.entity.Student;
import com.example.StudentHttp.exception.DuplicateEntryException;
import com.example.StudentHttp.services.StudentServiceImp;

import jakarta.validation.Valid;

@Controller
public class StudentController {

    @Autowired
    private StudentServiceImp studentService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> registerStudent(@Valid @RequestBody Student student, BindingResult result) {
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            Map<String, String> fieldErrors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                fieldErrors.put(error.getField(), error.getDefaultMessage());
            }
            response.put("status", HttpStatus.BAD_REQUEST.value());
            response.put("errors", fieldErrors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if (studentService.isEmailExists(student.getEmail())) {
            throw new DuplicateEntryException("email", "Email already registered (Error Code: 409)");
        } else if (studentService.isPhoneNumberExists(student.getPhoneNumber())) {
            throw new DuplicateEntryException("phoneNumber", "Phone number already registered (Error Code: 409)");
        } else if (studentService.isUsernameExists(student.getUsername())) {
            throw new DuplicateEntryException("username", "Username already registered (Error Code: 409)");
        } else {
            studentService.saveStudent(student);
            response.put("status", HttpStatus.CREATED.value());
            response.put("message", "Registration successful");
            return new ResponseEntity<>(response, HttpStatus.CREATED); // 201
        }
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Optional<Student> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            model.addAttribute("student", student.get());
            return "update";
        } else {
            return "redirect:/students";
        }
    }

    @PostMapping("/students/update/{id}")
    public String updateStudent(@PathVariable("id") Long id, @Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
