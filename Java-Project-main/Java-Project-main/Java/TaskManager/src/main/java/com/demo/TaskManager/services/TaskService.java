package com.demo.TaskManager.services;

import java.util.List;

import com.demo.TaskManager.model.Task;


public interface TaskService {
	public Task saveTask(Task task);
	public List<Task> TaskList();
	public void deleteById(int id);
	public Task fintById(int id);
	public Task updateTask(Task task);

}
