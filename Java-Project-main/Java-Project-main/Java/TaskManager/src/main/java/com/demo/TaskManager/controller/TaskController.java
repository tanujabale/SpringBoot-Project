package com.demo.TaskManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.TaskManager.model.Task;
import com.demo.TaskManager.services.TaskService;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class TaskController {
@Autowired
	private TaskService taskservice;

@GetMapping("/register")
public String regiAdmin(Model model) {
	
	model.addAttribute("task", new Task());
	
	return "TaskRegestration";
	
}
@PostMapping("/taskstatus")
public String getadminStatus(@Validated @ModelAttribute("admin") Task task,BindingResult bindResult) {
	
	taskservice.saveTask(task);
	return "redirect:/displaytask";
}
}
